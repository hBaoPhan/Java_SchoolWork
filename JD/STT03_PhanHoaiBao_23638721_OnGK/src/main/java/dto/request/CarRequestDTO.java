package dto.request;

import entity.CarStatus;
import lombok.Getter;

@Getter
public class CarRequestDTO {
    private Long id;
    private String carName;
    private String brand;
    private int seatCount;
    private String licensePlate;
    private double pricePerDay;
    private CarStatus status;
}
