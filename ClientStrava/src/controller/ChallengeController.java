package controller;

import remote.ServiceLocator;
import java.rmi.RemoteException;
import java.util.GregorianCalendar;
import java.util.List;
import data.DTO.*;

public class ChallengeController {

    //Reference to the Service Locator
    private ServiceLocator serviceLocator;

    public ChallengeController(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public getActiveChallenges() {

    }

    public consultInformation() {

    }

    public acceptChallenge() {

    }

    public consultAcceptedChallenges() {

    }

    public recoverUnfinishedChallenges() {

    }

    public getChallenges() {

    }

    public void createChallenge(String typeOfChallenge, String name, GregorianCalendar dateOfStart, GregorianCalendar dateOfEnd, String sport, double objectiveDistance, int objectiveTime) {
        String texto = "";
        if (typeOfChallenge != null) {
            texto = typeOfChallenge;
        }

        try {
            if (typeOfChallenge.equals("distance")) {
                this.serviceLocator.getService().createChallenge(texto, name, dateOfStart, dateOfEnd, sport, objectiveDistance, objectiveTime);
            } else if (typeOfChallenge.equals("time")) {
                this.serviceLocator.getService().createChallenge(texto, name, dateOfStart, dateOfEnd, sport, objectiveDistance, objectiveTime);
            } else {
                this.serviceLocator.getService().createChallenge(texto, name, dateOfStart, dateOfEnd, sport, objectiveDistance, objectiveTime);
            }
        } catch (RemoteException e) {
            System.out.println("# Error creating a challenge: " + e);
        }
    }

    public getServiceLocator() {

    }


}