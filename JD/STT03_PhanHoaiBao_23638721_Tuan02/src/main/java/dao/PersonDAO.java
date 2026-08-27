package dao;

import Util.JPAUtility;
import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class PersonDAO {
    public Person create(Person person){
        EntityTransaction tr=null;

        try(EntityManager em= JPAUtility.getEntityManager()){
            tr=em.getTransaction();
            tr.begin();
            em.persist(person);
            tr.commit();
            return person;
        }catch (Exception e){
            if(tr.isActive()){
                tr.rollback();
            }
            return null;
        }

    }
    public Person update(Person person){
        EntityTransaction tr=null;
        try(EntityManager em=JPAUtility.getEntityManager()){
            tr=em.getTransaction();
            tr.begin();
            em.merge(person);

            tr.commit();
            return person;
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
            em.remove(em.find(Person.class,id));
            tr.commit();


        } catch (Exception e) {
            if(tr.isActive()){
                tr.rollback();
            }
        }
    }
    public Optional<Person> findById(int id){
        EntityManager em=JPAUtility.getEntityManager();
        return Optional.ofNullable(em.find(Person.class,id));
    }
    public List<Person> findAll(){
        EntityManager em=JPAUtility.getEntityManager();
        return em.createQuery("SELECT p from Person p", Person.class).getResultList();
    }
}
