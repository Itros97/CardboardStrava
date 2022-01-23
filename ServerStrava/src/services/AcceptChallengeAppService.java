package services;

import data.dao.ChallengeDAO;
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

        for (Challenge ch : chs) {
            if (name.equals(ch.getName())) {
                ChallengeDAO.getInstance().delete(ch);
                ch.setEmailAceptante(email);
                ChallengeDAO.getInstance().save(ch);
            }
        }
        for (ChallengeWithDistance chd : chds) {
            if (name.equals(chd.getName())) {
                ChallengeDAO.getInstance().delete(chd);
                chd.setEmailAceptante(email);
                ChallengeDAO.getInstance().save(chd);
            }
        }
        for (ChallengeWithTime cht : chts) {
            if (name.equals(cht.getName())) {
                ChallengeDAO.getInstance().delete(cht);
                cht.setEmailAceptante(email);
                ChallengeDAO.getInstance().save(cht);
            }
        }
    }
}