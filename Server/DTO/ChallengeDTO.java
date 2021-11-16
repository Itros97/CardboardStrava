package DTO;
import java.util.GregorianCalendar;

//

public class ChallengeDTO {
	private String name;
	private GregorianCalendar dateOfStart;
	private GregorianCalendar dateOfEnd;
	//objectiveDistance in km
	private double objectiveDistance;
	//objectiveTime in minutes
	private int objectiveTime;
	private String sport;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GregorianCalendar getDateOfStart() {
		return dateOfStart;
	}
	public void setDateOfStart(GregorianCalendar dateOfStart) {
		this.dateOfStart = dateOfStart;
	}
	public GregorianCalendar getDateOfEnd() {
		return dateOfEnd;
	}
	public void setDateOfEnd(GregorianCalendar dateOfEnd) {
		this.dateOfEnd = dateOfEnd;
	}
	public double getObjectiveDistance() {
		return objectiveDistance;
	}
	public void setObjectiveDistance(double objectiveDistance) {
		this.objectiveDistance = objectiveDistance;
	}
	public int getObjectiveTime() {
		return objectiveTime;
	}
	public void setObjectiveTime(int objectiveTime) {
		this.objectiveTime = objectiveTime;
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	
	@Override
	public String toString() {
		return "Challenge [name=" + name + ", dateOfStart=" + dateOfStart + ", dateOfEnd=" + dateOfEnd
				+ ", objectiveDistance=" + objectiveDistance + ", objectiveTime=" + objectiveTime + ", sport=" + sport
				+ "]";
	}
}
