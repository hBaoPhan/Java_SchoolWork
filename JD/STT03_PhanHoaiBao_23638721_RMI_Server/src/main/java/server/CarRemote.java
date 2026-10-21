package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.reponse.CarReponseDTO;
import dto.reponse.RentalContractHistoryDTO;
import dto.request.CarRequestDTO;

public interface CarRemote extends Remote {
	 public void create(CarRequestDTO car) throws RemoteException;
     public void update(CarRequestDTO car) throws RemoteException;
     public void delete(Long id) throws RemoteException;
     public CarReponseDTO findById(Long id) throws RemoteException;
     public List<CarReponseDTO> findALl() throws RemoteException;
     public List<RentalContractHistoryDTO> getContractByCustomer(String id) throws RemoteException;
}
