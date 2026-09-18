package dao;

import entity.OnsiteCourse;
import util.JPAUtility;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class OnsiteCourseDAO {
    public OnsiteCourse create(OnsiteCourse course) {
        EntityTransaction tr = null;
        try (EntityManager em = JPAUtility.getEntityManager()) {
            tr = em.getTransaction();
            tr.begin();
            em.persist(course);
            tr.commit();
            return course;
        } catch (Exception e) {
            if (tr != null && tr.isActive()) {
                tr.rollback();
            }
            return null;
        }
    }

    public OnsiteCourse update(OnsiteCourse course) {
        EntityTransaction tr = null;
        try (EntityManager em = JPAUtility.getEntityManager()) {
            tr = em.getTransaction();
            tr.begin();
            em.merge(course);
            tr.commit();
            return course;
        } catch (Exception e) {
            if (tr != null && tr.isActive()) {
                tr.rollback();
            }
            return null;
        }
    }

    public void delete(int id) {
        EntityTransaction tr = null;
        try (EntityManager em = JPAUtility.getEntityManager()) {
            tr = em.getTransaction();
            tr.begin();
            OnsiteCourse course = em.find(OnsiteCourse.class, id);
            if (course != null) {
                em.remove(course);
            }
            tr.commit();
        } catch (Exception e) {
            if (tr != null && tr.isActive()) {
                tr.rollback();
            }
        }
    }

    public Optional<OnsiteCourse> findById(int id) {
        try (EntityManager em = JPAUtility.getEntityManager()) {
            return Optional.ofNullable(em.find(OnsiteCourse.class, id));
        }
    }

    public List<OnsiteCourse> findAll() {
        try (EntityManager em = JPAUtility.getEntityManager()) {
            return em.createQuery("SELECT c FROM OnsiteCourse c", OnsiteCourse.class).getResultList();
        }
    }
}
