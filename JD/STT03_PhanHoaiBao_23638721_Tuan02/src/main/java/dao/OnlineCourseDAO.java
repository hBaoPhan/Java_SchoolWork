package dao;

import Util.JPAUtility;
import entity.Course;
import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class CourseDAO {
    public Course create(Course course){
        EntityTransaction tr=null;

        try(EntityManager em= JPAUtility.getEntityManager()){
            tr=em.getTransaction();
            tr.begin();
            em.persist(course);
            tr.commit();
            return course;
        }catch (Exception e){
            if(tr.isActive()){
                tr.rollback();
            }
            return null;
        }

    }
    public Course update(Course course){
        EntityTransaction tr=null;
        try(EntityManager em=JPAUtility.getEntityManager()){
            tr=em.getTransaction();
            tr.begin();
            em.merge(course);

            tr.commit();
            return course;
        } catch (Exception e) {
            if(tr.isActive()){
                tr.rollback();
            }
            return null;

        }
    }
    public void delete(int id){
        EntityTransaction tr=null;
        try(EntityManager em=JPAUtility.getEntityManager()){
            tr=em.getTransaction();
            tr.begin();
            em.remove(em.find(Course.class,id));
            tr.commit();


        } catch (Exception e) {
            if(tr.isActive()){
                tr.rollback();
            }
        }
    }
    public Optional<Course> findById(int id){
        EntityManager em=JPAUtility.getEntityManager();
        return Optional.ofNullable(em.find(Course.class,id));
    }
    public List<Course> findAll(){
        EntityManager em=JPAUtility.getEntityManager();
        return em.createQuery("SELECT p from Course p", Course.class).getResultList();
    }
}
