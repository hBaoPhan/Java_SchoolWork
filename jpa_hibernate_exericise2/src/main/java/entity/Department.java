package entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@Column(name="DepartmentID")
    private int id;
	
    private String name;
    private double budget;
    private LocalDateTime startDate;
    private int administrator;
    
    @OneToMany(mappedBy = "department")
    private List<Course> courses; //inverse side
}