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
 * QChatRecordEntity is a Querydsl query type for ChatRecordEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChatRecordEntity extends EntityPathBase<ChatRecordEntity> {

    private static final long serialVersionUID = 548051870L;

    public static final QChatRecordEntity chatRecordEntity = new QChatRecordEntity("chatRecordEntity");

    public final StringPath avatar = createString("avatar");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath ipAddress = createString("ipAddress");

    public final StringPath ipSource = createString("ipSource");

    public final StringPath nickname = createString("nickname");

    public final NumberPath<Byte> type = createNumber("type", Byte.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public QChatRecordEntity(String variable) {
        super(ChatRecordEntity.class, forVariable(variable));
    }

    public QChatRecordEntity(Path<? extends ChatRecordEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChatRecordEntity(PathMetadata metadata) {
        super(ChatRecordEntity.class, metadata);
    }

}
