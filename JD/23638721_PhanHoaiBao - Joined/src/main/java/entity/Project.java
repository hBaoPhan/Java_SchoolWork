package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="proj_id")
    private Long id;

    @Column(name="proj_name",length = 100,unique = true,nullable = false)
    private String name;
    private BigDecimal budget;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;

//    @ManyToMany(mappedBy = "projects")
//    private Set<Employee> employees;

    @OneToMany(mappedBy = "project")
    private List<EmployeeProject> employeeProjects;
}
