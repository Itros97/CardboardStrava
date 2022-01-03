package controller;

import remote.ServiceLocator;
import java.rmi.RemoteException;

//This class implements Controller pattern.
public class LoginController {

    //Reference to the Service Locator
    private ServiceLocator serviceLocator;
    //This attribute stores the token when login success
    private boolean token = false;

    public LoginController() {}

    public void login(String email, String password) {
        //Se realiza el proceso de login si un usuario no se ha logeado ya
        if (!token) {
            try {
                token = this.serviceLocator.getService().loginUser(email, password);
            } catch (RemoteException e) {
                System.out.println("# Error during login: " + e);
            }
        }
    }

    public void logout() {
        token = false;
    }

    public boolean getToken() {
        return token;
    }
}