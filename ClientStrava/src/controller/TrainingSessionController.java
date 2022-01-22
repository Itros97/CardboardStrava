package controller;

import data.DTO.TrainingSessionDTO;
import ServiceLocator.ServiceLocator;

import java.rmi.RemoteException;
import java.util.GregorianCalendar;
import java.util.List;

public class TrainingSessionController {

    //Reference to the Service Locator
    private final ServiceLocator serviceLocator;

    public TrainingSessionController(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; }

    public List<TrainingSessionDTO> getTrainingSessions() {
        try {
            return this.serviceLocator.getService().getTrainingSessions();
        } catch (RemoteException e) {
            System.out.println("# Error getting all training sessions: " + e);
            return null;
        }
    }

    public List<TrainingSessionDTO> getOwnTrainingSessions(String email) {
        try {
            return this.serviceLocator.getService().getOwnTrainingSessions(email);
        } catch (RemoteException e) {
            System.out.println("# Error getting accepted training sessions: " + e);
            return null;
        }
    }

    public void createTrainingSession(String title, String sport, double distance, GregorianCalendar dateOfStart, double duration, String creatorEmail) {
        try {
            this.serviceLocator.getService().createTrainingSession(title, sport, distance, dateOfStart, duration, creatorEmail);
        } catch (RemoteException e) {
            System.out.println("# Error creating a training session: " + e);
        }
    }

}
