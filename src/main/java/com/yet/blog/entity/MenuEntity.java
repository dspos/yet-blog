package com.yet.blog.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Ekko
 * @date 2022/4/9 17:51
 * @description MenuEntity
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tb_menu")
public class MenuEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "path")
    private String path;

    @Basic
    @Column(name = "component")
    private String component;

    @Basic
    @Column(name = "icon")
    private String icon;

    @Basic
    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Basic
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Basic
    @Column(name = "order_num")
    private Byte orderNum;

    @Basic
    @Column(name = "parent_id")
    private Integer parentId;

    @Basic
    @Column(name = "is_hidden")
    private Boolean isHidden;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        MenuEntity that = (MenuEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
