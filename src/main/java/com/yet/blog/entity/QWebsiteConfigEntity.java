package com.yet.blog.entity;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

/**
 * QWebsiteConfigEntity is a Querydsl query type for WebsiteConfigEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWebsiteConfigEntity extends EntityPathBase<WebsiteConfigEntity> {

    private static final long serialVersionUID = 1843421230L;

    public static final QWebsiteConfigEntity websiteConfigEntity = new QWebsiteConfigEntity("websiteConfigEntity");

    public final StringPath config = createString("config");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime",
            java.time.LocalDateTime.class);

    public QWebsiteConfigEntity(String variable) {
        super(WebsiteConfigEntity.class, forVariable(variable));
    }

    public QWebsiteConfigEntity(Path<? extends WebsiteConfigEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWebsiteConfigEntity(PathMetadata metadata) {
        super(WebsiteConfigEntity.class, metadata);
    }

}
