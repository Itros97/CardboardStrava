package DTO;

public class ChallengeWithTimeDTO extends ChallengeDTO {
    //objectiveTime in minutes
    private int objectiveTime;

    public int getObjectiveTime() {
        return objectiveTime;
    }
    public void setObjectiveTime(int objectiveTime) {
        this.objectiveTime = objectiveTime;
    }
}
