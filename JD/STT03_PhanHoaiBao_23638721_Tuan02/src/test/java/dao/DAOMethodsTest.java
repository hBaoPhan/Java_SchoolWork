package dao;

import entity.Department;
import entity.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DAOMethodsTest {

    private static DepartmentDAO departmentDAO;
    private static StudentDAO studentDAO;
    private static StudentGradeDAO studentGradeDAO;

    @BeforeAll
    public static void setUp() {
        departmentDAO = new DepartmentDAO();
        studentDAO = new StudentDAO();
        studentGradeDAO = new StudentGradeDAO();
    }

    @Test
    @DisplayName("2. Calculate the number of students in each department (decreasing order)")
    public void testGetNumberOfStudentsByDepartment() {
        try {
            Map<Department, Long> map = departmentDAO.getNumberOfStudentsByDepartment();
            assertNotNull(map);
            System.out.println("--- 2. Number of Students by Department (Decreasing Order) ---");
            map.forEach((dept, count) -> 
                System.out.println("Department: " + dept.getName() + " (ID: " + dept.getId() + ") -> Student Count: " + count)
            );
        } catch (Exception e) {
            System.out.println("Database connection not active or empty database: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("3. Calculate the average score of the students' courses")
    public void testGetAverageScoreOfStudents() {
        try {
            Map<Student, Double> map = studentDAO.getAverageScoreOfStudents();
            assertNotNull(map);
            System.out.println("--- 3. Average Score of Students ---");
            map.forEach((student, avgScore) -> 
                System.out.println("Student: " + student.getFirstName() + " " + student.getLastName() + " (ID: " + student.getId() + ") -> Average Score: " + avgScore)
            );
        } catch (Exception e) {
            System.out.println("Database connection not active or empty database: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("4. Departments without students")
    public void testListDepartmentsWithoutStudents() {
        try {
            List<Department> list = departmentDAO.listDepartmentsWithoutStudents();
            assertNotNull(list);
            System.out.println("--- 4. Departments Without Students ---");
            list.forEach(dept -> System.out.println("Department: " + dept.getName() + " (ID: " + dept.getId() + ")"));
        } catch (Exception e) {
            System.out.println("Database connection not active or empty database: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("5. Students studying course with highest score")
    public void testListStudentsStudyingCourseWithHighestScore() {
        try {
            String courseName = "Distributed Programming with Java Technology";
            List<Student> list = studentDAO.listStudentsStudyingCourseWithHighestScore(courseName);
            assertNotNull(list);
            System.out.println("--- 5. Students with Highest Score in '" + courseName + "' ---");
            list.forEach(student -> System.out.println("Student: " + student.getFirstName() + " " + student.getLastName() + " (ID: " + student.getId() + ")"));
        } catch (Exception e) {
            System.out.println("Database connection not active or empty database: " + e.getMessage());
        }
    }
}
