package remote;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;
import java.util.Date;
import java.util.List;
import data.DTO.*;
import data.domain.*;
import services.*;

public class RemoteFaçade {
    private static final long serialVersionUID = 1L;
    private static RemoteFacade instance;
    public Profile state;

    private RemoteFacade() throws RemoteException {
    }

    public Profile RemoteFacade {
    getInstance() {
        if (instance == null) {
            try {
                instance = new RemoteFacade();
            } catch (Exception var1) {
                System.err.println("# Error creating RemoteFacade: " + var1);
            }
        }
        return instance;
    }

    public Profile loginUser(String email, String password) {
        System.out.println(" * RemoteFacade loginUser: " + email + " / " + password);
        return LoginAppService.getInstace().login(email, password);
    }

    public boolean registerUser(String GoogleOrFacebook, String email, String password) {
        System.out.println(" * RemoteFacade registerUser: " + GoogleOrFacebook + " / " + email + " / " + password);
        return RegisterAppService.getInstace().register(GoogleOrFacebook, email, password);
    }

    public List<TrainingSessionDTO> getTrainingSessions() {
        System.out.println(" * RemoteFacade getTrainingSessions: ");
        return GetTrainingSessionsAppService.getInstance().getTrainingSessions();
    }

    public List<ChallengeDTO> getChallenges() {
        System.out.println(" * RemoteFacade getChallenges: ");
        return GetChallengesAppService.getInstance().getChallenges();
    }

    public void createTrainingSession(TrainingSession ts) {
        System.out.println(" * RemoteFacade createTrainingSession: " + ts);
        return CreateTrainingSessionsAppService.getInstance().createTrainingSession(ts);
    }

    public void createChallenge(Challenge ch) {
        System.out.println(" * RemoteFacade createChallenge: " + ch);
        return CreateChallengeAppService.getInstance().createChallenge(ch);
    }
}