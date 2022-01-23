package services;

import data.dao.ChallengeDAO;
import data.dao.ChallengeWithDistanceDAO;
import data.dao.ChallengeWithTimeDAO;
import data.domain.Challenge;
import data.domain.ChallengeWithDistance;
import data.domain.ChallengeWithTime;

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

    public List<ChallengeWithDistance> getChallengesWithDistance() {
        //Get all the categories using DAO Pattern
        return ChallengeWithDistanceDAO.getInstance().getAll();
    }

    public List<ChallengeWithTime> getChallengesWithTime() {
        //Get all the categories using DAO Pattern
        return ChallengeWithTimeDAO.getInstance().getAll();
    }
}
