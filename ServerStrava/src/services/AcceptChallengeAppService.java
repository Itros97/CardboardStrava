package services;

import data.dao.ChallengeDAO;
import data.domain.Challenge;

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

    public void accept (String name) {
        List<Challenge> chs = new ArrayList<Challenge>();
        chs = GetChallengesAppService.getInstance().getChallenges();

        for (Challenge ch : chs) {
            if (name.equals(ch.getName())) {
                ch.setAccepted(true);
                Challenge cha = new Challenge();
                cha = ch;
                chs.remove(ch);
                ChallengeDAO.getInstance().save(ch);
            }
        }
    }
}
