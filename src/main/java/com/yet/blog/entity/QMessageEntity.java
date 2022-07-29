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
 * QMessageEntity is a Querydsl query type for MessageEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMessageEntity extends EntityPathBase<MessageEntity> {

    private static final long serialVersionUID = -142013576L;

    public static final QMessageEntity messageEntity = new QMessageEntity("messageEntity");

    public final StringPath avatar = createString("avatar");

    public final DateTimePath<java.sql.Timestamp> createTime = createDateTime("createTime", java.sql.Timestamp.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath ipAddress = createString("ipAddress");

    public final StringPath ipSource = createString("ipSource");

    public final NumberPath<Byte> isReview = createNumber("isReview", Byte.class);

    public final StringPath messageContent = createString("messageContent");

    public final StringPath nickname = createString("nickname");

    public final NumberPath<Byte> time = createNumber("time", Byte.class);

    public final DateTimePath<java.sql.Timestamp> updateTime = createDateTime("updateTime", java.sql.Timestamp.class);

    public QMessageEntity(String variable) {
        super(MessageEntity.class, forVariable(variable));
    }

    public QMessageEntity(Path<? extends MessageEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMessageEntity(PathMetadata metadata) {
        super(MessageEntity.class, metadata);
    }

}
