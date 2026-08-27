package dao;

import Util.JPAUtility;
import entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DepartmentDAO {
    public Department create(Department department) {
        EntityTransaction tr = null;

        try (EntityManager em = JPAUtility.getEntityManager()) {
            tr = em.getTransaction();
            tr.begin();
            em.persist(department);
            tr.commit();
            return department;
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            return null;
        }

    }

    public Department update(Department department) {
        EntityTransaction tr = null;
        try (EntityManager em = JPAUtility.getEntityManager()) {
            tr = em.getTransaction();
            tr.begin();
            em.merge(department);

            tr.commit();
            return department;
        } catch (Exception e) {
            if (tr.isActive()) {
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
            em.remove(em.find(Department.class, id));
            tr.commit();

        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
        }
    }

    public Optional<Department> findById(int id) {
        EntityManager em = JPAUtility.getEntityManager();
        return Optional.ofNullable(em.find(Department.class, id));
    }

    public List<Department> findAll() {
        EntityManager em = JPAUtility.getEntityManager();
        return em.createQuery("SELECT p from Department p", Department.class).getResultList();
    }

    public Map<Department, Long> getNumberOfStudentsByDepartment() {
        try (EntityManager em = JPAUtility.getEntityManager()) {
            String jpql = "SELECT d, COUNT(DISTINCT sg.student) " +
                    "FROM Department d " +
                    "LEFT JOIN d.courses c " +
                    "LEFT JOIN c.studentGrades sg " +
                    "GROUP BY d " +
                    "ORDER BY COUNT(DISTINCT sg.student) DESC";
            List<Object[]> results = em.createQuery(jpql, Object[].class).getResultList();

            java.util.Map<Department, Long> map = new java.util.LinkedHashMap<>();
            for (Object[] row : results) {
                Department dept = (Department) row[0];
                Long count = (Long) row[1];
                map.put(dept, count);
            }
            return map;
        }
    }

    public List<Department> listDepartmentsWithoutStudents() {
        try (EntityManager em = JPAUtility.getEntityManager()) {
            String jpql = "SELECT d FROM Department d WHERE NOT EXISTS (" +
                    "  SELECT 1 FROM StudentGrade sg JOIN sg.course c WHERE c.department = d" +
                    ")";
            return em.createQuery(jpql, Department.class).getResultList();
        }
    }
}
