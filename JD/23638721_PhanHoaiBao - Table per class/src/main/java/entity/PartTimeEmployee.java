package entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="part_time_employees")
public class PartTimeEmployee extends Employee {

   private BigDecimal hourlyRate;
   private int hours;

   public PartTimeEmployee(String name, String email, LocalDate hireDate, int hours, BigDecimal hourlyRate) {
      super(name, email, hireDate);
      this.hours = hours;
      this.hourlyRate = hourlyRate;
   }

   public PartTimeEmployee(int hours, BigDecimal hourlyRate) {
      this.hours = hours;
      this.hourlyRate = hourlyRate;
   }

   public PartTimeEmployee() {

   }

   public BigDecimal getHourlyRate() {
      return hourlyRate;
   }

   public int getHours() {
      return hours;
   }

   public void setHours(int hours) {
      this.hours = hours;
   }

   public void setHourlyRate(BigDecimal hourlyRate) {
      this.hourlyRate = hourlyRate;
   }
}
