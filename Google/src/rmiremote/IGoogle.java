package rmiremote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGoogle extends Remote {
    boolean login(String email, String password) throws RemoteException;
    /*public void register(String email, String nickname, GregorianCalendar birthdate,
                         double weightKg, int heightCm, int maximumHeartRate,
                         int reposeHeartRate, String googleOrFacebook) throws RemoteException;
    */}
