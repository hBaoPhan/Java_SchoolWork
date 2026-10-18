import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dto.reponse.CarReponseDTO;
import server.CarRemote;

public class Client {
	public static void main(String[] args) throws NamingException, RemoteException {
		Context context=new InitialContext();
		
		CarRemote carRemote=(CarRemote) context.lookup("rmi://192.168.137.1:1234/carRemote");
		
		CarReponseDTO carReponseDTO=carRemote.findById(3l);
		System.out.println(carReponseDTO);
	}

}
