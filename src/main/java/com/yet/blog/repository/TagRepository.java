package com.yet.blog.repository;

import com.yet.blog.dto.TagBackDto;
import com.yet.blog.entity.TagEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ekko
 * @date 2022/4/9 18:23
 * @description TagRepository
 */
@Repository
public interface TagRepository extends JpaRepository<TagEntity, Integer> {

    /**
     * 查询后台标签列表
     *
     * @param pageable pageable
     * @return {@link List<TagBackDto>} 标签列表
     */

    @Query(value = "select new com.yet.blog.dto.TagBackDto(t.id, t.tagName,count(at.articleId), t.createTime) " +
            "from TagEntity t left join ArticleTagEntity at on t.id = at.tagId " +
            "group by t.id order by t.id desc")
    List<TagBackDto> listTagBackDto(Pageable pageable);

    /**
     * 根据标签名查询标签
     * @param tagName tagName
     * @return TagEntity
     */
    TagEntity findOneByTagName(String tagName);
}
