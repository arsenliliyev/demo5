package com.example.demo5.hiber;

import com.example.demo5.entity.Brand;
//import com.example.demo5.entity.Model;

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

//
//    public Model finById(int id) {
//        EntityManagerFactory emFact= Persistence.createEntityManagerFactory("MyPersistenceUnit");
//        EntityManager entityManager = emFact.createEntityManager();
//        try {
//            entityManager.getTransaction().begin();
//            Model model = entityManager.find(Model.class, id);
//            entityManager.getTransaction().commit();
//            return model;
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
//            throw e;
//        } finally {
//            entityManager.close();
//        }
//    }

//
//    public void upBrand(String name) {
//        EntityManagerFactory emFact= Persistence.createEntityManagerFactory("MyPersistenceUnit");
//        EntityManager entityManager = emFact.createEntityManager();
//        try {
//            entityManager.getTransaction().begin();
//            Model model = entityManager.(Model.class, id);
//            entityManager.getTransaction().commit();
//            return model;
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
//            throw e;
//        } finally {
//            entityManager.close();
//        }
//    }

    public void saveBrand(Brand brand) {
        EntityManagerFactory emFact= Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = emFact.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(brand);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
           e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void updateBrand(Brand brand) {
        EntityManagerFactory emFact= Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = emFact.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Brand brandInDb = entityManager.find(Brand.class, brand.getId());
            brandInDb.setName(brand.getName());

            entityManager.persist(brand);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
           e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    }

