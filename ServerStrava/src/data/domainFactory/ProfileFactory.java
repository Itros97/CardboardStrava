package data.domainFactory;

import data.domain.PasswordProfile;
import data.domain.Profile;

import java.util.Date;
import java.util.GregorianCalendar;

public class ProfileFactory {
    public static Profile createProfile(String what) {
        if (what.equals("password")) {
            PasswordProfile passwordP = new PasswordProfile();
            Date date = new Date();
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date);

            passwordP.setEmail("user@gmail.com");
            passwordP.setPassword("password");
            passwordP.setNickname("firstuser");
            passwordP.setBirthdate(gregorianCalendar);
            passwordP.setWeightKg(60);
            passwordP.setHeightCm(168);
            passwordP.setMaximumHeartRate(60);
            passwordP.setReposeHeartRate(100);
            passwordP.setRegisterType("Google");

            return passwordP;
        } else {
            Profile p = new Profile();
            Date date = new Date();
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date);

            p.setEmail("user@gmail.com");
            p.setNickname("firstuser");
            p.setBirthdate(gregorianCalendar);
            p.setWeightKg(60);
            p.setHeightCm(168);
            p.setMaximumHeartRate(60);
            p.setReposeHeartRate(100);
            p.setRegisterType("Google");

            return p;
        }
    }
}
