package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import server.impl.CarRemoteImpl;






public class CarServer {
	public static void main(String[] args) throws NamingException, RemoteException {
		Context context=new InitialContext();
		LocateRegistry.createRegistry(8721);
		
		CarRemote carRemote=new CarRemoteImpl();
		context.rebind("rmi://192.168.1.6:8721/carRemote", carRemote);
		System.out.println("Ready..");
		
		
		
		
//		Context context=new InitialContext();
//        LocateRegistry.createRegistry(1234);
//
//        CarRemote carRemote=new CarRemoteImpl();
//        context.rebind("rmi://192.168.137.1:1234/carRemote",carRemote);
//        System.out.println("Ready..");

		
		

	}

}
