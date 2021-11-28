package services;

import java.rmi.RemoteException;
import java.util.List;
import data.DTO.*;
import data.domain.*;
import data.dao.*;
import gateway.*;

public class GetTrainingSessionsAppService {
    //Instance for Singleton Pattern
    private static GetTrainingSessionsAppService instance;

    private GetTrainingSessionsAppService() { }

    public static GetTrainingSessionsAppService getInstance() {
        if (instance == null) {
            instance = new GetTrainingSessionsAppService();
        }

        return instance;
    }

    public List<TrainingSession> getTrainingSessions() {
        //Get all the categories using DAO Pattern
        return TrainingSessionDAO.getInstance().getAll();
    }
}
