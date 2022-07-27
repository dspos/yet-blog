package com.yet.blog.repository;

import com.yet.blog.entity.ArticleTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ekko
 */
@Repository
public interface ArticleTagRepository extends JpaRepository<ArticleTagEntity, Integer> {
}
