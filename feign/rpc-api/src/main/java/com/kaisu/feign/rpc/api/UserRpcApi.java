package com.kaisu.feign.rpc.api;

import com.kaisu.feign.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

/**
 * @author kaisu
 */
@FeignClient(name = "user-rpc",
        path = "/rpc/user")
public interface UserRpcApi {
    /**
     * 获取当前登录用户
     *
     * @return user
     */
    ResponseEntity<User> getCurrentUser();
}
