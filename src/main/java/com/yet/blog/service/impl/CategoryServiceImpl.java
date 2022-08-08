package com.yet.blog.service.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yet.blog.dto.CategoryBackDto;
import com.yet.blog.dto.CategoryDto;
import com.yet.blog.entity.CategoryEntity;
import com.yet.blog.entity.QArticleEntity;
import com.yet.blog.entity.QCategoryEntity;
import com.yet.blog.exception.BusinessException;
import com.yet.blog.repository.CategoryRepository;
import com.yet.blog.result.PageResult;
import com.yet.blog.service.CategoryService;
import com.yet.blog.util.BeanCopyUtil;
import com.yet.blog.vo.CategoryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ekko
 * @date 2022/4/12 23:27
 * @description CategoryServiceImpl
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final JPAQueryFactory jpaQueryFactory;

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(
            JPAQueryFactory jpaQueryFactory, CategoryRepository categoryRepository) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public PageResult<CategoryDto> listCategories(Integer page, Integer size) {
        var pageable = PageRequest.of(page - 1, size);
        var categoryList = categoryRepository.findAll(pageable).getContent();
        var categoryDtoList = BeanCopyUtil.copyBeanList(categoryList, CategoryDto.class);
        var count = Math.toIntExact(categoryRepository.count());
        return new PageResult<>(categoryDtoList, count);
    }

    @Override
    public PageResult<CategoryBackDto> listBackCategories(Integer page, Integer size) {
        var qCategory = QCategoryEntity.categoryEntity;
        var qArticle = QArticleEntity.articleEntity;
        var bean =
                Projections.bean(
                        CategoryBackDto.class,
                        qCategory.id,
                        qCategory.categoryName,
                        qArticle.id.count().as("articleCount"),
                        qCategory.createTime);
        var categoryBackDtoList =
                jpaQueryFactory
                        .select(bean)
                        .from(qCategory)
                        .leftJoin(qArticle)
                        .on(qCategory.id.eq(qArticle.categoryId))
                        .groupBy(qCategory.id)
                        .orderBy(qCategory.id.asc())
                        .offset((long) (page - 1) * size)
                        .limit(size)
                        .stream()
                        .collect(Collectors.toList());
        var count = Math.toIntExact(categoryRepository.count());
        return new PageResult<>(categoryBackDtoList, count);
    }

    @Override
    public void saveOrUpdateCategory(CategoryVO categoryVO) {
        CategoryEntity tag = new CategoryEntity();
        CategoryEntity exist = categoryRepository.findOneByCategoryName(categoryVO.getCategoryName());
        if (exist != null) {
            throw new BusinessException("分类已存在");
        }
        BeanUtils.copyProperties(categoryVO, tag);
        categoryRepository.save(tag);
    }

    @Override
    public void deleteCategory(List<Integer> ids) {
        categoryRepository.deleteAllById(ids);
    }
}
