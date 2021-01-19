package com.pyjava.classip.auth.feign;

import com.pyjava.classip.user.dto.UserAuthDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>描述: userFeign </p>
 *
 * @author zhaojj11
 * @date 2021/1/4 14:02
 * @since v1.0.0-SNAPSHOT
 */
@Primary
@FeignClient(name = "classip-user-provider", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    /**
     * 根据username查询用户
     *
     * @param username 用户名
     * @return 用户详细信息传数对象
     * @throws Exception 异常
     * @see UserAuthDetailDTO
     */
    @GetMapping(value = "/user/auth/detail/{username}", produces = {"application/json"})
    UserAuthDetailDTO findUserDetailForAuthByUsername(@PathVariable String username) throws Exception;
}
