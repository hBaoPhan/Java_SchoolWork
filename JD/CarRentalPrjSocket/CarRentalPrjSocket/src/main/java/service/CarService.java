package service;

import java.util.List;

import dto.CarRequestDTO;
import dto.CarResponseDTO;
import dto.RentalContractHistoryDTO;

public interface CarService{
	void add(CarRequestDTO carRequestDTO);
	void update(CarRequestDTO carRequestDTO);
	void delete (Long carId);
	CarResponseDTO findById(Long carId);
	List<CarResponseDTO> findAll();
	List<RentalContractHistoryDTO> listHistoryRentalByCustomer(String customerId);
}
