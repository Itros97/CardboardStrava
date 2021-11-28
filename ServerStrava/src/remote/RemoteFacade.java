package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import data.DTO.*;
import data.domain.*;
import services.*;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {
    private static final long serialVersionUID = 1L;

    //Attribute for the Singleton pattern
    private static RemoteFacade instance;

    private RemoteFacade() throws RemoteException {
        super();
    }

    public static RemoteFacade getInstance() {
        if (instance == null) {
            try {
                instance = new RemoteFacade();
            } catch (Exception var1) {
                System.err.println("# Error creating RemoteFacade: " + var1);
            }
        }
        return instance;
    }

    public Profile loginUser(String email, String password) throws RemoteException {
        System.out.println(" * RemoteFacade loginUser: " + email + " / " + password);
        LoginAppService loginS = new LoginAppService();
        return loginS.login(email, password);
    }

    public boolean registerUser(String GoogleOrFacebook, String email, String password) throws RemoteException {
        System.out.println(" * RemoteFacade registerUser: " + GoogleOrFacebook + " / " + email + " / " + password);
        RegisterAppService registerS = new RegisterAppService();
        return registerS.register(GoogleOrFacebook, email, password);
    }

    public List<TrainingSessionDTO> getTrainingSessions() throws RemoteException {
        System.out.println(" * RemoteFacade getTrainingSessions: ");

        //Get TrainingSessions using GetTrainingSessionsAppService
        List<TrainingSession> ts = GetTrainingSessionsAppService.getInstance().getTrainingSessions();

        if (ts != null) {
            //Convert domain object to DTO
            return TraininigSessionAssembler.getInstance().trainingSessionToDTO(ts);
        } else {
            throw new RemoteException("getTrainingSessions() fails!");
        }
    }

    public List<ChallengeDTO> getChallenges() throws RemoteException {
        System.out.println(" * RemoteFacade getChallenges: ");

        //Get TrainingSessions using GetTrainingSessionsAppService
        List<Challenge> ch = GetChallengesAppService.getInstance().getChallenges();

        if (ch != null) {
            //Convert domain object to DTO
            return ChallengeAssembler.getInstance().challengeToDTO(ch);
        } else {
            throw new RemoteException("getChallenges() fails!");
        }
    }

    public void createTrainingSession(TrainingSession ts) throws RemoteException {
        System.out.println(" * RemoteFacade createTrainingSession: " + ts);
        CreateTrainingSessionsAppService.getInstance().createTrainingSession(ts);
    }

    public void createChallenge(Challenge ch) throws RemoteException {
        System.out.println(" * RemoteFacade createChallenge: " + ch);
        CreateChallengeAppService.getInstance().createChallenge(ch);
    }
}