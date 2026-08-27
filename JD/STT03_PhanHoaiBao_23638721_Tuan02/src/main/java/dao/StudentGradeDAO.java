package dao;

import Util.JPAUtility;
import entity.StudentGrade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class StudentGradeDAO {
    public StudentGrade create(StudentGrade studentGrade){
        EntityTransaction tr=null;

        try(EntityManager em= JPAUtility.getEntityManager()){
            tr=em.getTransaction();
            tr.begin();
            em.persist(studentGrade);
            tr.commit();
            return studentGrade;
        }catch (Exception e){
            if(tr.isActive()){
                tr.rollback();
            }
            return null;
        }

    }
    public StudentGrade update(StudentGrade studentGrade){
        EntityTransaction tr=null;
        try(EntityManager em=JPAUtility.getEntityManager()){
            tr=em.getTransaction();
            tr.begin();
            em.merge(studentGrade);

            tr.commit();
            return studentGrade;
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
            em.remove(em.find(StudentGrade.class,id));
            tr.commit();


        } catch (Exception e) {
            if(tr.isActive()){
                tr.rollback();
            }
        }
    }
    public Optional<StudentGrade> findById(int id){
        EntityManager em= JPAUtility.getEntityManager();
        return Optional.ofNullable(em.find(StudentGrade.class,id));
    }
    public List<StudentGrade> findAll(){
        EntityManager em=JPAUtility.getEntityManager();
        return em.createQuery("SELECT p from StudentGrade p", StudentGrade.class).getResultList();
    }
}
