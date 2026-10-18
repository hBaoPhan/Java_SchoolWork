package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory EMF = 
			Persistence.createEntityManagerFactory("STT01_25343431_LeLan_M21");
	
	private JPAUtil() {}
	
	public static EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}
	
	public static void close() {
		EMF.close();
	}
}
