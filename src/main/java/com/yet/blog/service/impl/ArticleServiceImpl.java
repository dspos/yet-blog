package com.yet.blog.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yet.blog.dto.ArchiveDto;
import com.yet.blog.dto.ArticleBackDTO;
import com.yet.blog.dto.ArticleHomeDto;
import com.yet.blog.dto.ArticleHomeDtoTemp;
import com.yet.blog.dto.TagDto;
import com.yet.blog.entity.ArticleEntity;
import com.yet.blog.repository.ArticleRepository;
import com.yet.blog.repository.ArticleTagRepository;
import com.yet.blog.repository.CategoryRepository;
import com.yet.blog.repository.TagRepository;
import com.yet.blog.result.PageResult;
import com.yet.blog.service.ArticleService;
import com.yet.blog.util.BeanCopyUtil;
import com.yet.blog.vo.ConditionVO;
import lombok.SneakyThrows;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.yet.blog.constant.CommonConst.FALSE;
import static com.yet.blog.constant.CommonConst.PUBLIC;

/**
 * @author Ekko
 * @date 2022/4/13 23:25
 * @description ArticleServiceImpl
 */
@Service
public class ArticleServiceImpl implements ArticleService {

  @PersistenceContext private EntityManager entityManager;

  private final ArticleRepository articleRepository;

  private final CategoryRepository categoryRepository;

  private final TagRepository tagRepository;

  private final ArticleTagRepository articleTagRepository;

  public ArticleServiceImpl(
      ArticleRepository articleRepository,
      CategoryRepository categoryRepository,
      TagRepository tagRepository,
      ArticleTagRepository articleTagRepository) {
    this.articleRepository = articleRepository;
    this.categoryRepository = categoryRepository;
    this.tagRepository = tagRepository;
    this.articleTagRepository = articleTagRepository;
  }

  @Override
  public PageResult<ArchiveDto> listArchives(Integer page, Integer size) {
    Specification<ArticleEntity> specification =
        (root, query, criteriaBuilder) -> {
          List<Predicate> predicates = new ArrayList<>();
          predicates.add(criteriaBuilder.equal(root.get("isDelete"), FALSE));
          predicates.add(criteriaBuilder.equal(root.get("status"), PUBLIC));
          return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    Pageable pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "createTime"));
    List<ArticleEntity> articleList =
        articleRepository.findAll(specification, pageable).getContent();
    List<ArchiveDto> archiveDtoList = BeanCopyUtil.copyBeanList(articleList, ArchiveDto.class);
    Integer count = Math.toIntExact(articleRepository.count());
    return new PageResult<>(archiveDtoList, count);
  }

  @SneakyThrows
  @Override
  public List<ArticleHomeDto> listArticles(Integer page, Integer size) {
    String sql =
        "SELECT a.id,article_cover,article_title,SUBSTR(article_content,1,500 ) AS article_content,a.create_time,"
            + "a.type,a.is_top,a.category_id,category_name,t.id AS tag_id,t.tag_name\n"
            + "FROM(SELECT id,article_cover,article_title,article_content,type,is_top,create_time,category_id FROM tb_article\n"
            + "    WHERE is_delete = 0 AND status = 1 ORDER BY is_top DESC, id DESC LIMIT :page OFFSET :size ) a\n"
            + "    JOIN tb_category c ON a.category_id = c.id\n"
            + "    JOIN tb_article_tag atg ON a.id = atg.article_id\n"
            + "    JOIN tb_tag t ON t.id = atg.tag_id\n"
            + "ORDER BY a.is_top DESC,a.id DESC";
    Query nativeQuery = entityManager.createNativeQuery(sql);
    nativeQuery.setParameter("page", page);
    nativeQuery.setParameter("size", size - 1);
    nativeQuery
        .unwrap(NativeQueryImpl.class)
        .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    List<ArticleHomeDtoTemp> articleHomeDtoTempList = nativeQuery.getResultList();
    String s = new ObjectMapper().writeValueAsString(articleHomeDtoTempList);
    List<ArticleHomeDtoTemp> resultList = new ObjectMapper().readValue(s, new TypeReference<>() {});
    return new ArrayList<>(
        resultList.stream()
            .map(
                articleHomeDtoTemp -> {
                  var articleHomeDto = new ArticleHomeDto();
                  var tagDto = new TagDto();
                  List<TagDto> tagDtoList = new ArrayList<>();
                  tagDto.setId(articleHomeDtoTemp.getTag_id());
                  tagDto.setTagName(articleHomeDtoTemp.getTag_name());
                  tagDtoList.add(tagDto);
                  articleHomeDto.setTagDTOList(tagDtoList);
                  articleHomeDto.setId(articleHomeDtoTemp.getId());
                  articleHomeDto.setArticleCover(articleHomeDtoTemp.getArticle_cover());
                  articleHomeDto.setArticleTitle(articleHomeDtoTemp.getArticle_title());
                  articleHomeDto.setArticleContent(articleHomeDtoTemp.getArticle_content());
                  articleHomeDto.setCreateTime(articleHomeDtoTemp.getCreate_time());
                  articleHomeDto.setCategoryId(articleHomeDtoTemp.getCategory_id());
                  articleHomeDto.setCategoryName(articleHomeDtoTemp.getCategory_name());
                  articleHomeDto.setIsTop(articleHomeDtoTemp.getIs_top());
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
  public PageResult<ArticleBackDTO> listArticleBacks(
      Integer page, Integer size, ConditionVO conditionVO) {
    var count = articleRepository.countArticleBacks(conditionVO);
    if (count == 0) {
      return new PageResult<>();
    }
    List<ArticleBackDTO> articleBackDTOList =
        articleRepository.listArticleBacks(page, size, conditionVO);
    return new PageResult<>(articleBackDTOList, count);
  }
}
