package com.yet.blog.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;

/**
 * QArticleEntity is a Querydsl query type for ArticleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticleEntity extends EntityPathBase<ArticleEntity> {

    private static final long serialVersionUID = 1734289703L;

    public static final QArticleEntity articleEntity = new QArticleEntity("articleEntity");

    public final StringPath articleContent = createString("articleContent");

    public final StringPath articleCover = createString("articleCover");

    public final StringPath articleTitle = createString("articleTitle");

    public final NumberPath<Integer> categoryId = createNumber("categoryId", Integer.class);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> isDelete = createNumber("isDelete", Integer.class);

    public final NumberPath<Integer> isTop = createNumber("isTop", Integer.class);

    public final StringPath originalUrl = createString("originalUrl");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public QArticleEntity(String variable) {
        super(ArticleEntity.class, forVariable(variable));
    }

    public QArticleEntity(Path<? extends ArticleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArticleEntity(PathMetadata metadata) {
        super(ArticleEntity.class, metadata);
    }

}
