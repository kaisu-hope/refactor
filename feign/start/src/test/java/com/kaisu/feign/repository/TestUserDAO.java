package com.kaisu.feign.repository;

import com.kaisu.feign.persistence.UserDO;
import com.kaisu.feign.persistence.repository.UserDAO;
import com.kaisu.feign.core.DatabaseTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.OffsetDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * @author kaisu
 */
@DataJpaTest
@Import(DatabaseTestConfiguration.class)
@AutoConfigureTestDatabase(replace = NONE)
public class TestUserDAO {
    @Autowired
    private UserDAO userDAO;

    @Test
    void test_db_connection() {
        var userDO = new UserDO();
        userDO.setUserId("1");
        userDO.setCreateTime(OffsetDateTime.now());
        userDO.setUpdateTime(OffsetDateTime.now());
        userDO = userDAO.save(userDO);
        assertThat(userDO.getUserId(), is("1"));
    }
}
