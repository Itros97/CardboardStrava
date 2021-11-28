package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFacebook extends Remote {
    public void login() throws RemoteException;
    public void register() throws RemoteException;
}