package entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee_projects")
@IdClass(EmployeeProjectId.class)
public class EmployeeProject {
//    @Id
//    @ManyToOne
//    @JoinColumn(name="emp_id")
//    private Employee employee;

    @Id
    @ManyToOne
    @JoinColumn(name="proj_id")
    private Project project;

    private int hours;

    public EmployeeProject() {
    }
}
