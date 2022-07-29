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
 * QPageEntity is a Querydsl query type for PageEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPageEntity extends EntityPathBase<PageEntity> {

    private static final long serialVersionUID = 484449636L;

    public static final QPageEntity pageEntity = new QPageEntity("pageEntity");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath pageCover = createString("pageCover");

    public final StringPath pageLabel = createString("pageLabel");

    public final StringPath pageName = createString("pageName");

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime",
            java.time.LocalDateTime.class);

    public QPageEntity(String variable) {
        super(PageEntity.class, forVariable(variable));
    }

    public QPageEntity(Path<? extends PageEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPageEntity(PathMetadata metadata) {
        super(PageEntity.class, metadata);
    }

}
