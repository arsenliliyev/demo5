package com.example.demo5.hiber;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Dao {
    public Brand findById(int id) {
        EntityManagerFactory emFact= Persistence.createEntityManagerFactory("MyPersistenceUnit");
            EntityManager entityManager = emFact.createEntityManager();
            try {
                entityManager.getTransaction().begin();
                Brand brand = entityManager.find(Brand.class, id);
                entityManager.getTransaction().commit();
                return brand;
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
                throw e;
            } finally {
                entityManager.close();
            }
        }
    }

