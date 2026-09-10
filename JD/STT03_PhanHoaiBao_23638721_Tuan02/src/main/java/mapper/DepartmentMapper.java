package mapper;

import dto.DepartmentRequestDTO;
import dto.DepartmentResponseDTO;
import entity.Department;

public class DepartmentMapper {

    public static Department toEntity(DepartmentRequestDTO departmentRequestDTO){
        return new Department(departmentRequestDTO.getId(),departmentRequestDTO.getAdministrator(), departmentRequestDTO.getBudget(), departmentRequestDTO.getName(),departmentRequestDTO.getStartDate());
    }

    public static DepartmentResponseDTO toDTO(Department department){
        return new DepartmentResponseDTO(department.getBudget(),department.getName(),department.getStartDate());
    }




}
