package services;

import java.rmi.RemoteException;
import java.util.List;
import data.DTO.ChallengeDTO;
import data.domain.*;
import data.dao.*;
import gateway.*;

public class GetChallengesAppService {
    //Instance for Singleton Pattern
    private static GetChallengesAppService instance;

    private GetChallengesAppService() { }

    public static GetChallengesAppService getInstance() {
        if (instance == null) {
            instance = new GetChallengesAppService();
        }

        return instance;
    }

    public List<Challenge> getChallenges() {
        //Get all the categories using DAO Pattern
        return ChallengeDAO.getInstance().getAll();
    }
}
