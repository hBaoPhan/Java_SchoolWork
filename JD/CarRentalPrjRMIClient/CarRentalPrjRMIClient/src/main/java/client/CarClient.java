package client;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dto.CarRequestDTO;
import dto.CarResponseDTO;
import server.CarRemote;

public class CarClient {
	public static void main(String[] args) throws NamingException, RemoteException {
		Context context = new InitialContext();
		
		CarRemote carRemote = (CarRemote) context.lookup("rmi://H31M50:1234/carRemote");
		
		CarResponseDTO carResponseDTO = carRemote.findById(7l);
		System.out.println(carResponseDTO);
		
		carRemote.add(newCar());
	}

	private static CarRequestDTO newCar() {
		return null;
	}
}
