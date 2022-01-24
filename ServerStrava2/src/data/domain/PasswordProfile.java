package data.domain;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;
import java.util.GregorianCalendar;

@PersistenceCapable(detachable="true")

public class PasswordProfile implements Serializable {

    @PrimaryKey
    private String email;

    private String nickname;
    private GregorianCalendar birthdate;
    private double weightKg;
    private int heightCm;
    private int maximumHeartRate;
    private int reposeHeartRate;
    private String registerType;
    private String password;

    @Persistent(defaultFetchGroup="true")
    private Challenge challenge;
    
    @Persistent(defaultFetchGroup="true")
    private ChallengeWithDistance challengewd;
    
    @Persistent(defaultFetchGroup="true")
    private ChallengeWithTime challengewt;
    
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
    public String getRegisterType() {
        return registerType;
    }
    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Profile [email=" + email + ", name=" + nickname + ", birthdate=" + birthdate + ", weightKg=" + weightKg
                + ", heightCm=" + heightCm + ", maximumHeartRate=" + maximumHeartRate + ", reposeHeartRate="
                + reposeHeartRate +  ", registerType=" + registerType + "]";
    }
}