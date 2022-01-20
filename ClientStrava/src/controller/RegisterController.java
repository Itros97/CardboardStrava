package controller;

import data.domain.PasswordProfile;
import data.domain.Profile;
import remote.ServiceLocator;

import java.rmi.RemoteException;

//This class implements Controller pattern.
public class RegisterController {

    //Reference to the Service Locator
    private ServiceLocator serviceLocator = new ServiceLocator();

    public RegisterController(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; }

    public void register(PasswordProfile pp) {
        try {
            this.serviceLocator.getService().registerUser(pp);
        } catch (RemoteException e) {
            System.out.println("# Error during register: " + e);
        }
    }

    //Por implementar
    /*public void register(Profile p) {
        try {
            this.serviceLocator.getService().registerUser(p);
        } catch (RemoteException e) {
            System.out.println("# Error during register: " + e);
        }
    }*/
}