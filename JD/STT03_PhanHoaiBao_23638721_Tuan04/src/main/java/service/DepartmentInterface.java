package service;

import dto.DepartmentRequestDTO;
import dto.DepartmentResponseDTO;
import entity.Department;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentInterface {

    public void create(DepartmentRequestDTO departmentRequestDTO);
    public void delete(int departmentId);
    public void update(DepartmentRequestDTO departmentRequestDTO);
    public DepartmentResponseDTO findById(int id);
    public List<DepartmentResponseDTO> findAll();
    public Map<DepartmentResponseDTO, Long> getNumberOfStudentsByDepartment();
    public List<DepartmentResponseDTO> listDepartmentsWithoutStudents();
}
