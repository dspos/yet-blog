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
 * @description FriendLinkEntity
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tb_friend_link")
public class FriendLinkEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "link_name")
    private String linkName;

    @Basic
    @Column(name = "link_avatar")
    private String linkAvatar;

    @Basic
    @Column(name = "link_address")
    private String linkAddress;

    @Basic
    @Column(name = "link_intro")
    private String linkIntro;

    @Basic
    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Basic
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
        FriendLinkEntity that = (FriendLinkEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
