package mapper;

import java.time.LocalDate;

import dto.CarRequestDTO;
import dto.CarResponseDTO;
import dto.RentalContractHistoryDTO;
import entity.Car;
import enums.ContractStatus;

public class CarMapper {
	
	public Car toCar(CarRequestDTO dto) {
		Car car = new Car();
		car.setId(dto.id());
		car.setCarName(dto.carName());
		car.setBrand(dto.brand());
		car.setLicensePlate(dto.licensePlate());
		car.setSeatCount(dto.seatCount());
		car.setPricePerDay(dto.pricePerDay());
		car.setStatus(dto.status());
		return car;
	}
	
	public CarResponseDTO toResponseDTO(Car car) {
		return new CarResponseDTO(car.getId(), 
				car.getCarName(), 
				car.getLicensePlate(), 
				car.getStatus());
	}
	
	public RentalContractHistoryDTO toDto(Object[] a) {
		return new RentalContractHistoryDTO((Long)a[0], 
				(String)a[1], (LocalDate)a[2], (LocalDate)a[3], (ContractStatus)a[4]);
	}
	
}
