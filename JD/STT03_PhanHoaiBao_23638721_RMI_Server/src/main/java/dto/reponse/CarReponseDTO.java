package dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import enums.CarStatus;

@Getter
@Setter
@AllArgsConstructor
public class CarReponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String carName;
    private String brand;
    private int seatCount;
    private String licensePlate;
    private double pricePerDay;
    private CarStatus status;
}
