package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class RentalContract {

    @Id
    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    @Id
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Id
    private LocalDate startDate;
    private LocalDate endDate;
    private ContractStatus contractStatus;

}
