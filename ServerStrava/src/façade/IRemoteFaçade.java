package façade;

import java.rmi.Remote;
import java.util.Date;
import java.util.List;

public interface IRemoteFaçade IRemoteFacade extends Remote {
    boolean loginUser(String email, String password);
    boolean registerUser(String GoogleOrFacebook, String email, String password);
    List<TrainingSessionDTO> getTrainingSessions();
}
