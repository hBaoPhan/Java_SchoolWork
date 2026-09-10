package service.impl;

import dao.DepartmentDAO;
import dto.DepartmentResponseDTO;
import entity.Department;
import mapper.DepartmentMapper;
import service.DepartmentInterface;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DepartmentService implements DepartmentInterface {
    private DepartmentDAO departmentDAO=new DepartmentDAO();
    @Override
    public void create(Department department) {
        departmentDAO.create(department);
    }

    @Override
    public void delete(int departmentId) {
        departmentDAO.delete(departmentId);
    }

    @Override
    public void update(Department department) {
        departmentDAO.update(department);
    }

    @Override
    public DepartmentResponseDTO findById(int id) {
        return DepartmentMapper.toDTO(departmentDAO.findById(id).get());
    }

    @Override
    public List<DepartmentResponseDTO> findAll() {
        return departmentDAO.findAll()
                .stream()
                .map(DepartmentResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<DepartmentResponseDTO> getNumberOfStudentsByDepartment() {
        return departmentDAO.getNumberOfStudentsByDepartment()
                .stream()
                .map(DepartmentResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<DepartmentResponseDTO> listDepartmentsWithoutStudents() {
        return null;
    }
}
