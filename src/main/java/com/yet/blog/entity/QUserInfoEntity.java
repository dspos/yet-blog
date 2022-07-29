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
 * QUserInfoEntity is a Querydsl query type for UserInfoEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserInfoEntity extends EntityPathBase<UserInfoEntity> {

    private static final long serialVersionUID = 158480750L;

    public static final QUserInfoEntity userInfoEntity = new QUserInfoEntity("userInfoEntity");

    public final StringPath avatar = createString("avatar");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime",
            java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath intro = createString("intro");

    public final BooleanPath isDisable = createBoolean("isDisable");

    public final StringPath nickname = createString("nickname");

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime",
            java.time.LocalDateTime.class);

    public final StringPath webSite = createString("webSite");

    public QUserInfoEntity(String variable) {
        super(UserInfoEntity.class, forVariable(variable));
    }

    public QUserInfoEntity(Path<? extends UserInfoEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserInfoEntity(PathMetadata metadata) {
        super(UserInfoEntity.class, metadata);
    }

}
