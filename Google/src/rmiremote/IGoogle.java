package rmiremote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.GregorianCalendar;

public interface IGoogle extends Remote {
    public boolean login(String email, String password) throws RemoteException;
    public void register(String email, String nickname, GregorianCalendar birthdate,
                         double weightKg, int heightCm, int maximumHeartRate,
                         int reposeHeartRate) throws RemoteException;
}
