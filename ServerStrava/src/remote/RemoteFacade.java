package remote;

import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import data.DTO.*;
import data.domain.*;
import services.*;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {
    @Serial
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
<<<<<<< Updated upstream
        return LoginAppService.getInstace().login(email, password);
=======
        return LoginAppService.getInstance().login(email, password);
>>>>>>> Stashed changes
    }

    public Profile registerUser(String GoogleOrFacebook, String email, String password) throws RemoteException {
        System.out.println(" * RemoteFacade registerUser: " + GoogleOrFacebook + " / " + email + " / " + password);
<<<<<<< Updated upstream
        return RegisterAppService.getInstace().register(GoogleOrFacebook, email, password);
=======
        return RegisterAppService.getInstance().register(GoogleOrFacebook, email, password);
>>>>>>> Stashed changes
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