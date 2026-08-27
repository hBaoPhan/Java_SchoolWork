package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity
public class Department {
    @Id
    @Column(name = "DepartmentID")
    private int id;

    private int administrator;

    private double budget;
    private String name;
    private LocalDateTime startDate;


}
