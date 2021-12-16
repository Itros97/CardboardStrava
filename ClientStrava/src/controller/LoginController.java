package controller;

import remote.ServiceLocator;
import java.rmi.RemoteException;

//This class implements Controller pattern.
public class LoginController {

    //Reference to the Service Locator
    private ServiceLocator serviceLocator;
    //This attribute stores the token when login success
    private long token = -1; //-1 = login has not been done or fails

    public LoginController(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public boolean login(String googleOrFacebook, String email, String password) {
        try {
            this.serviceLocator.getService().loginUser(googleOrFacebook, email, password);
            this.token = 1;
            return true;
        } catch (RemoteException e) {
            System.out.println("# Error during login: " + e);
            this.token = -1;
            return false;
        }
    }

    public void logout() {
        try {
            this.token = -1;
            this.serviceLocator.getService().logout(token);
        } catch (RemoteException e) {
            System.out.println("# Error during logout: " + e);
        }
    }

    public long getToken() {
        return token;
    }
}