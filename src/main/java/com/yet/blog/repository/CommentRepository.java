package com.yet.blog.repository;

import com.yet.blog.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ekko
 * @date 2022/4/15 16:29
 * @description CommentRepository
 */
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
}
