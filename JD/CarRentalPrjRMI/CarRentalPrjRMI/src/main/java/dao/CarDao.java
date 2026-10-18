package dao;

import java.util.List;

import entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JPAUtil;

public class CarDao {
	public void add(Car car) {
		EntityTransaction tx = null;
		try (EntityManager em = JPAUtil.getEntityManager()) {
			tx = em.getTransaction();
			tx.begin();
			em.persist(car);
			tx.commit();
		} catch (Exception e) {
			if(tx != null && tx.isActive())
				tx.rollback();
			 throw new RuntimeException("Failed to add car", e);
		}
	}

	public void update(Car car) {
		EntityTransaction tx = null;
		try (EntityManager em = JPAUtil.getEntityManager()) {
			tx = em.getTransaction();
			tx.begin();
			em.merge(car);
			tx.commit();
		} catch (Exception e) {
			if(tx != null && tx.isActive())
				tx.rollback();
			 throw new RuntimeException("Failed to update car", e);
		}
	}

	public void delete(Long carId) {
		EntityTransaction tx = null;
		try (EntityManager em = JPAUtil.getEntityManager()) {
			tx = em.getTransaction();
			tx.begin();
			Car car = em.find(Car.class, carId);
			if (car != null)
				em.remove(car);
			tx.commit();
		} catch (Exception e) {
			if(tx != null && tx.isActive())
				tx.rollback();
			 throw new RuntimeException("Failed to delete car", e);
		}
	}

	public Car findById(Long carId) {
		try (EntityManager em = JPAUtil.getEntityManager()) {
			return em.find(Car.class, carId);
		}
	}

	public List<Car> findAll() {
		String query = "select c from Car c";
		try (EntityManager em = JPAUtil.getEntityManager()) {
			return em.createQuery(query, Car.class).getResultList();
		}
	}
	
	public List<Object[]> listHistoryRentalByCustomer(String customerId){
		String query = "select c.id, c.carName, rc.startDate, rc.endDate, rc.contractStatus "
				+ "from Car c join c.rentalContracts rc "
				+ "where rc.customer.id = :customerId";
		try (EntityManager em = JPAUtil.getEntityManager()) {
			return em.createQuery(query, Object[].class)
					.setParameter("customerId", customerId)
					.getResultList();
		}
	}

	public static void main(String[] args) {
		CarDao carDao = new CarDao();
		carDao.findAll().forEach(c -> System.out.println(c));
	}
}
