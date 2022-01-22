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
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {
    private static final long serialVersionUID = 1L;

    public static RemoteFacade instance;

    public RemoteFacade() throws RemoteException {
        super();
    }

    //Hay que implementar aqui y en otras partes de la facade el token
    public boolean loginUser(String email, String password) throws RemoteException {
        System.out.println(" * RemoteFacade loginUser: " + email + " / " + password);
        LoginAppService loginS = new LoginAppService();
        boolean token;
        token = loginS.login(email, password);
        return token;
    }

    public void registerUser(PasswordProfile pp) throws RemoteException {
        System.out.println(" * RemoteFacade registerUser: " + pp.getRegisterType() + " / " + pp.getEmail() + " / " + pp.getPassword());
        RegisterAppService registerS = new RegisterAppService();
        registerS.register(pp);
    }

    public boolean logout(boolean token) throws RemoteException {
        System.out.println(" * RemoteFacade logout: " + token);

        if (token) {
            token = false;
            return token;
        } else {
            System.out.println("Not logged in!");
            return false;
        }
    }

    public void acceptChallenge(String name, String email) throws RemoteException {
        System.out.println(" * RemoteFacade acceptChallenge: " + name);
        AcceptChallengeAppService.getInstance().accept(name, email);
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

    public List<TrainingSessionDTO> getOwnTrainingSessions(String email) throws RemoteException {
        System.out.println(" * RemoteFacade getAcceptedTrainingSessions: ");

        //Get TrainingSessions using GetTrainingSessionsAppService
        List<TrainingSession> ts = GetTrainingSessionsAppService.getInstance().getTrainingSessions();

        for (TrainingSession t : ts) {
            if (!t.getCreatorEmail().equals(email)) {
                ts.remove(t);
            }
        }

        if (!ts.isEmpty()) {
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

    public List<ChallengeDTO> getAcceptedChallenges(String email) throws RemoteException {
        System.out.println(" * RemoteFacade getAcceptedChallenges: ");

        //Get Challenges using GetTrainingSessionsAppService
        List<Challenge> ch = GetChallengesAppService.getInstance().getChallenges();

        for (Challenge c : ch) {
            if (!c.getEmailAceptante().equals(email)) {
                ch.remove(c);
            }
        }

        if (!ch.isEmpty()) {
            //Convert domain object to DTO
            return ChallengeAssembler.getInstance().challengeToDTO(ch);
        } else {
            throw new RemoteException("getAcceptedChallenges() fails!");
        }
    }

    public void createTrainingSession(String title, String sport, double distance, GregorianCalendar dateOfStart, double duration, String creatorEmail) throws RemoteException {
        TrainingSession ts = new TrainingSession();
        ts.setTitle(title);
        ts.setSport(sport);
        ts.setDistance(distance);
        ts.setDateOfStart(dateOfStart);
        ts.setDuration(duration);
        ts.setCreatorEmail(creatorEmail);

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
