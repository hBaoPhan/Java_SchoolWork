package dto;

import java.io.Serializable;
import java.time.LocalDate;

import enums.ContractStatus;

public record RentalContractHistoryDTO(
		Long id, 
		String carName, 
		LocalDate startDate, 
		LocalDate endDate,
		ContractStatus contractStatus) implements Serializable{

}
