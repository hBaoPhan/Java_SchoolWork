package dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JPAUtil;

public class DepartmentDao {
	//CRUD
	public void add(Department department) {
		EntityTransaction tr = null;
		try(EntityManager em = JPAUtil.getEntityManager()){
			 tr = em.getTransaction();
			 tr.begin();
			 em.persist(department); //insert into ... values ...
			 tr.commit();
		}catch (Exception e) {
			if(tr != null && tr.isActive())
				tr.rollback();
			e.printStackTrace();
		}
	}
	
	public void update(Department department) {
		EntityTransaction tr = null;
		try(EntityManager em = JPAUtil.getEntityManager()){
			tr = em.getTransaction();
			tr.begin();
			em.merge(department); //update 
			tr.commit();
		}catch (Exception e) {
			if(tr != null && tr.isActive())
				tr.rollback();
			e.printStackTrace();
		}
	}
	
	public void delete(int departmentId) {
		EntityTransaction tr = null;
		try(EntityManager em = JPAUtil.getEntityManager()){
			tr = em.getTransaction();
			tr.begin();
			Department department = em.find(Department.class, departmentId);
			if(department != null)
				em.remove(department); //delete from ... where ...
			tr.commit();
		}catch (Exception e) {
			if(tr != null && tr.isActive())
				tr.rollback();
			e.printStackTrace();
		}
	}
	
	
	public List<Department> findAll() {
		String query = "select d from Department d";
		try(EntityManager em = JPAUtil.getEntityManager()){
			return em.createQuery(query, Department.class)
					.getResultList();
		}
	}
	public List<Department> findByName(String name) {
		String query = """
				select d from Department d
				where d.name like :name
				""";
		try(EntityManager em = JPAUtil.getEntityManager()){
			return em.createQuery(query, Department.class)
					.setParameter("name", "%" + name + "%")
					.getResultList();
		}
	}
	
	public Optional<Department> findById(int departmentId) {
		try(EntityManager em = JPAUtil.getEntityManager()){
			return Optional.of(em.find(Department.class, departmentId));
		}
	}
	
	public static void main(String[] args) {
		DepartmentDao departmentDao = new DepartmentDao();
		
		departmentDao.findByName("ic")
		.forEach(d -> System.out.println(d));
		
//		departmentDao.findAll()
//		.forEach(d -> System.out.println(d));
		
//		Optional<Department> dept = departmentDao.findById(2);
//		
//		Department temp = dept.get();
//		temp.setBudget(50_000);
//		temp.setName("gdfgdfgdfg");
//		temp.setStartDate(LocalDateTime.of(2010, 2, 2, 0, 0));
//		
//		departmentDao.update(temp);
//		
//		System.out.println(dept.get());
	}
}
