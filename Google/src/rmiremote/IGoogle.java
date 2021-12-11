package rmiremote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGoogle extends Remote {
    public boolean login(String username, String password) throws RemoteException;
    public void register(String username) throws RemoteException;
}
