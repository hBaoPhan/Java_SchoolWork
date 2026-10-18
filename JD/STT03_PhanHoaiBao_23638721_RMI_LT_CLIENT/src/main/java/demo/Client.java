package demo;

import server.CarRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) throws NamingException, RemoteException {
        Context context = new InitialContext();
        CarRemote car = (CarRemote) context.lookup("rmi://10.10.48.221:8721/carObj");
       System.out.println(car.findAll());
//        System.out.println(car.findById(100l));

    }
}
