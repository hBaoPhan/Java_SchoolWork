package dao;

import entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import utils.JPAUtiliti;

import java.util.List;
import java.util.Optional;

public class DepartmentDao {

    public Department create(Department department){

        EntityTransaction tr=null;
        try(EntityManager em= JPAUtiliti.getEntityManager()){
            tr=em.getTransaction();
            tr.begin();
            em.persist(department);
            tr.commit();
            return department;
        } catch (Exception e) {
            if(tr.isActive()){
                tr.rollback();
            }
            e.printStackTrace();
            return null;

        }
    }
    public Department update(Department department){

        EntityTransaction tr=null;
        try(EntityManager em= JPAUtiliti.getEntityManager()){
            tr=em.getTransaction();
            tr.begin();
            em.merge(department);
            tr.commit();
            return department;
        } catch (Exception e) {
            if(tr.isActive()){
                tr.rollback();
            }
            e.printStackTrace();
            return null;

        }
    }
    public void delete(String id) {

        EntityTransaction tr = null;
        try (EntityManager em = JPAUtiliti.getEntityManager()) {
            tr = em.getTransaction();
            Department department = em.find(Department.class, id);
            tr.begin();
            em.remove(department);
            tr.commit();

        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();


        }
    }
    public Optional<Department> findById(String id){
        EntityManager em=JPAUtiliti.getEntityManager();
        return Optional .ofNullable(em.find(Department.class,id));
    }

    public List<Department> findAll(){
        EntityManager em=JPAUtiliti.getEntityManager();
        return em.createQuery("SELECT d FROM Department d",Department.class).getResultList();
    }
}
