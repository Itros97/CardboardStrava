package data.domainFactory;


import data.domain.Challenge;
import data.domain.ChallengeWithDistance;
import data.domain.ChallengeWithTime;

import java.util.Date;
import java.util.GregorianCalendar;

public class ChallengeFactory {
    public static Challenge createChallenge(String what) {
        Date date = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        if (what.equals("distance")) {
            ChallengeWithDistance challengeWithDistance = new ChallengeWithDistance();

            challengeWithDistance.setName("biatlón");
            challengeWithDistance.setDateOfStart(gregorianCalendar);
            challengeWithDistance.setDateOfEnd(gregorianCalendar);
            challengeWithDistance.setSport("ambos deportes");
            challengeWithDistance.setObjectiveDistance(18.2);
            challengeWithDistance.setEmailAceptante("");

            return challengeWithDistance;
        } else if (what.equals("time")) {
            ChallengeWithTime challengeWithTime = new ChallengeWithTime();

            challengeWithTime.setName("biatlón");
            challengeWithTime.setDateOfStart(gregorianCalendar);
            challengeWithTime.setDateOfEnd(gregorianCalendar);
            challengeWithTime.setSport("ambos deportes");
            challengeWithTime.setObjectiveTime(3);
            challengeWithTime.setEmailAceptante("");

            return challengeWithTime;
        } else {
            Challenge ch = new Challenge();

            ch.setName("biatlón");
            ch.setDateOfStart(gregorianCalendar);
            ch.setDateOfEnd(gregorianCalendar);
            ch.setSport("ambos deportes");
            ch.setEmailAceptante("");

            return ch;
        }
    }
}
