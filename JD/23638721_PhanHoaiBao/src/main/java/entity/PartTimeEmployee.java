package entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("PARTTIME")
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
