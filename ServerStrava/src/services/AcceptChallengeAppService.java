package services;

import data.dao.ChallengeDAO;
import data.dao.ChallengeWithDistanceDAO;
import data.dao.ChallengeWithTimeDAO;
import data.domain.Challenge;
import data.domain.ChallengeWithDistance;
import data.domain.ChallengeWithTime;

import java.util.ArrayList;
import java.util.List;

public class AcceptChallengeAppService {
    //Instance for Singleton Pattern
    private static AcceptChallengeAppService instance;

    private AcceptChallengeAppService() { }

    public static AcceptChallengeAppService getInstance() {
        if (instance == null) {
            instance = new AcceptChallengeAppService();
        }

        return instance;
    }

    public void accept (String name, String email) {
        List<Challenge> chs = new ArrayList<Challenge>();
        chs = GetChallengesAppService.getInstance().getChallenges();
        List<ChallengeWithDistance> chds = new ArrayList<ChallengeWithDistance>();
        chds = GetChallengesAppService.getInstance().getChallengesWithDistance();
        List<ChallengeWithTime> chts = new ArrayList<ChallengeWithTime>();
        chts = GetChallengesAppService.getInstance().getChallengesWithTime();

        System.out.println("Guardar");

        for (Challenge ch : chs) {
            if (name.equals(ch.getName())) {
                ch.setEmailAceptante(email);
                ChallengeDAO.getInstance().save(ch);
                System.out.println("Guardar Challenge normal");
            }
        }
        for (ChallengeWithDistance chd : chds) {
            if (name.equals(chd.getName())) {
                chd.setEmailAceptante(email);
                ChallengeWithDistanceDAO.getInstance().save(chd);
                System.out.println("Guardar Distance");
            }
        }
        for (ChallengeWithTime cht : chts) {
            if (name.equals(cht.getName())) {
                cht.setEmailAceptante(email);
                ChallengeWithTimeDAO.getInstance().save(cht);
                System.out.println("Guardar Time");
            }
        }
    }
}