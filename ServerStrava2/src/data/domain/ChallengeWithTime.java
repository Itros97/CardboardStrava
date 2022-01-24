package data.domain;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import java.io.Serializable;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class ChallengeWithTime extends Challenge implements Serializable {
    //objectiveTime in minutes
    private int objectiveTime;

    public int getObjectiveTime() {
        return objectiveTime;
    }
    public void setObjectiveTime(int objectiveTime) {
        this.objectiveTime = objectiveTime;
    }
}
