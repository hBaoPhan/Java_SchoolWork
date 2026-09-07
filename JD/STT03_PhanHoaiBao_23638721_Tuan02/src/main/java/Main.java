import dao.DepartmentDAO;
import dao.PersonDAO;
import entity.Department;
import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        PersonDAO personDAO=new PersonDAO();
//        System.out.println( personDAO.findById(1));

        DepartmentDAO departmentDAO = new DepartmentDAO();
        List<Object[]> ds = departmentDAO.getNumberOfStudentsByDepartment();
        ds.forEach( a-> System.out.println("Phòng ban: "+a[0]+": "+a[1]));

    }

}
