import dao.DepartmentDao;
import entity.Department;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        DepartmentDao departmentDao=new DepartmentDao();
//        Department department=new Department("D1111", "Information Technology","NY");
//        departmentDao.create(department);
        departmentDao.findAll().forEach(System.out::println);
    }
}
