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
 * QCommentEntity is a Querydsl query type for CommentEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommentEntity extends EntityPathBase<CommentEntity> {

    private static final long serialVersionUID = -33695792L;

    public static final QCommentEntity commentEntity = new QCommentEntity("commentEntity");

    public final StringPath commentContent = createString("commentContent");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final BooleanPath isDelete = createBoolean("isDelete");

    public final BooleanPath isReview = createBoolean("isReview");

    public final NumberPath<Integer> parentId = createNumber("parentId", Integer.class);

    public final NumberPath<Integer> replyUserId = createNumber("replyUserId", Integer.class);

    public final NumberPath<Integer> topicId = createNumber("topicId", Integer.class);

    public final NumberPath<Byte> type = createNumber("type", Byte.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public QCommentEntity(String variable) {
        super(CommentEntity.class, forVariable(variable));
    }

    public QCommentEntity(Path<? extends CommentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommentEntity(PathMetadata metadata) {
        super(CommentEntity.class, metadata);
    }

}
