package com.yet.blog.entity;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

/**
 * QArticleTagEntity is a Querydsl query type for ArticleTagEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticleTagEntity extends EntityPathBase<ArticleTagEntity> {

    private static final long serialVersionUID = -149653415L;

    public static final QArticleTagEntity articleTagEntity = new QArticleTagEntity("articleTagEntity");

    public final NumberPath<Integer> articleId = createNumber("articleId", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> tagId = createNumber("tagId", Integer.class);

    public QArticleTagEntity(String variable) {
        super(ArticleTagEntity.class, forVariable(variable));
    }

    public QArticleTagEntity(Path<? extends ArticleTagEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArticleTagEntity(PathMetadata metadata) {
        super(ArticleTagEntity.class, metadata);
    }

}
