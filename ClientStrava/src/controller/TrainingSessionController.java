package controller;

import data.DTO.TrainingSessionDTO;
import ServiceLocator.ServiceLocator;
import data.domain.PasswordProfile;

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

    public void createTrainingSession(String title, String sport, double distance, GregorianCalendar dateOfStart, double duration, PasswordProfile pp) {
        try {
            this.serviceLocator.getService().createTrainingSession(title, sport, distance, dateOfStart, duration, pp);
        } catch (RemoteException e) {
            System.out.println("# Error creating a training session: " + e);
        }
    }

}
