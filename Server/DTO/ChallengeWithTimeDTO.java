package DTO;

import java.io.Serializable;

public class ChallengeWithTimeDTO extends ChallengeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    //objectiveTime in minutes
    private int objectiveTime;

    public int getObjectiveTime() {
        return objectiveTime;
    }
    public void setObjectiveTime(int objectiveTime) {
        this.objectiveTime = objectiveTime;
    }
}
