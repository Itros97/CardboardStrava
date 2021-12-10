package rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGoogle extends Remote {
    void login() throws RemoteException;
    void register() throws RemoteException;
}
