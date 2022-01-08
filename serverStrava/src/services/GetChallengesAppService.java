package services;

import data.dao.ChallengeDAO;
import data.domain.Challenge;

import java.util.List;

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
