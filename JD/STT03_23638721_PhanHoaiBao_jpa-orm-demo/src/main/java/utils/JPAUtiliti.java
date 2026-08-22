package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtiliti {

    private static final EntityManagerFactory emf=
            Persistence.createEntityManagerFactory("mariadb-pu");

    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    private JPAUtiliti(){
    }

    public static void close(){
        emf.close();
    }

}
