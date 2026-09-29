package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @Column(name = "carId")
    private Long id;
    private String carName;
    private String brand;
    private int seatCount;
    private double pricePerDay;
    private CarStatus status;

    @OneToMany(mappedBy = "car")
    private Set<RentalContract> rentalContracts;
}
