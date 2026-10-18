package dto;

import java.io.Serializable;

import enums.CarStatus;

public record CarResponseDTO (
		 Long id,
		 String carName,
		 String licensePlate,
		 CarStatus status
		) implements Serializable {
	
}
