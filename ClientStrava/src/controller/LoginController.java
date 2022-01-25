package controller;

import ServiceLocator.ServiceLocator;
import data.domain.PasswordProfile;

import java.rmi.RemoteException;

//This class implements Controller pattern.
public class LoginController {

    //Reference to the Service Locator
    private ServiceLocator serviceLocator = new ServiceLocator();
    //This attribute stores the token when login success
    private boolean token = false;
    private PasswordProfile pp = new PasswordProfile();

    public LoginController(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; pp.setEmail("");}

    public boolean login(String email, String password) {
        try {
            pp = this.serviceLocator.getService().loginUser(email, password);
            token = true;
            return token;
        } catch (RemoteException e) {
            System.out.println("# Error during login: " + e);
        }
        return false;
    }

    public boolean logout() {
        if (!pp.getEmail().equals("")) {
            token = false;
            pp = new PasswordProfile();
            System.out.println("You logged out successfully from STRAVA Server");
            return token;
        } else {
            System.out.println("You are not even logged in!");
            //Aunque se devuelve true, se da error a un intento de logout sin haber iniciado sesion
            return true;
        }
    }

    public boolean getToken() {
        return token;
    }

    public PasswordProfile getProfile() {
        return pp;
    }
}