package com.yet.blog.repository;

import com.yet.blog.entity.ChatRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ekko
 *
 * @date 2022/4/15 16:28
 *
 * @description ChatRecordRepository
 */
@Repository
public interface ChatRecordRepository extends JpaRepository<ChatRecordEntity, Integer> {
}
