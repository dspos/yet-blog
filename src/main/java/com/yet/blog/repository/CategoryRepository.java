package com.yet.blog.repository;

import com.yet.blog.dto.CategoryBackDto;
import com.yet.blog.entity.CategoryEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ekko
 * @date 2022/4/12 23:25
 * @description CategoryRepository
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    /**
     * 查询后台分类列表
     *
     * @param pageable pageable
     * @return List<CategoryBackDto>
     */
    @Query(value = "select new com.yet.blog.dto.CategoryBackDto(c.id, c.categoryName, count(a.id) , c.createTime) " +
            "from CategoryEntity c left join ArticleEntity a on c.id = a.categoryId " +
            "group by c.id order by c.id asc")
    List<CategoryBackDto> listTagBackDto(Pageable pageable);

    /**
     * 根据分类名称查询分类
     *
     * @param categoryName categoryName
     * @return CategoryEntity
     */
    CategoryEntity findOneByCategoryName(String categoryName);
}
