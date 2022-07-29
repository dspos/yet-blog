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
 * QTalkEntity is a Querydsl query type for TalkEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTalkEntity extends EntityPathBase<TalkEntity> {

    private static final long serialVersionUID = 852567489L;

    public static final QTalkEntity talkEntity = new QTalkEntity("talkEntity");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath images = createString("images");

    public final BooleanPath isTop = createBoolean("isTop");

    public final NumberPath<Byte> status = createNumber("status", Byte.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public QTalkEntity(String variable) {
        super(TalkEntity.class, forVariable(variable));
    }

    public QTalkEntity(Path<? extends TalkEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTalkEntity(PathMetadata metadata) {
        super(TalkEntity.class, metadata);
    }

}
