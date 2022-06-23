package com.kaisu.feign.application.service;

import com.kaisu.feign.domain.User;

/**
 * @author kaisu
 */
public interface UserService {
    /**
     * 获取当前登录用户
     *
     * @return user
     */
    User getCurrentUser();
}
