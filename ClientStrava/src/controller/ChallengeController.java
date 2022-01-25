package controller;

import ServiceLocator.ServiceLocator;
import data.DTO.GreatChallengeDTO;

import java.rmi.RemoteException;
import java.util.GregorianCalendar;
import java.util.List;

public class ChallengeController {

    //Reference to the Service Locator
    private ServiceLocator serviceLocator = new ServiceLocator();

    public ChallengeController(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; }

    public void acceptChallenge(String name, String email) {
        try {
            this.serviceLocator.getService().acceptChallenge(name, email);
            System.out.println("Accepted");
        } catch (RemoteException e) {
            System.out.println("# Error accepting challenge: " + e);
        }
    }

    public List<GreatChallengeDTO> getChallenges() {
        try {
            return this.serviceLocator.getService().getChallenges();
        } catch (RemoteException e) {
            System.out.println("# Error getting all challenges: " + e);
            return null;
        }
    }

    public List<GreatChallengeDTO> getUnfinishedChallenges() {
        try {
            return this.serviceLocator.getService().getUnfinishedChallenges();
        } catch (RemoteException e) {
            System.out.println("# Error getting unfinished challenges: " + e);
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