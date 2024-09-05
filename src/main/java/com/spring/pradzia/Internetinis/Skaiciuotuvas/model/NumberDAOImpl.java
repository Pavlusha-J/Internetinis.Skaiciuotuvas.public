package com.spring.pradzia.Internetinis.Skaiciuotuvas.model;

import com.spring.pradzia.Internetinis.Skaiciuotuvas.config.JPAUtil;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class NumberDAOImpl implements NumberDAO{


    @Override
    public void insertEntity(Number number) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        EntityTransaction entityTransaction =entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(number); //issaugo objekta duomenu bazej(objektas=irasas lenteleje)-ORM

        entityManager.getTransaction().commit(); //transakcijos ivykdymas
        entityManager.close();
    }

    @Override
    public Number findEntityById(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        EntityTransaction entityTransaction =entityManager.getTransaction();
        entityTransaction.begin();

        List<Number> numbers =entityManager                                //ORM modelyje ieskome ne duomenu bazes lenteleje, bet Entityje
                .createQuery("SELECT n FROM Number n WHERE n.id =:id")  // n-atitinka lenteles klases pavadinima Number(entity)
                .setParameter("id", id)
                .getResultList();  // negrazinamas rezultatas(ResulSet), o grazinamas List

        entityManager.getTransaction().commit(); //transakcijos ivykdymas
        entityManager.close();
        return numbers.get(0);  // jei norim kad grazintu lista, irasom tik numbers
    }

    @Override
    public List<Number> findEntities() {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    EntityTransaction entityTransaction =entityManager.getTransaction();
        entityTransaction.begin();

    List<Number> numbers =entityManager
            .createQuery("SELECT n FROM Number n WHERE n.id =:id")
            .getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return numbers;
    }


    @Override
    public void updateEntity(Number number) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        EntityTransaction entityTransaction =entityManager.getTransaction();
        entityTransaction.begin();

        Number numberDB = entityManager.find(Number.class/*Entity*/, number.getId()); // kad atnaujinti irasa, reikia ji surasti (find)
        numberDB.setSk1(number.getSk1());
        numberDB.setSk2(number.getSk2());
        numberDB.setRezultatas(number.getRezultatas());
        numberDB.setZenklas(number.getZenklas());


        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void removeEntityById(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        EntityTransaction entityTransaction =entityManager.getTransaction();
        entityTransaction.begin();

        Number numberDB = entityManager.find(Number.class/*Entity*/, id);
        entityManager.remove(numberDB);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}

