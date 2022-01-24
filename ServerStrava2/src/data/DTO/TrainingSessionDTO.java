package data.DTO;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class TrainingSessionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title;
	private String sport;
	//distance in km
	private double distance;
	private GregorianCalendar dateOfStart;
	private double duration;
	private String creatorEmail;

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
	public double getDistante() {
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
	public String getCreatorEmail() {
		return creatorEmail;
	}
	public void setCreatorEmail(String creatorEmail) {
		this.creatorEmail = creatorEmail;
	}
}
