package dao;

import Util.JPAUtility;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudentDAO {

    public Student create(Student student) {
        EntityTransaction tr = null;
        try (EntityManager em = JPAUtility.getEntityManager()) {
            tr = em.getTransaction();
            tr.begin();
            em.persist(student);
            tr.commit();
            return student;
        } catch (Exception e) {
            if (tr != null && tr.isActive()) {
                tr.rollback();
            }
            return null;
        }
    }

    public Student update(Student student) {
        EntityTransaction tr = null;
        try (EntityManager em = JPAUtility.getEntityManager()) {
            tr = em.getTransaction();
            tr.begin();
            em.merge(student);
            tr.commit();
            return student;
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
            Student student = em.find(Student.class, id);
            if (student != null) {
                em.remove(student);
            }
            tr.commit();
        } catch (Exception e) {
            if (tr != null && tr.isActive()) {
                tr.rollback();
            }
        }
    }

    public Optional<Student> findById(int id) {
        try (EntityManager em = JPAUtility.getEntityManager()) {
            return Optional.ofNullable(em.find(Student.class, id));
        }
    }

    public List<Student> findAll() {
        try (EntityManager em = JPAUtility.getEntityManager()) {
            return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        }
    }

    public Map<Student, Double> getAverageScoreOfStudents() {
        try (EntityManager em = JPAUtility.getEntityManager()) {
            String jpql = "SELECT sg.student, AVG(sg.grade) " +
                    "FROM StudentGrade sg " +
                    "WHERE sg.student IS NOT NULL " +
                    "GROUP BY sg.student";
            List<Object[]> results = em.createQuery(jpql, Object[].class).getResultList();

            Map<Student, Double> map = new LinkedHashMap<>();
            for (Object[] row : results) {
                Student student = (Student) row[0];
                Double avgGrade = (Double) row[1];
                map.put(student, avgGrade != null ? avgGrade : 0.0);
            }
            return map;
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
