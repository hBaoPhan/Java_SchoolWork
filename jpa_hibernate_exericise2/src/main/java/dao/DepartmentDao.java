package dao;

import entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DepartmentDao {
	public void add(Department department) {
		EntityTransaction tr = null;
		try (EntityManager em = JPAUtil.getEntityManager()){
			tr = em.getTransaction();
			tr.begin();
			em.persist(department);
			tr.commit();			
		}
		catch (Exception e) {
			if(tr != null && tr.isActive()) {
				tr.rollback();
			}
			e.printStackTrace();
		}
	}
	public void update(Department department) {
		EntityTransaction tr = null;
		try (EntityManager em = JPAUtil.getEntityManager()){
			tr = em.getTransaction();
			tr.begin();
			tr.commit();
		}
		catch (Exception e) {
			if(tr != null && tr.isActive()) {
				tr.rollback();
			}
			e.printStackTrace();
		}
	}
	public void delete(int departmentId) {
		EntityTransaction tr = null;
		try(EntityManager em = JPAUtil.getEntityManager()){
			tr = em.getTransaction();
			tr.begin();
			em.persist(department);
			tr.commit();
		}
		catch (Exception e) {
			if(tr != null && tr.isActive()) {
				tr.rollback();
			}
			e.printStackTrace();
		}	
	}
}
