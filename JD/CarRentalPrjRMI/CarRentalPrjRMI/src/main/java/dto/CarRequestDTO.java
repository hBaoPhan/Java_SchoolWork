package dto;

import java.io.Serializable;

import enums.CarStatus;

public record CarRequestDTO(
		 Long id,
		 String carName,
		 String brand,
		 String licensePlate,
		 int seatCount,
		 double pricePerDay,
		 CarStatus status
		) implements Serializable{
	
}
