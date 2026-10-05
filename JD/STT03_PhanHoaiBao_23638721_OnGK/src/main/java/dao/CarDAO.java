package dao;

import entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

import java.util.List;
import java.util.Optional;

public class CarDAO {

    public void create(Car car){
        EntityTransaction tr=null;
        try(EntityManager em= JpaUtil.getEM()){
            tr= em.getTransaction();
            tr.begin();
            em.persist(car);
            tr.commit();
        } catch (Exception e) {
            if(tr!=null && tr.isActive()){
                tr.rollback();
            }
        }
    }

    public void update(Car car){
        EntityTransaction tr=null;
        try(EntityManager em=JpaUtil.getEM()){
            tr=em.getTransaction();
            tr.begin();
            em.merge(car);
            tr.commit();
        } catch (Exception e) {
            if(tr!=null && tr.isActive()){
                tr.rollback();
            }
        }
    }

    public void delete(Long id){
        EntityTransaction tr=null;
        try(EntityManager em= JpaUtil.getEM()){
            tr=em.getTransaction();
            tr.begin();
            Car car=em.find(Car.class,id);
            if(car!=null){
                em.remove(car);
            }
            tr.commit();
        } catch (Exception e) {
            if(tr!=null && tr.isActive()){
                tr.rollback();
            }
        }
    }
    public Optional<Car> findById(Long id){
        try(EntityManager em=JpaUtil.getEM()){
            return Optional.ofNullable(em.find(Car.class,id));
        }
    }
    public List<Car> findAll(){
        try(EntityManager em=JpaUtil.getEM()){
            return em.createQuery("SELECT c FROM Car c", Car.class).getResultList();
        }
    }

    public List<Object[]> getContractByCustomer(String id){
        String query="select c.id, c.carName, rc.startDate, rc.endDate, rc.contractStatus"
                + " from Car c join c.rentalContracts rc"
              +  " where rc.customer.id = : customerId";
        try(EntityManager em=JpaUtil.getEM()){
            return em.createQuery(query).setParameter("customerId",id).getResultList();
        }
    }
}
