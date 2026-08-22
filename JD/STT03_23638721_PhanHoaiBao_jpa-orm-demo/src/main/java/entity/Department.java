package entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "dept_id", length = 15)
    private String id;

    @Column(name = "dept_name", unique = true, nullable = false)
    private String name;	

    private String location;


    @OneToMany(mappedBy = "department")
    private List<Employee> employees; //inverse side

    public Department(){} //default constructor/ no-args constructor

    public Department(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
