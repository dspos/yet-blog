package com.yet.blog.repository;

import com.yet.blog.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ekko
 * @date 2022/4/12 23:25
 * @description CategoryRepository
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    /**
     * 根据分类名称查询分类
     *
     * @param categoryName categoryName
     * @return CategoryEntity
     */
    CategoryEntity findOneByCategoryName(String categoryName);
}
