package com.yet.blog.repository;

import com.yet.blog.entity.OperationLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ekko
 * @date 2022/4/9 19:45
 * @description OperationLogRepository
 */
@Repository
public interface OperationLogRepository extends JpaRepository<OperationLogEntity, Integer> {
}
