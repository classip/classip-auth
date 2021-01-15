package com.pyjava.classip.auth.feign;

import com.pyjava.classip.user.dto.UserDetailForAuthDTO;
import org.springframework.stereotype.Component;

/**
 * <p>描述: 用户feign调用异常返回 </p>
 *
 * @author zhaojj11
 * @date 2021/1/4 14:02
 * @since v1.0.0-SNAPSHOT
 */
@Component
public class UserFeignClientFallback implements UserFeignClient {

    /**
     * 根据username查询用户
     *
     * @param username 用户名
     * @return 用户详细信息传数对象
     * @see UserDetailForAuthDTO
     */
    @Override
    public UserDetailForAuthDTO findUserDetailForAuthByUsername(String username) {
        return null;
    }
}
