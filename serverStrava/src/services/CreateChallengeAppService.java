package services;

import java.rmi.RemoteException;
import java.util.Calendar;

import data.DTO.ChallengeDTO;
import data.domain.*;
import gateway.*;

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
        if (ch != null) {
            //Save the challenge in the DB using DAO Pattern
            ChallengeDAO.getInstance().save(ch);
        }
    }
}
