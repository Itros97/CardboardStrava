package controller;

import data.DTO.TrainingSessionDTO;
import remote.ServiceLocator;

import java.rmi.RemoteException;
import java.util.GregorianCalendar;
import java.util.List;

public class TrainingSessionController {

    //Reference to the Service Locator
    private ServiceLocator serviceLocator = new ServiceLocator();

    public TrainingSessionController() {}

    public void acceptTrainingSession(String title) {
        try {
            this.serviceLocator.getService().acceptTrainingSession(title);
        } catch (RemoteException e) {
            System.out.println("# Error accepting training session: " + e);
        }
    }

    public List<TrainingSessionDTO> getTrainingSessions() {
        try {
            return this.serviceLocator.getService().getTrainingSessions();
        } catch (RemoteException e) {
            System.out.println("# Error getting all training sessions: " + e);
            return null;
        }
    }

    public List<TrainingSessionDTO> getAcceptedTrainingSessions() {
        try {
            return this.serviceLocator.getService().getAcceptedTrainingSessions();
        } catch (RemoteException e) {
            System.out.println("# Error getting accepted training sessions: " + e);
            return null;
        }
    }

    public void createTrainingSession(String title, String sport, double distance, GregorianCalendar dateOfStart, double duration) {
        try {
            this.serviceLocator.getService().createTrainingSession(title, sport, distance, dateOfStart, duration);
        } catch (RemoteException e) {
            System.out.println("# Error creating a training session: " + e);
        }
    }

}
