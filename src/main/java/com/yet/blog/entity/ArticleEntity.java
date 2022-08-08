package com.yet.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
 * @description ArticleEntity
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@EntityListeners(value = AuditingEntityListener.class)
@Table(name = "tb_article")
public class ArticleEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "user_id")
    private Integer userId;

    @Basic
    @Column(name = "category_id")
    private Integer categoryId;

    @Basic
    @Column(name = "article_cover")
    private String articleCover;

    @Basic
    @Column(name = "article_title")
    private String articleTitle;

    @Basic
    @Column(name = "article_content")
    private String articleContent;

    @Basic
    @Column(name = "type")
    private Integer type;

    @Basic
    @Column(name = "original_url")
    private String originalUrl;

    @Basic
    @Column(name = "is_top")
    private Integer isTop;

    @Basic
    @Column(name = "is_delete")
    private Integer isDelete;

    @Basic
    @Column(name = "status")
    private Integer status;

    @Basic
    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;

    @Basic
    @LastModifiedDate
    @Column(name = "update_time")
    private Date updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        ArticleEntity that = (ArticleEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
