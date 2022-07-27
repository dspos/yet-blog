package com.yet.blog.service;

import com.yet.blog.dto.ArchiveDto;
import com.yet.blog.dto.ArticleBackDTO;
import com.yet.blog.dto.ArticleHomeDto;
import com.yet.blog.result.PageResult;
import com.yet.blog.vo.ConditionVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ekko
 * @date 2022/4/13 23:24
 * @description ArticleService
 */
@Service
public interface ArticleService {

  /**
   * 文章归档
   *
   * @param page page
   * @param size size
   * @return Page<ArchiveDto>
   */
  PageResult<ArchiveDto> listArchives(Integer page, Integer size);

  /**
   * 查看首页文章
   *
   * @param page page
   * @param size size
   * @return List<ArticleHomeDto>
   */
  List<ArticleHomeDto> listArticles(Integer page, Integer size);

  /**
   * 查看后台文章
   *
   * @param conditionVO conditionVO
   * @return PageResult<ArticleBackDTO>
   */
  PageResult<ArticleBackDTO> listArticleBacks(Integer page, Integer size, ConditionVO conditionVO);
}
