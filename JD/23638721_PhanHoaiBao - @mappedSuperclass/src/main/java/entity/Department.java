package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="departments")
public class Department {

    @Id
    @Column(name="dept_id",length = 45)
    private String id;

    @Column(name="dept_name",length = 100,unique = true,nullable = false)
    private String name;

    private String location;

//    @OneToMany(mappedBy = "department")
//    private List<Employee> employees;

    public Department() {
    }

}
