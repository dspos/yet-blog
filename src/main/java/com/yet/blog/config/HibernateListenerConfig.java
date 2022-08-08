package com.yet.blog.config;

import com.yet.blog.listener.JpaIgnoreNullEventListener;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * @author Ekko
 * @date 2022/4/10 1:16
 * @description HibernateListenerConfig
 */
@Configuration
public class HibernateListenerConfig {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @PostConstruct
    protected void init() {
        SessionFactoryImpl sessionFactory = emf.unwrap(SessionFactoryImpl.class);
        EventListenerRegistry registry =
                sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.MERGE).clearListeners();
        registry
                .getEventListenerGroup(EventType.MERGE)
                .prependListener(JpaIgnoreNullEventListener.INSTANCE);
    }
}
