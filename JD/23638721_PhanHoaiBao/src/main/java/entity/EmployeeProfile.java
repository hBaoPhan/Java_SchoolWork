package entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee_profiles")
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    private String address;
    private String gender;

    @OneToOne
    @JoinColumn(name="emp_id")
    @MapsId
    private Employee employee;

}
