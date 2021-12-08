package remote;

import data.DTO.*;
import data.domain.*;
import services.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.GregorianCalendar;
import java.util.List;

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

    public void createChallenge(String typeOfChallenge, String name, GregorianCalendar dateOfStart, GregorianCalendar dateOfEnd, String sport, double objectiveDistance, int objectiveTime) throws RemoteException {
        ChallengeWithDistance chd = new ChallengeWithDistance();
        ChallengeWithTime cht = new ChallengeWithTime();
        Challenge ch = new Challenge();

        if (typeOfChallenge.equals("distance")) {
            chd.setName(name);
            chd.setDateOfStart(dateOfStart);
            chd.setDateOfEnd(dateOfEnd);
            chd.setSport(sport);
            chd.setObjectiveDistance(objectiveDistance);
            System.out.println(" * RemoteFacade createChallengeWithDistance: " + chd);
            CreateChallengeWithDistanceAppService.getInstance().createChallengeWithDistance(chd);
        } else if (typeOfChallenge.equals("time")) {
            cht.setName(name);
            cht.setDateOfStart(dateOfStart);
            cht.setDateOfEnd(dateOfEnd);
            cht.setSport(sport);
            cht.setObjectiveTime(objectiveTime);
            System.out.println(" * RemoteFacade createChallengeWithTime: " + cht);
            CreateChallengeWithTimeAppService.getInstance().createChallengeWithTime(cht);
        } else {
            ch.setName(name);
            ch.setDateOfStart(dateOfStart);
            ch.setDateOfEnd(dateOfEnd);
            ch.setSport(sport);
            System.out.println(" * RemoteFacade createChallenge: " + ch);
            CreateChallengeAppService.getInstance().createChallenge(ch);
        }
    }
}
