import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import server.CarRemote;

public class Client {
	public static void main(String[] args) throws NamingException, RemoteException {
		Context context=new InitialContext();
		
		CarRemote carRemote=(CarRemote) context.lookup("rmi://192.168.1.6:8721/carRemote");
		System.out.println(carRemote.findById(7l));
		carRemote.findALl().forEach(car -> System.out.println(car));
				
				
		
	}

}
