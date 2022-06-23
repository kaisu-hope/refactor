package com.kaisu.feign.persistence.repository.impl;

import com.kaisu.feign.persistence.UserDO;
import com.kaisu.feign.persistence.convert.UserConvert;
import com.kaisu.feign.persistence.repository.UserDAO;
import com.kaisu.feign.domain.User;
import com.kaisu.feign.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author kaisu
 */
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserDAO userDAO;
    private final UserConvert userConvert;

    @Override
    public User findUserById(String userId) {
        Optional<UserDO> userDO = userDAO.findUserDOByUserId(userId);
        userDO.orElseThrow(() -> new RuntimeException("用户不存在！"));
        return userConvert.toUser(userDO.get());
    }
}
