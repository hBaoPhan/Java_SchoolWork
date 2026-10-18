package dto.request;

import entity.CarStatus;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class CarRequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String carName;
    private String brand;
    private int seatCount;
    private String licensePlate;
    private double pricePerDay;
    private CarStatus status;
}
