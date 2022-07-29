package com.yet.blog.service;

import com.yet.blog.dto.ArchiveDto;
import com.yet.blog.dto.ArticleBackDTO;
import com.yet.blog.dto.ArticleHomeDto;
import com.yet.blog.result.PageResult;
import com.yet.blog.vo.ArticleDeleteVO;
import com.yet.blog.vo.ArticleTopVO;
import com.yet.blog.vo.ArticleVO;
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
     * article archives
     *
     * @param page page
     * @param size size
     * @return Page<ArchiveDto>
     */
    PageResult<ArchiveDto> listArchives(Integer page, Integer size);

    /**
     * list homepage articles
     *
     * @param page page
     * @param size size
     * @return List<ArticleHomeDto>
     */
    List<ArticleHomeDto> listArticles(Integer page, Integer size);

    /**
     * list backend articles
     *
     * @param conditionVO conditionVO
     * @return PageResult<ArticleBackDTO>
     */
    PageResult<ArticleBackDTO> listArticleBacks(Integer page, Integer size, ConditionVO conditionVO);

    /**
     * save or update article
     *
     * @param articleVO articleVO
     */
    void saveOrUpdateArticle(ArticleVO articleVO);

    /**
     * update top article
     *
     * @param articleTopVO articleTopVO
     */
    void updateArticleTop(ArticleTopVO articleTopVO);

    /**
     * recover or delete article
     *
     * @param articleDeleteVO articleDeleteVO
     */
    void updateArticleDelete(ArticleDeleteVO articleDeleteVO);
}
