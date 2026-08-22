import entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {

       EntityManagerFactory emf= Persistence.createEntityManagerFactory("mariadb");
       EntityManager em= emf.createEntityManager();

       EntityTransaction et= null;
       try{
           et=em.getTransaction();
           et.begin();

           Employee emp1=new FullTimeEmployee("Bao","bao@gmail.com", LocalDate.of(2023,1,1),new java.math.BigDecimal(2000));
           Employee emp2=new PartTimeEmployee("HUng","hungo@gmail.com", LocalDate.of(2023,1,1),2, BigDecimal.valueOf(1000));

           em.persist(emp1);
           em.persist(emp2);

           et.commit();
       } catch (Exception e) {
           if(et.isActive()){
               et.rollback();
           }
           e.printStackTrace();

       }










//       EntityTransaction tr=em.getTransaction();
//       tr.begin();
//
//        Category category = new Category("It","Cong nghe thong tin");
//        Book book=new Book("Java", Set.of("Bao Phan","Someone"),1996);
//
//       book.setCategory(category);
//        //merge,find,remove, query
//
//       em.persist(book);
//       em.persist(category);
//
//       tr.commit();

    }
}
