package remote;

import data.DTO.ChallengeAssembler;
import data.DTO.ChallengeDTO;
import data.DTO.TrainingSessionDTO;
import data.DTO.TraininigSessionAssembler;
import data.domain.*;
import services.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
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

    public void acceptTrainingSession(String title) throws RemoteException {
        System.out.println(" * RemoteFacade acceptTrainingSession: " + title);
        AcceptTrainingSessionAppService.getInstance().accept(title);
    }

    public void acceptChallenge(String name) throws RemoteException {
        System.out.println(" * RemoteFacade acceptChallenge: " + name);
        AcceptChallengeAppService.getInstance().accept(name);
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

    public List<TrainingSessionDTO> getAcceptedTrainingSessions() throws RemoteException {
        System.out.println(" * RemoteFacade getAcceptedTrainingSessions: ");

        //Get TrainingSessions using GetTrainingSessionsAppService
        List<TrainingSession> ts = GetTrainingSessionsAppService.getInstance().getTrainingSessions();

        ts.removeIf(t -> !t.isAccepted());

        if (ts != null) {
            //Convert domain object to DTO
            return TraininigSessionAssembler.getInstance().trainingSessionToDTO(ts);
        } else {
            throw new RemoteException("getAcceptedTrainingSessions() fails!");
        }
    }

    public List<ChallengeDTO> getChallenges() throws RemoteException {
        System.out.println(" * RemoteFacade getChallenges: ");

        List<Challenge> ch = GetChallengesAppService.getInstance().getChallenges();

        if (ch != null) {
            //Convert domain object to DTO
            return ChallengeAssembler.getInstance().challengeToDTO(ch);
        } else {
            throw new RemoteException("getChallenges() fails!");
        }
    }

    public List<ChallengeDTO> getUnfinishedChallenges() throws RemoteException {
        System.out.println(" * RemoteFacade getUnfinishedChallenges: ");

        List<Challenge> chs = GetChallengesAppService.getInstance().getChallenges();

        LocalDate todaysDate = LocalDate.now();
        if (chs != null) {
            chs.removeIf(ch -> ch.getDateOfEnd().after(todaysDate));

            //Convert domain object to DTO
            return ChallengeAssembler.getInstance().challengeToDTO(chs);
        } else {
            throw new RemoteException("getUnfinishedChallenges() fails!");
        }
    }

    public List<ChallengeDTO> getAcceptedChallenges() throws RemoteException {
        System.out.println(" * RemoteFacade getChallenges: ");

        List<Challenge> ch = GetChallengesAppService.getInstance().getChallenges();

        ch.removeIf(c -> !c.isAccepted());

        if (ch != null) {
            //Convert domain object to DTO
            return ChallengeAssembler.getInstance().challengeToDTO(ch);
        } else {
            throw new RemoteException("getChallenges() fails!");
        }
    }

    public void createTrainingSession(String title, String sport, double distance, GregorianCalendar dateOfStart, GregorianCalendar hourOfStart, double duration) throws RemoteException {
        TrainingSession ts = new TrainingSession();
        ts.setTitle(title);
        ts.setSport(sport);
        ts.setDistance(distance);
        ts.setDateOfStart(dateOfStart);
        ts.setHourOfStart(hourOfStart);
        ts.setDuration(duration);

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
