package com.kaisu.feign.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author kaisu
 */
@Data
@Builder
@Setter(value = AccessLevel.PRIVATE)
public class User implements Serializable {
    /**
     * 主键
     */
    private String id;
    /**
     * 用户id
     */
    private String userId;
}
