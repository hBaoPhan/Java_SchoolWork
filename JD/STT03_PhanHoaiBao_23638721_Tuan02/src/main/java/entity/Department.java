package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity
public class Department {
    @Id
    private int id;

    private int adminstrator;

    private double budget;
    private String name;
    private LocalDateTime startDate;


}
