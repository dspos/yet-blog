package com.yet.blog.repository;

import com.yet.blog.dto.ArticleBackDTo;
import com.yet.blog.entity.ArticleEntity;
import com.yet.blog.vo.ConditionVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ekko
 * @date 2022/4/13 19:11
 * @description ArticleRepository
 */
@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer>,
        JpaSpecificationExecutor<ArticleEntity>, QuerydslPredicateExecutor<ArticleEntity> {

    @Query(value = "SELECT COUNT (DISTINCT a.id) "
            + "FROM tb_article a LEFT JOIN tb_article_tag tat ON a.id = tat.article_id \n"
            + "WHERE is_delete = :#{#conditionVO.isDelete} AND status = :#{#conditionVO.status} AND categoryId = :#{#conditionVO.categoryId} \n"
            + "AND type = :#{#conditionVO.type} AND tat.tag_id = :#{#conditionVO.tagId}", nativeQuery = true)
    Integer countArticleBacks(ConditionVO conditionVO);

    @Query(value = "SELECT a.id,article_cover,article_title,type,is_top,a.is_delete,a.status,a.create_time,category_name,t.id AS tag_id,t.tag_name \n"
            + "FROM (SELECT id,article_cover,article_title,type,is_top,is_delete,status,create_time,category_id FROM tb_article \n"
            + "WHERE is_delete = :#{#conditionVO.isDelete} AND status = :#{#conditionVO.status} AND categoryId = :#{#conditionVO.categoryId} \n"
            + " AND id IN (SELECT article_id FROM tb_article_tag WHERE tag_id = :#{#conditionVO.tagId}) ORDER BY is_top DESC,id DESC LIMIT :page OFFSET :size) a \n"
            + "LEFT JOIN tb_category c ON a.category_id = c.id LEFT JOIN tb_article_tag atg ON a.id = atg.article_id LEFT JOIN tb_tag t ON t.id = atg.tag_id "
            + "ORDER BY is_top DESC,a.id DESC", nativeQuery = true)
    List<ArticleBackDTo> listArticleBacks(Integer page, Integer size, ConditionVO conditionVO);
}
