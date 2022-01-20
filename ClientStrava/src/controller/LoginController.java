package controller;

import remote.ServiceLocator;
import java.rmi.RemoteException;

//This class implements Controller pattern.
public class LoginController {

    //Reference to the Service Locator
    private ServiceLocator serviceLocator = new ServiceLocator();
    //This attribute stores the token when login success
    private boolean token = false;

    public LoginController(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; }

    public boolean login(String email, String password) {
        //Se realiza el proceso de login si un usuario no se ha logeado ya
        if (!token) {
            try {
                token = this.serviceLocator.getService().loginUser(email, password);
                return true;
            } catch (RemoteException e) {
                System.out.println("# Error during login: " + e);
            }
        }
        return false;
    }

    public boolean logout() {
        token = false; return false;
    }

    public boolean getToken() {
        return token;
    }
}