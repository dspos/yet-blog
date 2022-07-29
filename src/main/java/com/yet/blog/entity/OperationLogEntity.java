package com.yet.blog.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Ekko
 *
 * @date 2022/4/9 17:51
 *
 * @description OperationLogEntity
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@EntityListeners(value = AuditingEntityListener.class)
@Table(name = "tb_operation_log")
public class OperationLogEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "opt_module")
    private String optModule;

    @Basic
    @Column(name = "opt_type")
    private String optType;

    @Basic
    @Column(name = "opt_url")
    private String optUrl;

    @Basic
    @Column(name = "opt_method")
    private String optMethod;

    @Basic
    @Column(name = "opt_desc")
    private String optDesc;

    @Basic
    @Column(name = "request_param")
    private String requestParam;

    @Basic
    @Column(name = "request_method")
    private String requestMethod;

    @Basic
    @Column(name = "response_data")
    private String responseData;

    @Basic
    @Column(name = "user_id")
    private Integer userId;

    @Basic
    @Column(name = "nickname")
    private String nickname;

    @Basic
    @Column(name = "ip_address")
    private String ipAddress;

    @Basic
    @Column(name = "ip_source")
    private String ipSource;

    @Basic
    @CreatedDate
    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Basic
    @LastModifiedDate
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        OperationLogEntity that = (OperationLogEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
