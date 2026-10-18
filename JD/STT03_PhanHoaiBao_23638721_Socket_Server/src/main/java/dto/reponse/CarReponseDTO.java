package dto.reponse;

import enums.CarStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarReponseDTO {
    private String carName;
    private String brand;
    private int seatCount;
    private String licensePlate;
    private double pricePerDay;
    private CarStatus status;
}
