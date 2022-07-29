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
 * QPhotoAlbumEntity is a Querydsl query type for PhotoAlbumEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPhotoAlbumEntity extends EntityPathBase<PhotoAlbumEntity> {

    private static final long serialVersionUID = 16871986L;

    public static final QPhotoAlbumEntity photoAlbumEntity = new QPhotoAlbumEntity("photoAlbumEntity");

    public final StringPath albumCover = createString("albumCover");

    public final StringPath albumDesc = createString("albumDesc");

    public final StringPath albumName = createString("albumName");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final BooleanPath isDelete = createBoolean("isDelete");

    public final NumberPath<Byte> status = createNumber("status", Byte.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime",
            java.time.LocalDateTime.class);

    public QPhotoAlbumEntity(String variable) {
        super(PhotoAlbumEntity.class, forVariable(variable));
    }

    public QPhotoAlbumEntity(Path<? extends PhotoAlbumEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPhotoAlbumEntity(PathMetadata metadata) {
        super(PhotoAlbumEntity.class, metadata);
    }

}
