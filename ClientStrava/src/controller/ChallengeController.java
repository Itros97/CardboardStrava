package controller;

import data.DTO.ChallengeDTO;
import remote.ServiceLocator;

import java.rmi.RemoteException;
import java.util.GregorianCalendar;
import java.util.List;

public class ChallengeController {

    //Reference to the Service Locator
    private ServiceLocator serviceLocator = new ServiceLocator();

    public ChallengeController() {}

    public void acceptChallenge(String name) {
        try {
            this.serviceLocator.getService().acceptChallenge(name);
        } catch (RemoteException e) {
            System.out.println("# Error accepting challenge: " + e);
        }
    }

    public List<ChallengeDTO> getChallenges() {
        try {
            return this.serviceLocator.getService().getChallenges();
        } catch (RemoteException e) {
            System.out.println("# Error getting all challenges: " + e);
            return null;
        }
    }

    public List<ChallengeDTO> getUnfinishedChallenges() {
        try {
            return this.serviceLocator.getService().getUnfinishedChallenges();
        } catch (RemoteException e) {
            System.out.println("# Error getting unfinished challenges: " + e);
            return null;
        }
    }

    public List<ChallengeDTO> getAcceptedChallenges() {
        try {
            return this.serviceLocator.getService().getAcceptedChallenges();
        } catch (RemoteException e) {
            System.out.println("# Error getting accepted challenges: " + e);
            return null;
        }
    }

    public void createChallenge(String typeOfChallenge, String name, GregorianCalendar dateOfStart, GregorianCalendar dateOfEnd, String sport, double objectiveDistance, int objectiveTime) {
        try {
            if (typeOfChallenge.equals("distance")) {
                this.serviceLocator.getService().createChallenge(typeOfChallenge, name, dateOfStart, dateOfEnd, sport, objectiveDistance, objectiveTime);
            } else if (typeOfChallenge.equals("time")) {
                this.serviceLocator.getService().createChallenge(typeOfChallenge, name, dateOfStart, dateOfEnd, sport, objectiveDistance, objectiveTime);
            } else {
                this.serviceLocator.getService().createChallenge(typeOfChallenge, name, dateOfStart, dateOfEnd, sport, objectiveDistance, objectiveTime);
            }
        } catch (RemoteException e) {
            System.out.println("# Error creating a challenge: " + e);
        }
    }

}