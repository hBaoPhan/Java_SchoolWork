package dao;

import Util.JPAUtility;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class OnSiteCourse {
    public OnSiteCourse create(OnSiteCourse onsiteCourse){
        EntityTransaction tr=null;

        try(EntityManager em= JPAUtility.getEntityManager()){
            tr=em.getTransaction();
            tr.begin();
            em.persist(onsiteCourse);
            tr.commit();
            return onsiteCourse;
        }catch (Exception e){
            if(tr.isActive()){
                tr.rollback();
            }
            return null;
        }

    }
    public OnSiteCourse update(OnSiteCourse onsiteCourse){
        EntityTransaction tr=null;
        try(EntityManager em=JPAUtility.getEntityManager()){
            tr=em.getTransaction();
            tr.begin();
            em.merge(onsiteCourse);

            tr.commit();
            return onsiteCourse;
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
            em.remove(em.find(OnSiteCourse.class,id));
            tr.commit();


        } catch (Exception e) {
            if(tr.isActive()){
                tr.rollback();
            }
        }
    }
    public Optional<OnSiteCourse> findById(int id){
        EntityManager em=JPAUtility.getEntityManager();
        return Optional.ofNullable(em.find(OnSiteCourse.class,id));
    }
    public List<OnSiteCourse> findAll(){
        EntityManager em= JPAUtility.getEntityManager();
        return em.createQuery("SELECT p from OnSiteCourse p", OnSiteCourse.class).getResultList();
    }
}
