package com.kaisu.feign.application.service.impl;

import com.kaisu.feign.application.service.UserService;
import com.kaisu.feign.domain.User;
import com.kaisu.feign.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

/**
 * @author kaisu
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getCurrentUser() {
        //获取用户id(通过网关，或者上下文)
        var userId = "1";
        if (Strings.isEmpty(userId)) {
            throw new RuntimeException("请先登录");
        }
        return userRepository.findUserById(userId);
    }
}
