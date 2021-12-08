package controller;

import remote.ServiceLocator;
import java.rmi.RemoteException;

//This class implements Controller pattern.
public class LoginController {

    //Reference to the Service Locator
    private ServiceLocator serviceLocator;

    public LoginController(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public boolean login(String email, String password) {
        try {
            this.serviceLocator.getService().loginUser(email, password);
            return true;
        } catch (RemoteException e) {
            System.out.println("# Error during login: " + e);
            return false;
        }
    }

    //Sin usar
    /*public void logout() {
        try {
            this.serviceLocator.getService().logout(this.token);
            this.token = -1;
        } catch (RemoteException e) {
            System.out.println("# Error during logout: " + e);
        }
    }*/
}