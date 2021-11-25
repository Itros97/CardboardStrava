package data.DTO;

import java.io.Serializable;

public class ChallengeWithDistanceDTO extends ChallengeDTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    //objectiveDistance in km
    private double objectiveDistance;

    public double getObjectiveDistance() {
        return objectiveDistance;
    }
    public void setObjectiveDistance(double objectiveDistance) {
        this.objectiveDistance = objectiveDistance;
    }
}
