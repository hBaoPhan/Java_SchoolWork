import dao.DepartmentDAO;
import dao.PersonDAO;
import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
//        PersonDAO personDAO=new PersonDAO();
//        System.out.println( personDAO.findById(1));

        DepartmentDAO departmentDAO=new DepartmentDAO();
        System.out.println(departmentDAO.getNumberOfStudentsByDepartment().entrySet().stream().findFirst());


    }

}
