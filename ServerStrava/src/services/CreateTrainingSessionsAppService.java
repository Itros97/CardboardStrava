package services;

import java.rmi.RemoteException;
import data.DTO.TrainingSessionDTO;
import data.domain.*;
import data.dao.*;
import gateway.*;

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
            TrainingSessionDAO.getInstance().save(ts);
        }
    }
}
