package demo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICal extends Remote {
        long add(int a,int b) throws RemoteException;
        long sub(int a,int b) throws  RemoteException;



}
