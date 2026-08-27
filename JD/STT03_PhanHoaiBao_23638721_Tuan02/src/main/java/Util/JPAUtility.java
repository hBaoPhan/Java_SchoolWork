package Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtility {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public JPAUtility() {
    }

    public static void close() {
        emf.close();
    }
}
