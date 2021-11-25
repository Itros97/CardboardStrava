package remote;

import java.rmi.Remote;
import java.util.Date;
import java.util.List;
import ServerStrava.src.data.DTO.ProfileDTO;
import ServerStrava.src.data.DTO.PasswordProfileDTO;
import ServerStrava.src.data.DTO.ChallengeDTO;
import ServerStrava.src.data.DTO.ChallengeWithDistanceDTO;
import ServerStrava.src.data.DTO.ChallengeWithTimeDTO;
import ServerStrava.src.data.DTO.TrainingSessionDTO;
import ServerStrava.src.data.domain.*;

public interface IRemoteFaçade extends Remote {
    Profile loginUser(String email, String password);
    Profile registerUser(String GoogleOrFacebook, String email, String password);
    List<TrainingSessionDTO> getTrainingSessions();
    List<ChallengeDTO> getChallenges();
    void createTrainingSession(TrainingSession ts);
    void createChallenge(Challenge ch);
}
