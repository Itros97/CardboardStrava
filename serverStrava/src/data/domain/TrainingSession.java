package data.domain;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.GregorianCalendar;

@PersistenceCapable
public class TrainingSession {
@PersistenceCapable(detachable="true")
public class TrainingSession implements Serializable {

	@PrimaryKey
	private String title;

	private String sport;
	//distance in km
	private double distance;
	private GregorianCalendar dateOfStart;
	private double duration;
	private boolean accepted;
	
	@Persistent(defaultFetchGroup="true")
	private PasswordProfile passprof;
	  
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public GregorianCalendar getDateOfStart() {
		return dateOfStart;
	}
	public void setDateOfStart(GregorianCalendar dateOfStart) {
		this.dateOfStart = dateOfStart;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	
	@Override
	public String toString() {
		return "TrainingSession [title=" + title + ", sport=" + sport + ", distante=" + distance + ", dateOfStart="
				+ dateOfStart + ", duration=" + duration + "]";
	}
	
}
