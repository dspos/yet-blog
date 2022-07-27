package com.yet.blog.service.impl;

import com.yet.blog.dto.CategoryBackDto;
import com.yet.blog.dto.CategoryDto;
import com.yet.blog.entity.CategoryEntity;
import com.yet.blog.exception.BusinessException;
import com.yet.blog.repository.CategoryRepository;
import com.yet.blog.result.PageResult;
import com.yet.blog.service.CategoryService;
import com.yet.blog.util.BeanCopyUtil;
import com.yet.blog.vo.CategoryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ekko
 * @date 2022/4/12 23:27
 * @description CategoryServiceImpl
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public PageResult<CategoryDto> listCategories(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        List<CategoryEntity> categoryList = categoryRepository.findAll(pageable).getContent();
        List<CategoryDto> categoryDtoList = BeanCopyUtil.copyBeanList(categoryList, CategoryDto.class);
        Integer count = Math.toIntExact(categoryRepository.count());
        return new PageResult<>(categoryDtoList, count);
    }

    @Override
    public PageResult<CategoryBackDto> listBackCategories(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        List<CategoryBackDto> categoryBackDtoList = categoryRepository.listTagBackDto(pageable);
        Integer count = Math.toIntExact(categoryRepository.count());
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
