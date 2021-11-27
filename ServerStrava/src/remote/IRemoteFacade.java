package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import data.DTO.*;
import data.domain.*;

public interface IRemoteFacade extends Remote {
    Profile loginUser(String email, String password) throws RemoteException;

    Profile registerUser(String GoogleOrFacebook, String email, String password) throws RemoteException;

    List<TrainingSessionDTO> getTrainingSessions() throws RemoteException;

    List<ChallengeDTO> getChallenges() throws RemoteException;

    void createTrainingSession(TrainingSession ts) throws RemoteException;

    void createChallenge(Challenge ch) throws RemoteException;
}