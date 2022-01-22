package data.domain;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import java.io.Serializable;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class ChallengeWithDistance extends Challenge implements Serializable {
    //objectiveDistance in km
    private double objectiveDistance;

    public double getObjectiveDistance() {
        return objectiveDistance;
    }
    public void setObjectiveDistance(double objectiveDistance) {
        this.objectiveDistance = objectiveDistance;
    }
}
