package dto;

import entity.Department;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class DepartmentResponseDTO {
    private double budget;
    private String name;
    private LocalDateTime startDate;

    public DepartmentResponseDTO(Department department) {
        this.budget = department.getBudget();
        this.name = department.getName();
        this.startDate = department.getStartDate();
    }

    public DepartmentResponseDTO(double budget, String name, LocalDateTime startDate) {
        this.budget = budget;
        this.name = name;
        this.startDate = startDate;
    }


}
