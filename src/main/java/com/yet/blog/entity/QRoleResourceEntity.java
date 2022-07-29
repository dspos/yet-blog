package com.yet.blog.entity;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

/**
 * QRoleResourceEntity is a Querydsl query type for RoleResourceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoleResourceEntity extends EntityPathBase<RoleResourceEntity> {

    private static final long serialVersionUID = 991901625L;

    public static final QRoleResourceEntity roleResourceEntity = new QRoleResourceEntity("roleResourceEntity");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> resourceId = createNumber("resourceId", Integer.class);

    public final NumberPath<Integer> roleId = createNumber("roleId", Integer.class);

    public QRoleResourceEntity(String variable) {
        super(RoleResourceEntity.class, forVariable(variable));
    }

    public QRoleResourceEntity(Path<? extends RoleResourceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoleResourceEntity(PathMetadata metadata) {
        super(RoleResourceEntity.class, metadata);
    }

}
