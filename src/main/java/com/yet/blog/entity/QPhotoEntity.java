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
 * QPhotoEntity is a Querydsl query type for PhotoEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPhotoEntity extends EntityPathBase<PhotoEntity> {

    private static final long serialVersionUID = 1291456739L;

    public static final QPhotoEntity photoEntity = new QPhotoEntity("photoEntity");

    public final NumberPath<Integer> albumId = createNumber("albumId", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final BooleanPath isDelete = createBoolean("isDelete");

    public final StringPath photoDesc = createString("photoDesc");

    public final StringPath photoName = createString("photoName");

    public final StringPath photoSrc = createString("photoSrc");

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime",
            java.time.LocalDateTime.class);

    public QPhotoEntity(String variable) {
        super(PhotoEntity.class, forVariable(variable));
    }

    public QPhotoEntity(Path<? extends PhotoEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPhotoEntity(PathMetadata metadata) {
        super(PhotoEntity.class, metadata);
    }

}
