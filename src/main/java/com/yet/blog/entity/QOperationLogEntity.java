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
 * QOperationLogEntity is a Querydsl query type for OperationLogEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOperationLogEntity extends EntityPathBase<OperationLogEntity> {

    private static final long serialVersionUID = 606502578L;

    public static final QOperationLogEntity operationLogEntity = new QOperationLogEntity("operationLogEntity");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath ipAddress = createString("ipAddress");

    public final StringPath ipSource = createString("ipSource");

    public final StringPath nickname = createString("nickname");

    public final StringPath optDesc = createString("optDesc");

    public final StringPath optMethod = createString("optMethod");

    public final StringPath optModule = createString("optModule");

    public final StringPath optType = createString("optType");

    public final StringPath optUrl = createString("optUrl");

    public final StringPath requestMethod = createString("requestMethod");

    public final StringPath requestParam = createString("requestParam");

    public final StringPath responseData = createString("responseData");

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime",
            java.time.LocalDateTime.class);

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public QOperationLogEntity(String variable) {
        super(OperationLogEntity.class, forVariable(variable));
    }

    public QOperationLogEntity(Path<? extends OperationLogEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOperationLogEntity(PathMetadata metadata) {
        super(OperationLogEntity.class, metadata);
    }

}
