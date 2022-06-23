package com.kaisu.feign.persistence;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * @author kaisu
 */

@Getter
@Setter
@ToString
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Embeddable
@Table(name = "\"user\"")
public class UserDO {
    /**
     * 主键
     */
    @Id
    @GeneratedValue( generator = "snowFlakeId")
    @GenericGenerator(name = "snowFlakeId", strategy = "com.kaisu.feign.persistence.id.SnowFlakeIdGenerator")
    private String id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 创建时间
     */
    @CreatedDate
    private OffsetDateTime createTime;
    /**
     * 更新时间
     */
    @LastModifiedDate
    private OffsetDateTime updateTime;
}
