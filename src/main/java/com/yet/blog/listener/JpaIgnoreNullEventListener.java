package com.yet.blog.listener;

import org.hibernate.bytecode.enhance.spi.LazyPropertyInitializer;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.event.internal.DefaultMergeEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.property.access.internal.PropertyAccessStrategyBackRefImpl;
import org.hibernate.type.Type;

import java.util.Map;

/**
 * @author Ekko
 * @date 2022/4/10 1:10
 * @description JpaIgnoreNullEventListener
 */
public class JpaIgnoreNullEventListener extends DefaultMergeEventListener {

  public static final JpaIgnoreNullEventListener INSTANCE = new JpaIgnoreNullEventListener();

  @Override
  protected void copyValues(
      EntityPersister persister,
      Object entity,
      Object target,
      SessionImplementor source,
      Map copyCache) {
    // 源目标
    Object[] original = persister.getPropertyValues(entity);
    // 存储目标
    Object[] targets = persister.getPropertyValues(target);
    Type[] types = persister.getPropertyTypes();
    Object[] copied = new Object[original.length];
    for (int i = 0; i < original.length; i++) {
      if (original[i] == null
          || original[i] == LazyPropertyInitializer.UNFETCHED_PROPERTY
          || original[i] == PropertyAccessStrategyBackRefImpl.UNKNOWN) {
        copied[i] = targets[i];
      } else {
        copied[i] = types[i].replace(original[i], targets[i], source, target, copyCache);
      }
    }
    persister.setPropertyValues(target, copied);
  }
}
