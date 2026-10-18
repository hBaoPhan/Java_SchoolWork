package server.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dto.CarRequestDTO;
import dto.CarResponseDTO;
import dto.RentalContractHistoryDTO;
import server.CarRemote;
import service.CarService;
import service.impl.CarServiceImpl;

public class CarRemoteImpl extends UnicastRemoteObject implements CarRemote{
	
	private final CarService carService = new CarServiceImpl();
	
	public CarRemoteImpl() throws RemoteException {
		super();
	}

	@Override
	public void add(CarRequestDTO carRequestDTO) throws RemoteException {
		carService.add(carRequestDTO);
	}

	@Override
	public void update(CarRequestDTO carRequestDTO) throws RemoteException {
		carService.update(carRequestDTO);
	}

	@Override
	public CarResponseDTO findById(Long carId) throws RemoteException {
		return carService.findById(carId);
	}

	@Override
	public List<CarResponseDTO> findAll() throws RemoteException {
		return carService.findAll();
	}

	@Override
	public List<RentalContractHistoryDTO> listHistoryRentalByCustomer(String customerId) throws RemoteException {
		return carService.listHistoryRentalByCustomer(customerId);
	}

}
