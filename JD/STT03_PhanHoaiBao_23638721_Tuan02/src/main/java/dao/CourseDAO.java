package dao;

import Util.JPAUtility;
import entity.Course;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class CourseDAO {

    public Course create(Course course) {
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

    public Course update(Course course) {
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
            Course course = em.find(Course.class, id);
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

    public Optional<Course> findById(int id) {
        try (EntityManager em = JPAUtility.getEntityManager()) {
            return Optional.ofNullable(em.find(Course.class, id));
        }
    }

    public List<Course> findAll() {
        try (EntityManager em = JPAUtility.getEntityManager()) {
            return em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
        }
    }

    public List<Student> listStudentsStudyingCourseWithHighestScore(String courseName) {
        try (EntityManager em = JPAUtility.getEntityManager()) {
            String jpql = "SELECT sg.student " +
                    "FROM StudentGrade sg " +
                    "WHERE sg.course.title = :courseName " +
                    "  AND sg.grade = (" +
                    "      SELECT MAX(sg2.grade) " +
                    "      FROM StudentGrade sg2 " +
                    "      WHERE sg2.course.title = :courseName" +
                    "  )";
            return em.createQuery(jpql, Student.class)
                    .setParameter("courseName", courseName)
                    .getResultList();
        }
    }
}
