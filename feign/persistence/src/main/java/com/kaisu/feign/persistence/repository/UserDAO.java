package com.kaisu.feign.persistence.repository;

import com.kaisu.feign.persistence.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author kaisu
 */
@Repository
public interface UserDAO extends JpaRepository<UserDO, String> {
    /**
     * 根据用户id获取
     *
     * @param userId 用户id
     * @return 用户
     */
    Optional<UserDO> findUserDOByUserId(String userId);
}
