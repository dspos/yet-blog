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
 * QFriendLinkEntity is a Querydsl query type for FriendLinkEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFriendLinkEntity extends EntityPathBase<FriendLinkEntity> {

    private static final long serialVersionUID = 105894477L;

    public static final QFriendLinkEntity friendLinkEntity = new QFriendLinkEntity("friendLinkEntity");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath linkAddress = createString("linkAddress");

    public final StringPath linkAvatar = createString("linkAvatar");

    public final StringPath linkIntro = createString("linkIntro");

    public final StringPath linkName = createString("linkName");

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime",
            java.time.LocalDateTime.class);

    public QFriendLinkEntity(String variable) {
        super(FriendLinkEntity.class, forVariable(variable));
    }

    public QFriendLinkEntity(Path<? extends FriendLinkEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFriendLinkEntity(PathMetadata metadata) {
        super(FriendLinkEntity.class, metadata);
    }

}
