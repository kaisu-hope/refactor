package com.kaisu.feign.persistence.repository;

import com.kaisu.feign.domain.User;

/**
 * @author kaisu
 */
public interface UserRepository {
    /**
     * 根据用户id 获取用户
     *
     * @param userId 用户id
     * @return 用户
     */
    User findUserById(String userId);
}
