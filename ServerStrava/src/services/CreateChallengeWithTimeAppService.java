package services;

import data.dao.ChallengeWithTimeDAO;
import data.domain.ChallengeWithTime;

public class CreateChallengeWithTimeAppService {
    //Instance for Singleton Pattern
    private static CreateChallengeWithTimeAppService instance;

    private CreateChallengeWithTimeAppService() { }

    public static CreateChallengeWithTimeAppService getInstance() {
        if (instance == null) {
            instance = new CreateChallengeWithTimeAppService();
        }

        return instance;
    }

    public void createChallengeWithTime(ChallengeWithTime ch) {
        if (ch != null) {
            //Save the challenge in the DB using DAO Pattern
            ChallengeWithTimeDAO.getInstance().save(ch);
        }
    }
}