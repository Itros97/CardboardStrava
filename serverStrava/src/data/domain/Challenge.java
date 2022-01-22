package data.domain;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;
import java.util.GregorianCalendar;

@PersistenceCapable
public class Challenge implements Serializable {

	@PrimaryKey
	private String name;

	private GregorianCalendar dateOfStart;
	private GregorianCalendar dateOfEnd;
	private String sport;
	private String emailAceptante;
	
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
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public String getEmailAceptante() {
		return emailAceptante;
	}
	public void setEmailAceptante(String emailAceptante) {
		this.emailAceptante = emailAceptante;
	}
	
	@Override
	public String toString() {
		return "Challenge [name=" + name + ", dateOfStart=" + dateOfStart + ", dateOfEnd=" + dateOfEnd
				+ ", sport=" + sport + "]";
	}
}
