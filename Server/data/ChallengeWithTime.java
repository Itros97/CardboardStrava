package data;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class ChallengeWithTime extends Challenge {
    //objectiveTime in minutes
    private int objectiveTime;

    public int getObjectiveTime() {
        return objectiveTime;
    }
    public void setObjectiveTime(int objectiveTime) {
        this.objectiveTime = objectiveTime;
    }
}