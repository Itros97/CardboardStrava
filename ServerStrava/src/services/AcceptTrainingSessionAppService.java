package services;

import data.dao.TrainingSessionDAO;
import data.domain.TrainingSession;
import java.util.ArrayList;
import java.util.List;

public class AcceptTrainingSessionAppService {
    //Instance for Singleton Pattern
    private static AcceptTrainingSessionAppService instance;

    private AcceptTrainingSessionAppService() { }

    public static AcceptTrainingSessionAppService getInstance() {
        if (instance == null) {
            instance = new AcceptTrainingSessionAppService();
        }

        return instance;
    }

    public void accept (String title) {
        List<TrainingSession> ts = new ArrayList<TrainingSession>();
        ts = GetTrainingSessionsAppService.getInstance().getTrainingSessions();

        for (TrainingSession t : ts) {
            if (title.equals(t.getTitle())) {
                t.setAccepted(true);
                TrainingSession tr = new TrainingSession();
                tr = t;
                ts.remove(t);
                TrainingSessionDAO.getInstance().save(tr);
            }
        }
    }
}
