package com.yet.blog.service;

import com.yet.blog.dto.CategoryBackDto;
import com.yet.blog.dto.CategoryDto;
import com.yet.blog.result.PageResult;
import com.yet.blog.vo.CategoryVO;

import java.util.List;

/**
 * @author Ekko
 *
 * @date 2022/4/12 23:27
 *
 * @description CategoryService
 */
public interface CategoryService {

    /**
     * 查询分类列表
     *
     * @param page
     *            page
     * @param size
     *            size
     *
     * @return {@link List<CategoryDto>} 标签列表
     */
    PageResult<CategoryDto> listCategories(Integer page, Integer size);

    /**
     * 查询后台分类列表
     *
     * @param page
     *            page
     * @param size
     *            size
     *
     * @return
     */
    PageResult<CategoryBackDto> listBackCategories(Integer page, Integer size);

    /**
     * 新增或修改分类
     *
     * @param categoryVO
     *            categoryVO
     */
    void saveOrUpdateCategory(CategoryVO categoryVO);

    /**
     * 删除分类
     *
     * @param ids
     *            ids
     */
    void deleteCategory(List<Integer> ids);
}
