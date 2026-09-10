package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("jpa_hibernate_exericise2");
	
	private JPAUtil() {}
	
	public static EntityManager getEntityManager () {
		return EMF.createEntityManager();
	}
	
	public static void close() {
		if (EMF != null)
			EMF.close();
	}
}
