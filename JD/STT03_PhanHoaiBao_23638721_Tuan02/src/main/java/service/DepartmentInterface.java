package service;

import dto.DepartmentResponseDTO;
import entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentInterface {

    public void create(Department department);
    public void delete(int departmentId);
    public void update(Department department);
    public DepartmentResponseDTO findById(int id);
    public List<DepartmentResponseDTO> findAll();
    public List<DepartmentResponseDTO> getNumberOfStudentsByDepartment();
    public List<DepartmentResponseDTO> listDepartmentsWithoutStudents();
}
