package com.yet.blog.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicInsert;
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
import java.util.Date;
import java.util.Objects;

/**
 * @author Ekko
 * @date 2022/4/9 17:51
 * @description TagEntity
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@DynamicInsert
@EntityListeners(value = AuditingEntityListener.class)
@Table(name = "tb_tag")
public class TagEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "tag_name", nullable = false)
    private String tagName;

    @CreatedDate
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @LastModifiedDate
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        TagEntity tagEntity = (TagEntity) o;
        return id != null && Objects.equals(id, tagEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
