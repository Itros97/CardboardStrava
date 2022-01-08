package services;

import data.dao.TrainingSessionDAO;
import data.domain.TrainingSession;

public class CreateTrainingSessionsAppService {
    //Instance for Singleton Pattern
    private static CreateTrainingSessionsAppService instance;

    private CreateTrainingSessionsAppService() { }

    public static CreateTrainingSessionsAppService getInstance() {
        if (instance == null) {
            instance = new CreateTrainingSessionsAppService();
        }

        return instance;
    }

    public void createTrainingSession(TrainingSession ts) {
        if (ts != null) {
            //Save the challenge in the DB using DAO Pattern
         //   TrainingSessionDAO.getInstance().save(ts);
        }
    }
}
