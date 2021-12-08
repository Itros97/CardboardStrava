package remote;

import data.DTO.ChallengeDTO;
import data.DTO.TrainingSessionDTO;
import data.domain.Profile;
import data.domain.TrainingSession;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.GregorianCalendar;
import java.util.List;

public interface IRemoteFacade extends Remote {
    Profile loginUser(String email, String password) throws RemoteException;

    boolean registerUser(String GoogleOrFacebook, String email, String password) throws RemoteException;

    List<TrainingSessionDTO> getTrainingSessions() throws RemoteException;

    List<ChallengeDTO> getChallenges() throws RemoteException;

    void createTrainingSession(TrainingSession ts) throws RemoteException;

    void createChallenge(String typeOfChallenge, String name, GregorianCalendar dateOfStart, GregorianCalendar dateOfEnd, String sport, double objectiveDistance, int objectiveTime) throws RemoteException;
}