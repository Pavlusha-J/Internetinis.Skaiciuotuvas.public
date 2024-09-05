package com.spring.pradzia.Internetinis.Skaiciuotuvas.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    //klase skirta sukurti entity manager factory (vadyba kuri apjungs ir
    // seks procesa(sesija) kuomet entity objektus desim i DB)
    private  static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private  static EntityManagerFactory entityManagerFactory;


    //getEntityManagerFactoryper aplikacijos veikima bus tik viena (tuo tarpu sesiju bus daug..)
    //getEntityManagerFactory veika SINGLETON sablonu (pattern)
    public  static EntityManagerFactory getEntityManagerFactory(){

        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactory;
    }
    public static void shutdown(){
        if (entityManagerFactory !=null){
            entityManagerFactory.close();
        }
    }
}
