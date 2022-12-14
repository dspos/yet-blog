package com.yet.blog.service.impl;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.SubQueryExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.sql.JPASQLQuery;
import com.querydsl.sql.DerbyTemplates;
import com.querydsl.sql.SQLExpressions;
import com.querydsl.sql.SQLTemplates;
import com.yet.blog.dto.ArchiveDto;
import com.yet.blog.dto.ArticleBackDTo;
import com.yet.blog.dto.ArticleBackDToTemp;
import com.yet.blog.dto.ArticleHomeDto;
import com.yet.blog.dto.ArticleHomeDtoTemp;
import com.yet.blog.dto.TagDto;
import com.yet.blog.entity.ArticleEntity;
import com.yet.blog.entity.ArticleTagEntity;
import com.yet.blog.entity.CategoryEntity;
import com.yet.blog.entity.QArticleEntity;
import com.yet.blog.entity.QArticleTagEntity;
import com.yet.blog.entity.QCategoryEntity;
import com.yet.blog.entity.QTagEntity;
import com.yet.blog.entity.TagEntity;
import com.yet.blog.repository.ArticleRepository;
import com.yet.blog.repository.ArticleTagRepository;
import com.yet.blog.repository.CategoryRepository;
import com.yet.blog.repository.TagRepository;
import com.yet.blog.result.PageResult;
import com.yet.blog.service.ArticleService;
import com.yet.blog.util.BeanCopyUtil;
import com.yet.blog.vo.ArticleDeleteVO;
import com.yet.blog.vo.ArticleTopVO;
import com.yet.blog.vo.ArticleVO;
import com.yet.blog.vo.ConditionVO;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.yet.blog.constant.CommonConst.DRAFT;
import static com.yet.blog.constant.CommonConst.FALSE;
import static com.yet.blog.constant.CommonConst.PUBLIC;

