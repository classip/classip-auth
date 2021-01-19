package com.pyjava.classip.auth.service;

import com.pyjava.classip.user.dto.MenuAuthDetailDTO;
import com.pyjava.classip.user.dto.RoleAuthDetailDTO;
import com.pyjava.classip.user.dto.UserAuthDetailDTO;
import lombok.SneakyThrows;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>描述: 用户服务 </p>
 *
 * @author zhaojj11
 * @date 2021/1/15 16:08
 * @since v1.0.0-SNAPSHOT
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthDetailDTO user = userService.findUserDetailForAuthByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        // 可用性 :true:可用 false:不可用
        boolean enabled = true;
        // 过期性 :true:没过期 false:过期
        boolean accountNonExpired = true;
        // 有效性 :true:凭证有效 false:凭证无效
        boolean credentialsNonExpired = true;
        // 锁定性 :true:未锁定 false:已锁定
        boolean accountNonLocked = true;
        List<RoleAuthDetailDTO> roles = user.getRoles();
        for (RoleAuthDetailDTO role : roles) {
            //角色必须是ROLE_开头，可以在数据库中设置
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getName());
            grantedAuthorities.add(grantedAuthority);
            //获取权限
            List<MenuAuthDetailDTO> menus = role.getMenus();

            for (MenuAuthDetailDTO menu : menus) {
                GrantedAuthority authority = new SimpleGrantedAuthority(menu.getName());
                grantedAuthorities.add(authority);
            }
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
    }
}
