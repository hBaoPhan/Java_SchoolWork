package dao;

import java.util.List;

import entity.Course;
import entity.Department;
import jakarta.persistence.EntityManager;
import util.JPAUtil;

public class CourseDao {
	public List<Course> findCoursesByDeptName(String name){
		
		String query = """
				
				select c from Course c 
				join c.department d
				where d.name = :x
					
				""";
		
		try(EntityManager em = JPAUtil.getEntityManager()){
			return em.createQuery(query, Course.class)
					.setParameter("x", name)
					.getResultList();
		}
	}
		
	
	public List<Object[]> getNumberOfStudentsByDepartment(){
		String query = """
				
				select d, count(distinct sg.student) as n 
				from Department d 
				join d.courses c
				join c.studentGrades sg 
				group by d
				order by n desc
				
				""";
		
		try(EntityManager em = JPAUtil.getEntityManager()){
			return em.createQuery(query, Object[].class)
					.getResultList();
		}
	}
	
	public static void main(String[] args) {
		CourseDao courseDao = new CourseDao();
		courseDao.getNumberOfStudentsByDepartment()
		.forEach(arr -> System.out.println(arr[0] +", number of students: " + arr[1]));
		
//		courseDao.findCoursesByDeptName("Economics")
//		.forEach(c -> System.out.println(c));
	}
}
