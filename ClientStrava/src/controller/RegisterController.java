package controller;

import remote.ServiceLocator;

import java.rmi.RemoteException;

//This class implements Controller pattern.
public class RegisterController {

    //Reference to the Service Locator
    private ServiceLocator serviceLocator;

    public RegisterController(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public boolean register(String googleOrFacebook, String email, String password) {
        try {
            this.serviceLocator.getService().registerUser(googleOrFacebook, email, password);
            return true;
        } catch (RemoteException e) {
            System.out.println("# Error during register: " + e);
            return false;
        }
    }
}