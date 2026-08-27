package jpaTest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("mariadb").createEntityManager();
		
		Student stu1dent=new Student();
		stu1dent.setName("test");
		em.persist(stu1dent);

	}

}
