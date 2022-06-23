package com.kaisu.feign.web.controller.rpc;

import com.kaisu.feign.application.service.UserService;
import com.kaisu.feign.domain.User;
import com.kaisu.feign.rpc.api.UserRpcApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

/**
 * @author kaisu
 */

@RequiredArgsConstructor
public class UserController implements UserRpcApi {
    private final UserService userService;

    @Override
    public ResponseEntity<User> getCurrentUser() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }
}
