package com.yet.blog.entity;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

/**
 * QRoleMenuEntity is a Querydsl query type for RoleMenuEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoleMenuEntity extends EntityPathBase<RoleMenuEntity> {

    private static final long serialVersionUID = 1731714122L;

    public static final QRoleMenuEntity roleMenuEntity = new QRoleMenuEntity("roleMenuEntity");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> menuId = createNumber("menuId", Integer.class);

    public final NumberPath<Integer> roleId = createNumber("roleId", Integer.class);

    public QRoleMenuEntity(String variable) {
        super(RoleMenuEntity.class, forVariable(variable));
    }

    public QRoleMenuEntity(Path<? extends RoleMenuEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoleMenuEntity(PathMetadata metadata) {
        super(RoleMenuEntity.class, metadata);
    }

}
