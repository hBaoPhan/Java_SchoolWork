package server;

import server.impl.CarRemoteImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class CarServer {
    public static void main(String[] args) throws RemoteException, NamingException {
        Context context=new InitialContext();
        LocateRegistry.createRegistry(1234);

        CarRemote carRemote=new CarRemoteImpl();
        context.rebind("rmi://192.168.137.1:1234/carRemote",carRemote);
        System.out.println("Ready..");


    }
}
