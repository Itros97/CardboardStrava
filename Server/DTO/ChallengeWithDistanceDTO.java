package DTO;

public class ChallengeWithDistanceDTO extends ChallengeDTO {
    //objectiveDistance in km
    private double objectiveDistance;

    public double getObjectiveDistance() {
        return objectiveDistance;
    }
    public void setObjectiveDistance(double objectiveDistance) {
        this.objectiveDistance = objectiveDistance;
    }
}
