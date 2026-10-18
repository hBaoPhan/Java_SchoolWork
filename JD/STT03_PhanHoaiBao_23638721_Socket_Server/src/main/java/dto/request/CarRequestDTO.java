package dto.request;

import enums.CarStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CarRequestDTO {
    private Long id;
    private String carName;
    private String brand;
    private int seatCount;
    private String licensePlate;
    private double pricePerDay;
    private CarStatus status;

    public CarRequestDTO(CarStatus status, double pricePerDay, String licensePlate, int seatCount, String brand, String carName, Long id) {
        this.status = status;
        this.pricePerDay = pricePerDay;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.brand = brand;
        this.carName = carName;
        this.id = id;
    }
}
