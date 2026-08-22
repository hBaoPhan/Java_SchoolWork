package entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "part_time_employees")
public class PartTimeEmployee extends Employee{
    @Column(name = "hourly_rate")
    private BigDecimal hourlyRate;
    private int hours;

}
