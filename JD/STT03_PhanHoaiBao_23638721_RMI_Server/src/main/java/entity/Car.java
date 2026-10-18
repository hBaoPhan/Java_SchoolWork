package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

import enums.CarStatus;

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

    public Car() {
    }

    public Car(Long id, CarStatus status, double pricePerDay, String licensePlate, int seatCount, String brand, String carName) {
        this.id = id;
        this.status = status;
        this.pricePerDay = pricePerDay;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.brand = brand;
        this.carName = carName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRentalContracts(Set<RentalContract> rentalContracts) {
        this.rentalContracts = rentalContracts;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public CarStatus getStatus() {
        return status;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public String getBrand() {
        return brand;
    }

    public String getCarName() {
        return carName;
    }

    public Long getId() {
        return id;
    }

    public Set<RentalContract> getRentalContracts() {
        return rentalContracts;
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
