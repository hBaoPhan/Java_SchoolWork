package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
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
    private String licensePlate;
    private double pricePerDay;
    @Enumerated(EnumType.STRING)
    private CarStatus status;

    @OneToMany(mappedBy = "car")
    private Set<RentalContract> rentalContracts;

    public Car(Long id, CarStatus status, double pricePerDay, String licensePlate, int seatCount, String brand, String carName) {
        this.id = id;
        this.status = status;
        this.pricePerDay = pricePerDay;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.brand = brand;
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", id=" + id +
                ", brand='" + brand + '\'' +
                ", seatCount=" + seatCount +
                ", licensePlate='" + licensePlate + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", status=" + status +
                '}';
    }
}
