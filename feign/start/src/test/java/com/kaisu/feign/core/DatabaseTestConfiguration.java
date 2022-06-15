package com.kaisu.feign.core;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import javax.sql.DataSource;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * @author kaisu
 */
@AutoConfigureTestDatabase(replace = NONE)
public class DatabaseTestConfiguration {
    @Bean(initMethod = "start", destroyMethod = "stop")
    public PostgreSQLContainer<?> postgreSqlContainer() {
        try (var postgreSql = new PostgreSQLContainer<>("postgres:latest")) {
            postgreSql.waitingFor(Wait.forListeningPort());
            return postgreSql;
        }
    }

    @Bean
    @FlywayDataSource
    public DataSource dataSource(PostgreSQLContainer<?> postgreSqlContainer) {
        var hikerConfig = new HikariConfig();
        hikerConfig.setJdbcUrl(postgreSqlContainer.getJdbcUrl());
        hikerConfig.setUsername(postgreSqlContainer.getUsername());
        hikerConfig.setPassword(postgreSqlContainer.getPassword());
        return new HikariDataSource(hikerConfig);
    }
}
