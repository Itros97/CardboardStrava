package data;
import java.util.GregorianCalendar;

public class TrainingSession {
	private String title;
	private String sport;
	//distance in km
	private double distante;
	private GregorianCalendar dateOfStart;
	private GregorianCalendar hourOfStart;
	private double duration;
	
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
		return distante;
	}
	public void setDistante(double distante) {
		this.distante = distante;
	}
	public GregorianCalendar getDateOfStart() {
		return dateOfStart;
	}
	public void setDateOfStart(GregorianCalendar dateOfStart) {
		this.dateOfStart = dateOfStart;
	}
	public GregorianCalendar getHourOfStart() {
		return hourOfStart;
	}
	public void setHourOfStart(GregorianCalendar hourOfStart) {
		this.hourOfStart = hourOfStart;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "TrainingSession [title=" + title + ", sport=" + sport + ", distante=" + distante + ", dateOfStart="
				+ dateOfStart + ", hourOfStart=" + hourOfStart + ", duration=" + duration + "]";
	}
	
}