/**
 * @author Ekko
 * @date 2022/4/13 23:25
 * @description ArticleServiceImpl
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @PersistenceContext
    EntityManager entityManager;

    SQLTemplates templates = new DerbyTemplates();

    JPASQLQuery<?> jpaSqlQuery = new JPASQLQuery<Void>(entityManager, templates);

    private final JPAQueryFactory jpaQueryFactory;

    private final ArticleRepository articleRepository;

    private final CategoryRepository categoryRepository;

    private final TagRepository tagRepository;

    private final ArticleTagRepository articleTagRepository;

    public ArticleServiceImpl(
            JPAQueryFactory jpaQueryFactory,
            ArticleRepository articleRepository,
            CategoryRepository categoryRepository,
            TagRepository tagRepository,
            ArticleTagRepository articleTagRepository) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
        this.articleTagRepository = articleTagRepository;
    }

    @Override
    public PageResult<ArchiveDto> listArchives(Integer page, Integer size) {
        var qArticle = QArticleEntity.articleEntity;
        var articleList =
                jpaQueryFactory
                        .select(qArticle)
                        .from(qArticle)
                        .where(qArticle.status.eq(PUBLIC), qArticle.isDelete.eq(FALSE))
                        .offset((long) (page - 1) * size)
                        .limit(size)
                        .stream()
                        .collect(Collectors.toList());
        var archiveDtoList = BeanCopyUtil.copyBeanList(articleList, ArchiveDto.class);
        var count = Math.toIntExact(articleRepository.count());
        return new PageResult<>(archiveDtoList, count);
    }

    @SneakyThrows
    @Override
    public List<ArticleHomeDto> listArticles(Integer page, Integer size) {
        var qArticle = QArticleEntity.articleEntity;
        var qArticleTag = QArticleTagEntity.articleTagEntity;
        var qCategory = QCategoryEntity.categoryEntity;
        var qTag = QTagEntity.tagEntity;
        var bean =
                Projections.bean(
                        ArticleHomeDtoTemp.class,
                        qArticle.id,
                        qArticle.articleCover,
                        qArticle.articleTitle,
                        qArticle.articleContent.substring(0, 500).as("articleContent"),
                        qArticle.createTime,
                        qArticle.type,
                        qArticle.isTop,
                        qArticle.categoryId,
                        qCategory.categoryName,
                        qTag.id.as("tagId"),
                        qTag.tagName);
        List<ArticleHomeDtoTemp> homeDtoTempList =
                jpaQueryFactory
                        .select(bean)
                        .from(qArticle)
                        .join(qCategory)
                        .on(qArticle.categoryId.eq(qCategory.id))
                        .join(qArticleTag)
                        .on(qArticle.id.eq(qArticleTag.articleId))
                        .join(qTag)
                        .on(qTag.id.eq(qArticleTag.tagId))
                        .where(qArticle.status.eq(PUBLIC), qArticle.isDelete.eq(FALSE))
                        .orderBy(qArticle.id.desc(), qArticle.isTop.desc())
                        .offset((long) (page - 1) * size)
                        .limit(size)
                        .stream()
                        .collect(Collectors.toList());
        return new ArrayList<>(
                homeDtoTempList.stream()
                        .map(
                                articleHomeDtoTemp -> {
                                    var articleHomeDto = new ArticleHomeDto();
                                    var tagDto = new TagDto();
                                    List<TagDto> tagDtoList = new ArrayList<>();
                                    tagDto.setId(articleHomeDtoTemp.getTagId());
                                    tagDto.setTagName(articleHomeDtoTemp.getTagName());
                                    tagDtoList.add(tagDto);
                                    articleHomeDto.setTagDTOList(tagDtoList);
                                    articleHomeDto.setId(articleHomeDtoTemp.getId());
                                    articleHomeDto.setArticleCover(articleHomeDtoTemp.getArticleCover());
                                    articleHomeDto.setArticleTitle(articleHomeDtoTemp.getArticleTitle());
                                    articleHomeDto.setArticleContent(articleHomeDtoTemp.getArticleContent());
                                    articleHomeDto.setCreateTime(articleHomeDtoTemp.getCreateTime());
                                    articleHomeDto.setCategoryId(articleHomeDtoTemp.getCategoryId());
                                    articleHomeDto.setCategoryName(articleHomeDtoTemp.getCategoryName());
                                    articleHomeDto.setIsTop(articleHomeDtoTemp.getIsTop());
                                    articleHomeDto.setType(articleHomeDtoTemp.getType());
                                    return articleHomeDto;
                                })
                        .collect(
                                Collectors.toMap(
                                        ArticleHomeDto::getId,
                                        a -> a,
                                        (o1, o2) -> {
                                            o1.setTagDTOList(
                                                    Stream.of(o1.getTagDTOList(), o2.getTagDTOList())
                                                            .flatMap(Collection::stream)
                                                            .collect(Collectors.toList()));
                                            return o1;
                                        }))
                        .values());
    }

    @Override
    public PageResult<ArticleBackDTo> listArticleBacks(
            Integer page, Integer size, ConditionVO conditionVO) {
        var qArticle = QArticleEntity.articleEntity;
        var qArticleTag = QArticleTagEntity.articleTagEntity;
        var qCategory = QCategoryEntity.categoryEntity;
        var qTag = QTagEntity.tagEntity;
        Long total =
                jpaQueryFactory
                        .select(qArticle.id.countDistinct())
                        .from(qArticle)
                        .leftJoin(qArticleTag)
                        .on(qArticle.id.eq(qArticleTag.articleId))
                        .where(
                                qArticle.isDelete.eq(conditionVO.getIsDelete()),
                                qArticle.status.eq(conditionVO.getStatus()),
                                qArticle.categoryId.eq(conditionVO.getCategoryId()),
                                qArticle.type.eq(conditionVO.getType()),
                                qArticleTag.tagId.eq(conditionVO.getTagId()))
                        .fetchOne();
        if (total == 0) {
            return new PageResult<>();
        }
        var articleBackDTOList = articleRepository.listArticleBacks(page, size, conditionVO);
        var bean =
                Projections.bean(
                        ArticleBackDToTemp.class,
                        qArticle.id,
                        qArticle.articleCover,
                        qArticle.articleTitle,
                        qArticle.type,
                        qArticle.isTop,
                        qArticle.status,
                        qArticle.createTime,
                        qCategory.categoryName,
                        qTag.id.as("tagId"),
                        qTag.tagName);
        // todo
        // jpaQueryFactory.select(bean)
        //         .from(JPAExpressions.select(qArticle.id,qArticle.articleCover,qArticle.articleTitle,
        //                 qArticle.type,qArticle.isTop, qArticle.isDelete, qArticle.status,
        // qArticle.categoryId)
        //
        // .from(qArticle).where(qArticle.isDelete.eq(conditionVO.getIsDelete())).f).join();
        SubQueryExpression<Tuple> queryExpression =
                SQLExpressions.select(
                                qArticle.id,
                                qArticle.articleCover,
                                qArticle.articleTitle,
                                qArticle.type,
                                qArticle.isTop,
                                qArticle.isDelete,
                                qArticle.status,
                                qArticle.categoryId)
                        .from(qArticle)
                        .where(qArticle.isDelete.eq(conditionVO.getIsDelete()));
        return new PageResult<>(articleBackDTOList, Math.toIntExact(total));
    }

    @Transactional
    @Override
    public void saveOrUpdateArticle(ArticleVO articleVO) {
        var category = saveArticleCategory(articleVO);
        var article = BeanCopyUtil.copyObject(articleVO, ArticleEntity.class);
        if (Objects.nonNull(category)) {
            article.setCategoryId(category.getId());
        }
        article.setUserId(1);
        articleRepository.save(article);
        saveArticleTag(articleVO, article.getId());
    }

    @Override
    public void updateArticleTop(ArticleTopVO articleTopVO) {
        var article =
                ArticleEntity.builder().id(articleTopVO.getId()).isTop(articleTopVO.getIsTop()).build();
        articleRepository.save(article);
    }

    @Override
    public void updateArticleDelete(ArticleDeleteVO articleDeleteVO) {
        var articleList =
                articleDeleteVO.getIdList().stream()
                        .map(
                                id ->
                                        ArticleEntity.builder()
                                                .id(id)
                                                .isTop(FALSE)
                                                .isDelete(articleDeleteVO.getIsDelete())
                                                .build())
                        .collect(Collectors.toList());
        articleRepository.saveAll(articleList);
    }

    private CategoryEntity saveArticleCategory(ArticleVO articleVO) {
        var category = categoryRepository.findOneByCategoryName(articleVO.getCategoryName());
        if (Objects.isNull(category) && ! articleVO.getStatus().equals(DRAFT)) {
            category = CategoryEntity.builder().categoryName(articleVO.getCategoryName()).build();
            categoryRepository.save(category);
        }
        return category;
    }

    private void saveArticleTag(ArticleVO articleVO, Integer articleId) {
        var qArticleTag = QArticleTagEntity.articleTagEntity;
        var qTag = QTagEntity.tagEntity;
        if (Objects.nonNull(articleVO.getId())) {
            jpaQueryFactory.delete(qArticleTag).where(qArticleTag.articleId.eq(articleVO.getId()));
        }
        var tagNameList = articleVO.getTagNameList();
        if (! CollectionUtils.isEmpty(tagNameList)) {
            var existTagList =
                    jpaQueryFactory.select(qTag).from(qTag).where(qTag.tagName.in(tagNameList)).stream()
                            .collect(Collectors.toList());
            var existTagNameList =
                    existTagList.stream().map(TagEntity::getTagName).collect(Collectors.toList());
            var existTagIdList = existTagList.stream().map(TagEntity::getId).collect(Collectors.toList());
            tagNameList.removeAll(existTagNameList);
            if (! CollectionUtils.isEmpty(tagNameList)) {
                var tagList =
                        tagNameList.stream()
                                .map(item -> TagEntity.builder().tagName(item).build())
                                .collect(Collectors.toList());
                for (int i = 0; i < tagList.size(); i++) {
                    if (i > 0 && i % 10 == 0) {
                        entityManager.flush();
                        entityManager.clear();
                    }
                    TagEntity tag = tagList.get(i);
                    entityManager.persist(tag);
                }
                var tagIdList = tagList.stream().map(TagEntity::getId).collect(Collectors.toList());
                existTagIdList.addAll(tagIdList);
            }
            var articleTagList =
                    existTagIdList.stream()
                            .map(item -> ArticleTagEntity.builder().articleId(articleId).tagId(item).build())
                            .collect(Collectors.toList());
            jpaQueryFactory.delete(qArticleTag).where(qArticleTag.articleId.eq(articleId)).execute();
            for (int i = 0; i < articleTagList.size(); i++) {
                if (i > 0 && i % 10 == 0) {
                    entityManager.flush();
                    entityManager.clear();
                }
                ArticleTagEntity articleTag = articleTagList.get(i);
                entityManager.persist(articleTag);
            }
        }
    }
}
