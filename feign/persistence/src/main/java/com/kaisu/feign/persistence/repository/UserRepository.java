package com.kaisu.feign.persistence.repository;

import com.kaisu.feign.persistence.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kaisu
 */
@Repository
public interface UserRepository extends JpaRepository<UserDO, String> {

}
