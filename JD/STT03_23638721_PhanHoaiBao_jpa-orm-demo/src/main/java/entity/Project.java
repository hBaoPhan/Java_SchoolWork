package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prj_id")
    private Long id;

    @Column(name = "prj_name", nullable = false)
    private String name;
    private BigDecimal budget;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    //inverse side
    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees;

    public Project(){}

}
