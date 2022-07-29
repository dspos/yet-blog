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
 * QMenuEntity is a Querydsl query type for MenuEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMenuEntity extends EntityPathBase<MenuEntity> {

    private static final long serialVersionUID = -1230932940L;

    public static final QMenuEntity menuEntity = new QMenuEntity("menuEntity");

    public final StringPath component = createString("component");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime",
            java.time.LocalDateTime.class);

    public final StringPath icon = createString("icon");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final BooleanPath isHidden = createBoolean("isHidden");

    public final StringPath name = createString("name");

    public final NumberPath<Byte> orderNum = createNumber("orderNum", Byte.class);

    public final NumberPath<Integer> parentId = createNumber("parentId", Integer.class);

    public final StringPath path = createString("path");

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime",
            java.time.LocalDateTime.class);

    public QMenuEntity(String variable) {
        super(MenuEntity.class, forVariable(variable));
    }

    public QMenuEntity(Path<? extends MenuEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMenuEntity(PathMetadata metadata) {
        super(MenuEntity.class, metadata);
    }

}
