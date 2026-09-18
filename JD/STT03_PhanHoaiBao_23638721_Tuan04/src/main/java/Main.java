import dao.DepartmentDAO;
import dao.PersonDAO;
import dto.DepartmentResponseDTO;
import entity.Department;
import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import service.impl.DepartmentService;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        PersonDAO personDAO=new PersonDAO();
//        System.out.println( personDAO.findById(1));

//        DepartmentDAO departmentDAO = new DepartmentDAO();
//        List<Object[]> ds = departmentDAO.getNumberOfStudentsByDepartment();
//        ds.forEach( a-> System.out.println("Phòng ban: "+a[0]+": "+a[1]));
//
        DepartmentService departmentService=new DepartmentService();
//        departmentService.findAll().forEach( a-> System.out.println(a.getName()));
        Map<DepartmentResponseDTO,Long> map=departmentService.getNumberOfStudentsByDepartment();
        map.forEach((k,v)-> System.out.println(k+" "+v));

    }

}
