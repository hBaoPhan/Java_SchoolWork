package demo;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class CalImpl extends UnicastRemoteObject implements ICal {

    public CalImpl() throws RemoteException {
        super();
    }
    @Override
    public long add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public long sub(int a, int b) throws RemoteException {
        return a - b;
    }
}
