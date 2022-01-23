package remote;

import data.DTO.GreatChallengeAssembler;
import data.DTO.GreatChallengeDTO;
import data.DTO.TrainingSessionDTO;
import data.DTO.TraininigSessionAssembler;
import data.domain.*;
import services.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

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
        if (!pp.getRegisterType().equals("")) {
            System.out.println(" * RemoteFacade registerUser: " + pp.getRegisterType() + " / " + pp.getEmail() + " / " + pp.getPassword());
        } else {
            System.out.println(" * RemoteFacade registerUser: Default Register Type / " + pp.getEmail() + " / " + pp.getPassword());
        }
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

    public List<GreatChallengeDTO> getChallenges() throws RemoteException {
        System.out.println(" * RemoteFacade getChallenges: ");

        List<Challenge> chs = GetChallengesAppService.getInstance().getChallenges();
        List<ChallengeWithDistance> chds = GetChallengesAppService.getInstance().getChallengesWithDistance();
        List<ChallengeWithTime> chts = GetChallengesAppService.getInstance().getChallengesWithTime();

        //Hacer algo con la condicion de este if
        if (chs != null) {
            //Convert domain object to DTO
            return GreatChallengeAssembler.getInstance().challengeToDTO(chs, chds, chts);
        } else {
            throw new RemoteException("getChallenges() fails!");
        }
    }

    public List<GreatChallengeDTO> getUnfinishedChallenges() throws RemoteException {
        System.out.println(" * RemoteFacade getUnfinishedChallenges: ");

        List<Challenge> chs = GetChallengesAppService.getInstance().getChallenges();
        List<ChallengeWithDistance> chds = GetChallengesAppService.getInstance().getChallengesWithDistance();
        List<ChallengeWithTime> chts = GetChallengesAppService.getInstance().getChallengesWithTime();

        LocalDate todaysDate = LocalDate.now();
        //Hacer algo con la condicion de este if
        if (chs != null) {
            for (Challenge c : chs) {
                if (c.getDateOfEnd().after(todaysDate)) {
                    chs.remove(c);
                }
            }

            for (ChallengeWithDistance cd : chds) {
                if (cd.getDateOfEnd().after(todaysDate)) {
                    chds.remove(cd);
                }
            }

            for (ChallengeWithTime ct : chts) {
                if (ct.getDateOfEnd().after(todaysDate)) {
                    chts.remove(ct);
                }
            }

            //Convert domain object to DTO
            return GreatChallengeAssembler.getInstance().challengeToDTO(chs, chds, chts);
        } else {
            throw new RemoteException("getUnfinishedChallenges() fails!");
        }
    }

    public List<GreatChallengeDTO> getAcceptedChallenges(String email) throws RemoteException {
        System.out.println(" * RemoteFacade getAcceptedChallenges: ");

        //Get Challenges using GetTrainingSessionsAppService
        List<Challenge> chs = GetChallengesAppService.getInstance().getChallenges();
        List<ChallengeWithDistance> chds = GetChallengesAppService.getInstance().getChallengesWithDistance();
        List<ChallengeWithTime> chts = GetChallengesAppService.getInstance().getChallengesWithTime();

        List<Challenge> listChallenges = new ArrayList<Challenge>();
        List<ChallengeWithDistance> listChallengesWithDistance = new ArrayList<ChallengeWithDistance>();
        List<ChallengeWithTime> listChallengesWithTime = new ArrayList<ChallengeWithTime>();

        //Estos for para filtrar tan aparatosos son asi para evitar una excepcion
        for (Challenge c : chs) {
            if (!c.getEmailAceptante().equals(email)) {
                listChallenges.add(c);
            }
        }

        for (Challenge c2 : listChallenges) {
            chs.remove(c2);
        }

        for (ChallengeWithDistance cd : chds) {
            if (!cd.getEmailAceptante().equals(email)) {
                listChallengesWithDistance.add(cd);
            }
        }

        for (ChallengeWithDistance cd2 : listChallengesWithDistance) {
            chs.remove(cd2);
        }

        for (ChallengeWithTime ct : chts) {
            if (!ct.getEmailAceptante().equals(email)) {
                listChallengesWithTime.add(ct);
            }
        }

        for (ChallengeWithTime ct2 : listChallengesWithTime) {
            chts.remove(ct2);
        }

        //Hacer algo con la condicion de este if
        if (!chs.isEmpty()) {
            //Convert domain object to DTO
            return GreatChallengeAssembler.getInstance().challengeToDTO(chs, chds, chts);
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
