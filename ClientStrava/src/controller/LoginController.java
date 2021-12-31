package controller;

import remote.ServiceLocator;
import java.rmi.RemoteException;

//This class implements Controller pattern.
public class LoginController {

    //Reference to the Service Locator
    private ServiceLocator serviceLocator;
    //This attribute stores the token when login success
    private boolean token = false;

    public LoginController(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public boolean login(String googleOrFacebook, String email, String password) {
        try {
            token = this.serviceLocator.getService().loginUser(googleOrFacebook, email, password);
            return token;
        } catch (RemoteException e) {
            System.out.println("# Error during login: " + e);
            return false;
        }
    }

    public boolean logout() {
        try {
            token = this.serviceLocator.getService().logout(token);
            return token;
        } catch (RemoteException e) {
            System.out.println("# Error during logout: " + e);
            return false;
        }
    }

    public boolean getToken() {
        return token;
    }
}