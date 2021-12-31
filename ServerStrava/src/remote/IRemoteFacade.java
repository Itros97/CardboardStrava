package remote;

import data.DTO.ChallengeDTO;
import data.DTO.TrainingSessionDTO;
import data.domain.PasswordProfile;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.GregorianCalendar;
import java.util.List;

public interface IRemoteFacade extends Remote {
    boolean loginUser(String googleOrFacebook, String email, String password) throws RemoteException;

    void registerUser(PasswordProfile pp) throws RemoteException;

    boolean logout(boolean token) throws RemoteException;

    void acceptTrainingSession(String title) throws RemoteException;

    void acceptChallenge(String name) throws RemoteException;

    List<TrainingSessionDTO> getTrainingSessions() throws RemoteException;

    List<TrainingSessionDTO> getAcceptedTrainingSessions() throws RemoteException;

    List<ChallengeDTO> getChallenges() throws RemoteException;

    List<ChallengeDTO> getUnfinishedChallenges() throws RemoteException;

    List<ChallengeDTO> getAcceptedChallenges() throws RemoteException;

    void createTrainingSession(String title, String sport, double distance, GregorianCalendar dateOfStart, GregorianCalendar hourOfStart, double duration) throws RemoteException;

    void createChallenge(String typeOfChallenge, String name, GregorianCalendar dateOfStart, GregorianCalendar dateOfEnd, String sport, double objectiveDistance, int objectiveTime) throws RemoteException;
}