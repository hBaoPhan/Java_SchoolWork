package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees_profiles")
public class EmployeeProfile {

    @Id
    @Column(name = "emp_id")
    private Long id;

    private String address;
    private String phone;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @OneToOne
    @MapsId
    @JoinColumn(name = "emp_id")
    private Employee employee;

    public EmployeeProfile(){}
}
