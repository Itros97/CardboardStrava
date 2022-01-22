package data.DTO;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class ChallengeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
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

}
