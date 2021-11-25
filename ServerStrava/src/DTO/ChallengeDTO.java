package DTO;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class ChallengeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private GregorianCalendar dateOfStart;
	private GregorianCalendar dateOfEnd;
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
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	
	@Override
	public String toString() {
		return "Challenge [name=" + name + ", dateOfStart=" + dateOfStart + ", dateOfEnd=" + dateOfEnd
				+ ", sport=" + sport + "]";
	}
}
