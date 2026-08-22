package entity;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("FULLTIME")
public class FullTimeEmployee extends Employee{
    private BigDecimal monthlySalary;

    public FullTimeEmployee(BigDecimal monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public FullTimeEmployee(String name, String email,  LocalDate hireDate, BigDecimal monthlySalary) {
        super(name, email, hireDate);
        this.monthlySalary = monthlySalary;
    }

    public FullTimeEmployee() {

    }

    public BigDecimal getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(BigDecimal monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}
