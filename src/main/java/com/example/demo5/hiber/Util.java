package com.example.demo5.hiber;

import org.hibernate.SessionFactory;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Util {
    private static EntityManagerFactory entityManagerFactory;

    private Util() {}

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return entityManagerFactory;
    }

    public static SessionFactory getSessionFactory() {
        return getEntityManagerFactory().unwrap(SessionFactory.class);
    }
    }

