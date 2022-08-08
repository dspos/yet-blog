package com.yet.blog.controller;

import com.yet.blog.dto.ArchiveDto;
import com.yet.blog.dto.ArticleBackDTo;
import com.yet.blog.dto.ArticleHomeDto;
import com.yet.blog.result.PageResult;
import com.yet.blog.result.Result;
import com.yet.blog.service.ArticleService;
import com.yet.blog.vo.ArticleDeleteVO;
import com.yet.blog.vo.ArticleTopVO;
import com.yet.blog.vo.ArticleVO;
import com.yet.blog.vo.ConditionVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Ekko
 * @date 2022/4/13 19:09
 * @description ArticleController
 */
@Tag(name = "Article", description = "Article Module")
@RestController
@RequestMapping("api")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Operation(summary = "list archives article")
    @GetMapping("article/archives/{page}/{size}")
    public Result<PageResult<ArchiveDto>> listArchives(
            @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return Result.ok(articleService.listArchives(page, size));
    }

    @Operation(summary = "list homepage article")
    @GetMapping("/articles/{page}/{size}")
    public Result<List<ArticleHomeDto>> listArticles(
            @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return Result.ok(articleService.listArticles(page, size));
    }

    @Operation(summary = "list backend article")
    @GetMapping("/admin/articles/{page}/{size}")
    public Result<PageResult<ArticleBackDTo>> listArticleBacks(
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size,
            ConditionVO conditionVO) {
        return Result.ok(articleService.listArticleBacks(page, size, conditionVO));
    }

    @Operation(summary = "insert or update article")
    @PostMapping("admin/articles")
    public Result<Void> saveOrUpdateArticle(@Valid @RequestBody ArticleVO articleVO) {
        articleService.saveOrUpdateArticle(articleVO);
        return Result.ok();
    }

    @Operation(summary = "update top article")
    @PutMapping("/admin/articles/top")
    public Result<Void> updateArticleTop(@Valid @RequestBody ArticleTopVO articleTopVO) {
        articleService.updateArticleTop(articleTopVO);
        return Result.ok();
    }

    @Operation(summary = "recover or delete article")
    @PutMapping("/admin/articles")
    public Result<Void> updateArticleDelete(@Valid @RequestBody ArticleDeleteVO articleDeleteVO) {
        articleService.updateArticleDelete(articleDeleteVO);
        return Result.ok();
    }

    @Operation(summary = "upload article images")
    public Result<String> uploadAtricleImages(MultipartFile file) {
        return Result.ok();
    }
}
