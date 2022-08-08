package com.yet.blog.controller;

import com.yet.blog.annotation.OptLog;
import com.yet.blog.dto.CategoryBackDto;
import com.yet.blog.dto.CategoryDto;
import com.yet.blog.result.PageResult;
import com.yet.blog.result.Result;
import com.yet.blog.service.CategoryService;
import com.yet.blog.vo.CategoryVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.yet.blog.constant.OptTypeConst.DELETE;
import static com.yet.blog.constant.OptTypeConst.SAVE_OR_UPDATE;

/**
 * @author Ekko
 * @date 2022/4/12 23:24
 * @description CategoryController
 */
@Tag(name = "Category", description = "分类接口")
@RestController
@RequestMapping("api")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "查询分类列表", description = "查询分类列表")
    @GetMapping("categories/{page}/{size}")
    public Result<PageResult<CategoryDto>> listCategories(
            @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return Result.ok(categoryService.listCategories(page, size));
    }

    @Operation(summary = "查询后台分类列表", description = "查询后台分类列表")
    @GetMapping("admin/categories/{page}/{size}")
    public Result<PageResult<CategoryBackDto>> listBackCategories(
            @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return Result.ok(categoryService.listBackCategories(page, size));
    }

    @Operation(summary = "新增或修改分类", description = "新增或修改分类")
    @OptLog(optType = SAVE_OR_UPDATE)
    @PostMapping("admin/categories")
    public Result<Void> saveOrUpdateTag(@Valid @RequestBody CategoryVO categoryVO) {
        categoryService.saveOrUpdateCategory(categoryVO);
        return Result.ok();
    }

    @Operation(summary = "删除分类", description = "删除分类")
    @OptLog(optType = DELETE)
    @DeleteMapping("/admin/categories")
    public Result<Void> deleteCategories(@RequestBody List<Integer> ids) {
        categoryService.deleteCategory(ids);
        return Result.ok();
    }
}
