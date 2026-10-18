package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.CarRequestDTO;
import dto.CarResponseDTO;
import dto.RentalContractHistoryDTO;

public interface CarRemote extends Remote{
	void add(CarRequestDTO carRequestDTO) throws RemoteException;
	void update(CarRequestDTO carRequestDTO) throws RemoteException;
	CarResponseDTO findById(Long carId) throws RemoteException;
	List<CarResponseDTO> findAll() throws RemoteException;
	List<RentalContractHistoryDTO> listHistoryRentalByCustomer(String customerId) throws RemoteException;
}
