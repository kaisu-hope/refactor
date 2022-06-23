package com.kaisu.feign.persistence.convert;

import com.kaisu.feign.domain.User;
import com.kaisu.feign.persistence.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author kaisu
 */
@Mapper(componentModel = "spring")
public interface UserConvert {
    /**
     * 转换为User domain
     *
     * @param userDO userDO
     * @return User
     */

    @Mapping(source = "userId", target = "userId")
    User toUser(UserDO userDO);
}
