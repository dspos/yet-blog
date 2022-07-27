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
 * @description ChatRecordEntity
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tb_chat_record")
public class ChatRecordEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "user_id")
    private Integer userId;

    @Basic
    @Column(name = "nickname")
    private String nickname;

    @Basic
    @Column(name = "avatar")
    private String avatar;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "ip_address")
    private String ipAddress;

    @Basic
    @Column(name = "ip_source")
    private String ipSource;

    @Basic
    @Column(name = "type")
    private Byte type;

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
        ChatRecordEntity that = (ChatRecordEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
