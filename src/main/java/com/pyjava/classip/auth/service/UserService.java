package com.pyjava.classip.auth.service;

import com.pyjava.classip.auth.feign.UserFeignClient;
import com.pyjava.classip.user.dto.UserAuthDetailDTO;
import org.springframework.stereotype.Service;

/**
 * <p>描述: 用户服务 </p>
 *
 * @author zhaojj11
 * @date 2021/1/15 16:01
 * @since v1.0.0-SNAPSHOT
 */
@Service
public class UserService {
    private final UserFeignClient userFeignClient;

    public UserService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    /**
     * 通过用户名查询用户认证详细信息
     *
     * @param username 用户名
     * @return 用户认证详细信息
     * @see UserAuthDetailDTO
     */
    public UserAuthDetailDTO findUserDetailForAuthByUsername(String username) throws Exception {
        return userFeignClient.findUserDetailForAuthByUsername(username);
    }
}
