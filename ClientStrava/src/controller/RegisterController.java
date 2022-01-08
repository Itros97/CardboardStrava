package controller;

import data.domain.PasswordProfile;
import remote.ServiceLocator;

import java.rmi.RemoteException;

//This class implements Controller pattern.
public class RegisterController {

    //Reference to the Service Locator
    private ServiceLocator serviceLocator = new ServiceLocator();

    public RegisterController() {}

    public void register(PasswordProfile pp) {
        try {
            this.serviceLocator.getService().registerUser(pp);
        } catch (RemoteException e) {
            System.out.println("# Error during register: " + e);
        }
    }
}