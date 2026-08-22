package entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "full_time_employees")
public class FullTimeEmployee extends Employee{
    @Column(name = "monthly_salary")
    private BigDecimal monthlySalary;
}
