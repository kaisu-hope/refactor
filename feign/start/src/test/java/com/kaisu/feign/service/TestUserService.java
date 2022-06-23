package com.kaisu.feign.service;

import com.kaisu.feign.FeignBootstrap;
import com.kaisu.feign.application.service.UserService;
import com.kaisu.feign.core.DatabaseTestConfiguration;
import com.kaisu.feign.persistence.UserDO;
import com.kaisu.feign.persistence.repository.UserDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.time.OffsetDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * @author kaisu
 */
@SpringBootTest(classes = FeignBootstrap.class)
@Import(DatabaseTestConfiguration.class)
@AutoConfigureTestDatabase(replace = NONE)
public class TestUserService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDAO userDAO;

    @Test
    void test_get_current_user() {
        var userDO = new UserDO();
        userDO.setUserId("1");
        userDO.setCreateTime(OffsetDateTime.now());
        userDO.setUpdateTime(OffsetDateTime.now());
        userDAO.save(userDO);
        var currentUser = userService.getCurrentUser();
        assertThat(userDO.getUserId(), is(currentUser.getUserId()));
        userDAO.delete(userDO);
    }
}
