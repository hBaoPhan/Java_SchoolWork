package dao;

import entity.Student;
import util.JPAUtility;
import entity.StudentGrade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudentGradeDAO {
    public void create(StudentGrade studentGrade) {
        EntityTransaction tr = null;

        try (EntityManager em = JPAUtility.getEntityManager()) {
            tr = em.getTransaction();
            tr.begin();
            em.persist(studentGrade);
            tr.commit();

        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }

        }

    }

    public void update(StudentGrade studentGrade) {
        EntityTransaction tr = null;
        try (EntityManager em = JPAUtility.getEntityManager()) {
            tr = em.getTransaction();
            tr.begin();
            em.merge(studentGrade);

            tr.commit();

        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }


        }
    }

    public void delete(int id) {
        EntityTransaction tr = null;
        try (EntityManager em = JPAUtility.getEntityManager()) {
            tr = em.getTransaction();
            tr.begin();
            em.remove(em.find(StudentGrade.class, id));
            tr.commit();

        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
        }
    }

    public Optional<StudentGrade> findById(int id) {
        EntityManager em = JPAUtility.getEntityManager();
        return Optional.ofNullable(em.find(StudentGrade.class, id));
    }

    public List<StudentGrade> findAll() {
        EntityManager em = JPAUtility.getEntityManager();
        return em.createQuery("SELECT p from StudentGrade p", StudentGrade.class).getResultList();
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
                entity.Student student = (entity.Student) row[0];
                Double avgGrade = (Double) row[1];
                map.put(student, avgGrade != null ? avgGrade : 0.0);
            }
            return map;
        }
    }

}
