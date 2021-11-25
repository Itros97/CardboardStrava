package data;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class ChallengeWithDistance extends Challenge {
    //objectiveDistance in km
    private double objectiveDistance;

    public double getObjectiveDistance() {
        return objectiveDistance;
    }
    public void setObjectiveDistance(double objectiveDistance) {
        this.objectiveDistance = objectiveDistance;
    }
}
