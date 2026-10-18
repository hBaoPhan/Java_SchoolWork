package demo;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws RemoteException, NamingException {
        Context context=new InitialContext();
        Registry registry= LocateRegistry.createRegistry(8721);
        ICal cal=new CalImpl();
        context.rebind("rmi://10.10.48.221:8721/calObj", cal);
        System.out.println("Ready...");
    }
}
