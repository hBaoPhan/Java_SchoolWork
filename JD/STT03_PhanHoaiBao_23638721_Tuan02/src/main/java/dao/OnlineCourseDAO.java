package dao;

import Util.JPAUtility;
import entity.OnlineCourse ;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class OnlineCourseDAO {
    public OnlineCourse create(OnlineCourse course){
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
    public OnlineCourse update(OnlineCourse course){
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
            em.remove(em.find(OnlineCourse .class,id));
            tr.commit();


        } catch (Exception e) {
            if(tr.isActive()){
                tr.rollback();
            }
        }
    }
    public Optional<OnlineCourse > findById(int id){
        EntityManager em=JPAUtility.getEntityManager();
        return Optional.ofNullable(em.find(OnlineCourse .class,id));
    }
    public List<OnlineCourse > findAll(){
        EntityManager em=JPAUtility.getEntityManager();
        return em.createQuery("SELECT p from OnlineCourse p", OnlineCourse.class).getResultList();
    }
}
