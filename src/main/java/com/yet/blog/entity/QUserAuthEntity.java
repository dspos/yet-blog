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
 * QUserAuthEntity is a Querydsl query type for UserAuthEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserAuthEntity extends EntityPathBase<UserAuthEntity> {

    private static final long serialVersionUID = -1324708120L;

    public static final QUserAuthEntity userAuthEntity = new QUserAuthEntity("userAuthEntity");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath ipAddress = createString("ipAddress");

    public final StringPath ipSource = createString("ipSource");

    public final DateTimePath<java.time.LocalDateTime> lastLoginTime = createDateTime("lastLoginTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Byte> loginType = createNumber("loginType", Byte.class);

    public final StringPath password = createString("password");

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> userInfoId = createNumber("userInfoId", Integer.class);

    public final StringPath username = createString("username");

    public QUserAuthEntity(String variable) {
        super(UserAuthEntity.class, forVariable(variable));
    }

    public QUserAuthEntity(Path<? extends UserAuthEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserAuthEntity(PathMetadata metadata) {
        super(UserAuthEntity.class, metadata);
    }

}
