import entity.Group;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("mariadb");
        EntityTransaction tr=null;
        try(EntityManager em=emf.createEntityManager();){
            tr=em.getTransaction();

            User user1=new User("baoph","baoooo","bao@gmail.com");
            User user2=new User("binh","baoooo","binh@gmail.com");
            User user3=new User("an","baoooo","an@gmail.com");

            Group group1=new Group("Group 1");
            Group group2=new Group("Group 2");

            user1.setGroups(new HashSet<>(Set.of(group1,group2)));
            user2.setGroups(new HashSet<>(Set.of(group1)));
            user3.setGroups(new HashSet<>(Set.of(group1,group2)));


            tr.begin();

            em.persist(user1);
            em.persist(user2);
            em.persist(user3);

            em.persist(group1);
            em.persist(group2);
            tr.commit();


        }


    }
}
