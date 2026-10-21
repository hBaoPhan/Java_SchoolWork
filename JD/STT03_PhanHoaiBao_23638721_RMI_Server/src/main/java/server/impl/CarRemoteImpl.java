package server.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dto.reponse.CarReponseDTO;
import dto.reponse.RentalContractHistoryDTO;
import dto.request.CarRequestDTO;
import server.CarRemote;
import service.impl.CarService;

public class CarRemoteImpl extends UnicastRemoteObject implements CarRemote {
	
	private final CarService carService =new CarService();

	public CarRemoteImpl() throws RemoteException {
		super();
	}

	@Override
	public void create(CarRequestDTO car) throws RemoteException {
		carService.create(car);
		
	}

	@Override
	public void update(CarRequestDTO car) throws RemoteException {
		carService.update(car);
		
	}

	@Override
	public void delete(Long id) throws RemoteException {
		carService.delete(id);
		
	}

	@Override
	public CarReponseDTO findById(Long id) {
		
		return carService.findById(id);
	}

	@Override
	public List<CarReponseDTO> findALl() throws RemoteException {
		// TODO Auto-generated method stub
		return carService.findALl();
	}

	@Override
	public List<RentalContractHistoryDTO> getContractByCustomer(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return carService.getContractByCustomer(id);
	}

}
