package services;

import data.dao.ChallengeWithDistanceDAO;
import data.domain.ChallengeWithDistance;

public class CreateChallengeWithDistanceAppService {
    //Instance for Singleton Pattern
    private static CreateChallengeWithDistanceAppService instance;

    private CreateChallengeWithDistanceAppService() { }

    public static CreateChallengeWithDistanceAppService getInstance() {
        if (instance == null) {
            instance = new CreateChallengeWithDistanceAppService();
        }

        return instance;
    }

    public void createChallengeWithDistance(ChallengeWithDistance ch) {
            //Save the challenge in the DB using DAO Pattern
            ChallengeWithDistanceDAO.getInstance().save(ch);
    }
}