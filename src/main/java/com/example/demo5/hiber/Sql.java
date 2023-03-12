package com.example.demo5.hiber;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Sql {
    public Brand getBrandById(long id) {

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "MyPersistence" );

        EntityManager entitymanager = emfactory.createEntityManager( );

        CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteriaQuery = criteriaBuilder.createQuery(Brand.class);
        Root<Brand> broot = criteriaQuery.from(Brand.class);
        criteriaQuery.select(broot).where(criteriaBuilder.equal(broot.get("id"), id));
        TypedQuery<Brand> typedQuery = entitymanager.createQuery(criteriaQuery);
        Brand brand = typedQuery.getSingleResult();
        return brand;
    }
}
