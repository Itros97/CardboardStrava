import java.rmi.Naming;
import java.util.GregorianCalendar;

import data.domain.*;
import data.dao.*;
import remote.IRemoteFacade;
import remote.RemoteFacade;

public class Main {

    public static void main(String[] args) {
        //Activate Security Manager. It is needed for RMI.
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        //args[0] = RMIRegistry IP
        //args[1] = RMIRegistry Port
        //args[2] = Service Name
        String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

        //Initialize DB
        initDB();

        //Bind remote facade instance to a service name using RMIRegistry
        try {
            IRemoteFacade remoteFacade = new RemoteFacade();
            Naming.rebind(name, remoteFacade);
            System.setProperty("java.rmi.server.hostname","127.0.0.1");
            System.out.println(" * STRAVA server '" + name + "' started!!");
        } catch (Exception ex) {
            System.err.println(" # STRAVA Server Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void initDB() {
        try {
            GregorianCalendar calendar = new GregorianCalendar();

            //Create Profiles
            Profile p1 = new Profile();
            p1.setEmail("jaimeamann@opendeusto.es");
            p1.setNickname("Jaime");
            p1.setBirthdate(calendar);
            p1.setWeightKg(75.6);
            p1.setHeightCm(172);
            p1.setMaximumHeartRate(175);
            p1.setReposeHeartRate(80);
            p1.setRegisterType("google");

            Profile p2 = new Profile();
            p2.setEmail("terrazasygeranios@gmail.com");
            p2.setNickname("Rama");
            p2.setBirthdate(calendar);
            p2.setWeightKg(68.8);
            p2.setHeightCm(163);
            p2.setMaximumHeartRate(175);
            p2.setReposeHeartRate(80);
            p2.setRegisterType("facebook");

            Profile p3 = new Profile();
            p3.setEmail("usuarioUsario@gmail.com");
            p3.setNickname("usuario");
            p3.setBirthdate(calendar);
            p3.setWeightKg(90.5);
            p3.setHeightCm(200);
            p3.setMaximumHeartRate(175);
            p3.setReposeHeartRate(80);
            p3.setRegisterType("");

            Profile p4 = new Profile();
            p4.setEmail("maildelbujas@gmail.com");
            p4.setNickname("El rapido");
            p4.setBirthdate(calendar);
            p4.setWeightKg(72.4);
            p4.setHeightCm(170);
            p4.setMaximumHeartRate(175);
            p4.setReposeHeartRate(80);
            p4.setRegisterType("google");

            Profile p5 = new Profile();
            p5.setEmail("ameliasili@gmail.com");
            p5.setNickname("Amelia");
            p5.setBirthdate(calendar);
            p5.setWeightKg(80.1);
            p5.setHeightCm(178);
            p5.setMaximumHeartRate(175);
            p5.setReposeHeartRate(80);
            p5.setRegisterType("");

            //Save Users in the DB
            ProfileDAO.getInstance().save(p1);
            ProfileDAO.getInstance().save(p2);
            ProfileDAO.getInstance().save(p3);
            ProfileDAO.getInstance().save(p4);
            ProfileDAO.getInstance().save(p5);

            PasswordProfile pp1 = new PasswordProfile();
            pp1.setEmail("elenagonzalez@gmail.com");
            pp1.setNickname("El");
            pp1.setBirthdate();
            pp1.setWeightKg();
            pp1.setHeightCm();
            pp1.setMaximumHeartRate();
            pp1.setReposeHeartRate();
            pp1.setRegisterType();
            pp1.setPassword("");

            PasswordProfile pp2 = new PasswordProfile();
            pp2.setEmail("elenagonzalez@gmail.com");
            pp2.setNickname("El");
            pp2.setBirthdate();
            pp2.setWeightKg();
            pp2.setHeightCm();
            pp2.setMaximumHeartRate();
            pp2.setReposeHeartRate();
            pp2.setRegisterType();
            pp2.setPassword("");

            PasswordProfile pp3 = new PasswordProfile();
            pp3.setEmail("elenagonzalez@gmail.com");
            pp3.setNickname("El");
            pp3.setBirthdate();
            pp3.setWeightKg();
            pp3.setHeightCm();
            pp3.setMaximumHeartRate();
            pp3.setReposeHeartRate();
            pp3.setRegisterType();
            pp3.setPassword("");

            PasswordProfile pp4 = new PasswordProfile();
            pp4.setEmail("elenagonzalez@gmail.com");
            pp4.setNickname("El");
            pp4.setBirthdate();
            pp4.setWeightKg();
            pp4.setHeightCm();
            pp4.setMaximumHeartRate();
            pp4.setReposeHeartRate();
            pp4.setRegisterType();
            pp4.setPassword("");

            PasswordProfile pp5 = new PasswordProfile();
            pp5.setEmail("elenagonzalez@gmail.com");
            pp5.setNickname("El");
            pp5.setBirthdate();
            pp5.setWeightKg();
            pp5.setHeightCm();
            pp5.setMaximumHeartRate();
            pp5.setReposeHeartRate();
            pp5.setRegisterType();
            pp5.setPassword("");

            //Save Users in the DB
            PasswordProfileDAO.getInstance().save(pp1);
            PasswordProfileDAO.getInstance().save(pp2);
            PasswordProfileDAO.getInstance().save(pp3);
            PasswordProfileDAO.getInstance().save(pp4);
            PasswordProfileDAO.getInstance().save(pp5);

            TrainingSession ts1 = new TrainingSession();
            ts1.setTitle();
            ts1.setSport();
            ts1.setDistance();
            ts1.setDistance();
            ts1.setDistance();
            ts1.setDateOfStart();
            ts1.setDuration();
            ts1.setAccepted();

            TrainingSession ts2 = new TrainingSession();
            ts2.setTitle();
            ts2.setSport();
            ts2.setDistance();
            ts2.setDistance();
            ts2.setDistance();
            ts2.setDateOfStart();
            ts2.setDuration();
            ts2.setAccepted();

            TrainingSession ts3 = new TrainingSession();
            ts3.setTitle();
            ts3.setSport();
            ts3.setDistance();
            ts3.setDistance();
            ts3.setDistance();
            ts3.setDateOfStart();
            ts3.setDuration();
            ts3.setAccepted();

            TrainingSession ts4 = new TrainingSession();
            ts4.setTitle();
            ts4.setSport();
            ts4.setDistance();
            ts4.setDistance();
            ts4.setDistance();
            ts4.setDateOfStart();
            ts4.setDuration();
            ts4.setAccepted();

            TrainingSession ts5 = new TrainingSession();
            ts5.setTitle();
            ts5.setSport();
            ts5.setDistance();
            ts5.setDistance();
            ts5.setDistance();
            ts5.setDateOfStart();
            ts5.setDuration();
            ts5.setAccepted();

            //Save Users in the DB
            TrainingSessionDAO.getInstance().save(ts1);
            TrainingSessionDAO.getInstance().save(ts2);
            TrainingSessionDAO.getInstance().save(ts3);
            TrainingSessionDAO.getInstance().save(ts4);
            TrainingSessionDAO.getInstance().save(ts5);

            Challenge ch1 = new Challenge();
            ch1.setName();
            ch1.setDateOfStart();
            ch1.setDateOfEnd();
            ch1.setSport();
            ch1.setAccepted();

            Challenge ch2 = new Challenge();
            ch2.setName();
            ch2.setDateOfStart();
            ch2.setDateOfEnd();
            ch2.setSport();
            ch2.setAccepted();

            Challenge ch3 = new Challenge();
            ch3.setName();
            ch3.setDateOfStart();
            ch3.setDateOfEnd();
            ch3.setSport();
            ch3.setAccepted();

            Challenge ch4 = new Challenge();
            ch4.setName();
            ch4.setDateOfStart();
            ch4.setDateOfEnd();
            ch4.setSport();
            ch4.setAccepted();

            Challenge ch5 = new Challenge();
            ch5.setName();
            ch5.setDateOfStart();
            ch5.setDateOfEnd();
            ch5.setSport();
            ch5.setAccepted();

            //Save Users in the DB
            ChallengeDAO.getInstance().save(ch1);
            ChallengeDAO.getInstance().save(ch2);
            ChallengeDAO.getInstance().save(ch3);
            ChallengeDAO.getInstance().save(ch4);
            ChallengeDAO.getInstance().save(ch5);

            ChallengeWithDistance chd1 = new ChallengeWithDistance();
            chd1.setName();
            chd1.setDateOfStart();
            chd1.setDateOfEnd();
            chd1.setSport();
            chd1.setObjectiveDistance();
            chd1.setAccepted();

            ChallengeWithDistance chd2 = new ChallengeWithDistance();
            chd2.setName();
            chd2.setDateOfStart();
            chd2.setDateOfEnd();
            chd2.setSport();
            chd2.setObjectiveDistance();
            chd2.setAccepted();

            ChallengeWithDistance chd3 = new ChallengeWithDistance();
            chd3.setName();
            chd3.setDateOfStart();
            chd3.setDateOfEnd();
            chd3.setSport();
            chd3.setObjectiveDistance();
            chd3.setAccepted();

            ChallengeWithDistance chd4 = new ChallengeWithDistance();
            chd4.setName();
            chd4.setDateOfStart();
            chd4.setDateOfEnd();
            chd4.setSport();
            chd4.setObjectiveDistance();
            chd4.setAccepted();

            ChallengeWithDistance chd5 = new ChallengeWithDistance();
            chd5.setName();
            chd5.setDateOfStart();
            chd5.setDateOfEnd();
            chd5.setSport();
            chd5.setObjectiveDistance();
            chd5.setAccepted();

            //Save Users in the DB
            ChallengeWithDistanceDAO.getInstance().save(chd1);
            ChallengeWithDistanceDAO.getInstance().save(chd2);
            ChallengeWithDistanceDAO.getInstance().save(chd3);
            ChallengeWithDistanceDAO.getInstance().save(chd4);
            ChallengeWithDistanceDAO.getInstance().save(chd5);

            ChallengeWithTime cht1 = new ChallengeWithTime();
            cht1.setName();
            cht1.setDateOfStart();
            cht1.setDateOfEnd();
            cht1.setSport();
            cht1.setObjectiveTime();
            cht1.setAccepted();

            ChallengeWithTime cht2 = new ChallengeWithTime();
            cht2.setName();
            cht2.setDateOfStart();
            cht2.setDateOfEnd();
            cht2.setSport();
            cht2.setObjectiveTime();
            cht2.setAccepted();

            ChallengeWithTime cht3 = new ChallengeWithTime();
            cht3.setName();
            cht3.setDateOfStart();
            cht3.setDateOfEnd();
            cht3.setSport();
            cht3.setObjectiveTime();
            cht3.setAccepted();

            ChallengeWithTime cht4 = new ChallengeWithTime();
            cht4.setName();
            cht4.setDateOfStart();
            cht4.setDateOfEnd();
            cht4.setSport();
            cht4.setObjectiveTime();
            cht4.setAccepted();

            ChallengeWithTime cht5 = new ChallengeWithTime();
            cht5.setName();
            cht5.setDateOfStart();
            cht5.setDateOfEnd();
            cht5.setSport();
            cht5.setObjectiveTime();
            cht5.setAccepted();

            //Save Users in the DB
            ChallengeWithTimeDAO.getInstance().save(cht1);
            ChallengeWithTimeDAO.getInstance().save(cht2);
            ChallengeWithTimeDAO.getInstance().save(cht3);
            ChallengeWithTimeDAO.getInstance().save(cht4);
            ChallengeWithTimeDAO.getInstance().save(cht5);
        } catch (Exception ex) {
            System.out.println(" $ Error initializing data base:" + ex.getMessage());
        }
    }

}