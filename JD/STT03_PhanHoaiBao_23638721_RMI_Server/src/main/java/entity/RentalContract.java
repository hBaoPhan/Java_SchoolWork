package entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "RentalContracts")
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

    @Enumerated(EnumType.STRING)
    private ContractStatus contractStatus;

}
