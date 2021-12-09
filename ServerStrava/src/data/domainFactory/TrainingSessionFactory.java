package data.domainFactory;

import data.domain.TrainingSession;

import java.util.Date;
import java.util.GregorianCalendar;

public class TrainingSessionFactory {
    public static TrainingSession createTrainingSession() {
        TrainingSession ts = new TrainingSession();
        Date date = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);

        ts.setTitle("Correr por la costa");
        ts.setSport("running");
        ts.setDistance(8.7);
        ts.setDateOfStart(gregorianCalendar);
        ts.setHourOfStart(gregorianCalendar);
        ts.setDuration(1.5);
        //1.5 = una hora y media
        ts.setAccepted(false);

        return ts;
    }
}
