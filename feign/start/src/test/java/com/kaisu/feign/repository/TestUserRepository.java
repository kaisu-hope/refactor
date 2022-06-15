package com.kaisu.feign.repository;

import com.kaisu.feign.core.DatabaseTestConfiguration;
import com.kaisu.feign.persistence.UserDO;
import com.kaisu.feign.persistence.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * @author kaisu
 */
@DataJpaTest
@Import(DatabaseTestConfiguration.class)
@AutoConfigureTestDatabase(replace = NONE)
public class TestUserRepository {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test_db_connection() {
        userRepository.save(UserDO.builder().id("1").userId("1").createTime(LocalDateTime.now()).updateTime(LocalDateTime.now()).build());
        System.out.println(userRepository.findAll());
    }
}
