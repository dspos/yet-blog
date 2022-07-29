package com.yet.blog.entity;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

/**
 * QUniqueViewEntity is a Querydsl query type for UniqueViewEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUniqueViewEntity extends EntityPathBase<UniqueViewEntity> {

    private static final long serialVersionUID = 772886059L;

    public static final QUniqueViewEntity uniqueViewEntity = new QUniqueViewEntity("uniqueViewEntity");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> viewsCount = createNumber("viewsCount", Integer.class);

    public QUniqueViewEntity(String variable) {
        super(UniqueViewEntity.class, forVariable(variable));
    }

    public QUniqueViewEntity(Path<? extends UniqueViewEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUniqueViewEntity(PathMetadata metadata) {
        super(UniqueViewEntity.class, metadata);
    }

}
