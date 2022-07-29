package com.yet.blog.entity;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

/**
 * QResourceEntity is a Querydsl query type for ResourceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResourceEntity extends EntityPathBase<ResourceEntity> {

    private static final long serialVersionUID = 180800163L;

    public static final QResourceEntity resourceEntity = new QResourceEntity("resourceEntity");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final BooleanPath isAnonymous = createBoolean("isAnonymous");

    public final NumberPath<Integer> parentId = createNumber("parentId", Integer.class);

    public final StringPath requestMethod = createString("requestMethod");

    public final StringPath resourceName = createString("resourceName");

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime",
            java.time.LocalDateTime.class);

    public final StringPath url = createString("url");

    public QResourceEntity(String variable) {
        super(ResourceEntity.class, forVariable(variable));
    }

    public QResourceEntity(Path<? extends ResourceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QResourceEntity(PathMetadata metadata) {
        super(ResourceEntity.class, metadata);
    }

}
