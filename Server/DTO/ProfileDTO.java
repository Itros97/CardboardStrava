package DTO;

import java.util.GregorianCalendar;

public class ProfileDTO {

	private String email;
	private String name;
	private GregorianCalendar birthdate;
	private double weightKg;
	private int heightCm;
	private int maximumHeartRate;
	private int reposeHeartRate;
	private String password;
	private String registerType;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GregorianCalendar getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(GregorianCalendar birthdate) {
		this.birthdate = birthdate;
	}
	public double getWeightKg() {
		return weightKg;
	}
	public void setWeightKg(double weightKg) {
		this.weightKg = weightKg;
	}
	public int getHeightCm() {
		return heightCm;
	}
	public void setHeightCm(int heightCm) {
		this.heightCm = heightCm;
	}
	public int getMaximumHeartRate() {
		return maximumHeartRate;
	}
	public void setMaximumHeartRate(int maximumHeartRate) {
		this.maximumHeartRate = maximumHeartRate;
	}
	public int getReposeHeartRate() {
		return reposeHeartRate;
	}
	public void setReposeHeartRate(int reposeHeartRate) {
		this.reposeHeartRate = reposeHeartRate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegisterType() {
		return registerType;
	}
	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}
	@Override
	public String toString() {
		return "Profile [email=" + email + ", name=" + name + ", birthdate=" + birthdate + ", weightKg=" + weightKg
				+ ", heightCm=" + heightCm + ", maximumHeartRate=" + maximumHeartRate + ", reposeHeartRate="
				+ reposeHeartRate + ", password=" + password + ", registerType=" + registerType + "]";
	}
	
	
	
}