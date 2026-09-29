package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.text.html.parser.Entity;

public class JpaUtil {
    public static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("mariaDb");

    public static EntityManagerFactory getEMF(){
        return emf;
    }

    public static EntityManager getEM(){
        return emf.createEntityManager();
    }

    public JpaUtil(){

    }


}
