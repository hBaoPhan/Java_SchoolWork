package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="employees")
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private Long id;

    @Column(name="emp_name",length = 100,nullable = false)
    private String name;

    @Column(name="emp_email",length = 100,unique = true)
    private String email;


    private LocalDate hireDate;

    @ManyToOne
    @JoinColumn(name="dept_id")
    private Department department;

    @OneToOne(mappedBy = "employee")
    private EmployeeProfile profile;

//    @ManyToMany
//    @JoinTable(name="employee_projects",joinColumns =@JoinColumn(name="empl_id"),
//    inverseJoinColumns = @JoinColumn(name="proj_id"))
//    private Set<Project> projects;

    //self reference
    @ManyToOne
    @JoinColumn(name="manager_id")
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    private List<Employee> employees;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeProject> employeeProjects;


    public Employee() {
    }


    public Employee(String name, String email,  LocalDate hireDate) {
        this.name = name;
        this.email = email;

        this.hireDate = hireDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setProfile(EmployeeProfile profile) {
        this.profile = profile;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setEmployeeProjects(List<EmployeeProject> employeeProjects) {
        this.employeeProjects = employeeProjects;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getManager() {
        return manager;
    }

    public EmployeeProfile getProfile() {
        return profile;
    }

    public Department getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }



    public LocalDate getHireDate() {
        return hireDate;
    }

    public List<EmployeeProject> getEmployeeProjects() {
        return employeeProjects;
    }
}
