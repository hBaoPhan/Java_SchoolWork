package service.impl;

import dao.DepartmentDAO;
import dto.DepartmentRequestDTO;
import dto.DepartmentResponseDTO;
import entity.Department;
import mapper.DepartmentMapper;
import service.DepartmentInterface;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DepartmentService implements DepartmentInterface {
    private final DepartmentDAO departmentDAO=new DepartmentDAO();
    @Override
    public void create(DepartmentRequestDTO departmentRequestDTO) {

        departmentDAO.create(DepartmentMapper.toEntity(departmentRequestDTO));
    }

    @Override
    public void delete(int departmentId) {
        departmentDAO.delete(departmentId);
    }

    @Override
    public void update(DepartmentRequestDTO departmentRequestDTO) {

        departmentDAO.update(DepartmentMapper.toEntity(departmentRequestDTO));
    }

    @Override
    public DepartmentResponseDTO findById(int id) {
        return DepartmentMapper.toDTO(departmentDAO.findById(id).get());
    }

    @Override
    public List<DepartmentResponseDTO> findAll() {
        return departmentDAO.findAll()
                .stream()
                .map(DepartmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Map<DepartmentResponseDTO, Long> getNumberOfStudentsByDepartment() {
       return departmentDAO.getNumberOfStudentsByDepartment()
               .entrySet()
               .stream()
               .collect(Collectors.toMap(e -> DepartmentMapper.toDTO(e.getKey()),
                       Map.Entry::getValue));

    }
    @Override
    public List<DepartmentResponseDTO> listDepartmentsWithoutStudents() {
       return departmentDAO.listDepartmentsWithoutStudents()
               .stream()
               .map(DepartmentMapper::toDTO)
               .collect(Collectors.toList());
    }
}
