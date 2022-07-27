package com.yet.blog.controller;

import com.yet.blog.dto.ArchiveDto;
import com.yet.blog.dto.ArticleBackDTO;
import com.yet.blog.dto.ArticleHomeDto;
import com.yet.blog.result.PageResult;
import com.yet.blog.result.Result;
import com.yet.blog.service.ArticleService;
import com.yet.blog.vo.ConditionVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ekko
 * @date 2022/4/13 19:09
 * @description ArticleController
 */
@Tag(name = "Article", description = "文章接口")
@RestController
@RequestMapping("api")
public class ArticleController {

  private final ArticleService articleService;

  public ArticleController(ArticleService articleService) {
    this.articleService = articleService;
  }

  @Operation(summary = "查看文章归档", description = "查看文章归档")
  @GetMapping("article/archives/{page}/{size}")
  public Result<PageResult<ArchiveDto>> listArchives(
      @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
    return Result.ok(articleService.listArchives(page, size));
  }

  @Operation(summary = "查看首页文章", description = "查看首页文章")
  @GetMapping("/articles/{page}/{size}")
  public Result<List<ArticleHomeDto>> listArticles(
      @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
    return Result.ok(articleService.listArticles(page, size));
  }

  @Operation(summary = "查看后台文章")
  @GetMapping("/admin/articles/{page}/{size}")
  public Result<PageResult<ArticleBackDTO>> listArticleBacks(
      @PathVariable("page") Integer page,
      @PathVariable("size") Integer size,
      ConditionVO conditionVO) {
    return Result.ok(articleService.listArticleBacks(page, size, conditionVO));
  }
}
