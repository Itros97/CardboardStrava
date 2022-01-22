package services;

import data.dao.ChallengeDAO;
import data.domain.Challenge;

public class CreateChallengeAppService {
    //Instance for Singleton Pattern
    private static CreateChallengeAppService instance;

    private CreateChallengeAppService() { }

    public static CreateChallengeAppService getInstance() {
        if (instance == null) {
            instance = new CreateChallengeAppService();
        }

        return instance;
    }

    public void createChallenge(Challenge ch) {
            //Save the challenge in the DB using DAO Pattern
            ChallengeDAO.getInstance().save(ch);
    }
}
