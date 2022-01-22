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

            /* DATOS ANTIGUOS
            //Create Profiles
            Profile p1 = new Profile();
            p1.setEmail("primerprofile@opendeusto.es");
            p1.setNickname("profile");
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
            ProfileDAO.getInstance().save(p5);*/

            PasswordProfile pp1 = new PasswordProfile();
            pp1.setEmail("denna@gmail.com");
            pp1.setNickname("Chand");
            pp1.setBirthdate(calendar);
            pp1.setWeightKg(70.4);
            pp1.setHeightCm(174);
            pp1.setMaximumHeartRate(175);
            pp1.setReposeHeartRate(80);
            pp1.setRegisterType("");
            pp1.setPassword("password");

            PasswordProfile pp2 = new PasswordProfile();
            pp2.setEmail("ambrose@gmail.com");
            pp2.setNickname("Jackass");
            pp2.setBirthdate(calendar);
            pp2.setWeightKg(140.4);
            pp2.setHeightCm(170);
            pp2.setMaximumHeartRate(175);
            pp2.setReposeHeartRate(80);
            pp2.setRegisterType("facebook");
            pp2.setPassword("qwerty");

            PasswordProfile pp3 = new PasswordProfile();
            pp3.setEmail("bredon@gmail.com");
            pp3.setNickname("Ceniza");
            pp3.setBirthdate(calendar);
            pp3.setWeightKg(68.3);
            pp3.setHeightCm(183);
            pp3.setMaximumHeartRate(175);
            pp3.setReposeHeartRate(80);
            pp3.setRegisterType("facebook");
            pp3.setPassword("asdfg");

            PasswordProfile pp4 = new PasswordProfile();
            pp4.setEmail("ilodin@gmail.com");
            pp4.setNickname("TaborlinTheGreat");
            pp4.setBirthdate(calendar);
            pp4.setWeightKg(64.1);
            pp4.setHeightCm(190);
            pp4.setMaximumHeartRate(175);
            pp4.setReposeHeartRate(80);
            pp4.setRegisterType("");
            pp4.setPassword("yuiop");

            PasswordProfile pp5 = new PasswordProfile();
            pp5.setEmail("tunnelauri@gmail.com");
            pp5.setNickname("Bob");
            pp5.setBirthdate(calendar);
            pp5.setWeightKg(61.7);
            pp5.setHeightCm(162);
            pp5.setMaximumHeartRate(175);
            pp5.setReposeHeartRate(80);
            pp5.setRegisterType("");
            pp5.setPassword("electricboogaloo");

            PasswordProfile pp6 = new PasswordProfile();
            pp6.setEmail("jaimeamann@opendeusto.es");
            pp6.setNickname("");
            pp6.setBirthdate(calendar);
            pp6.setRegisterType("google");
            pp6.setPassword("12345678");

            PasswordProfile pp7 = new PasswordProfile();
            pp7.setEmail("m.lopez.gutierrez@opendeusto.es");
            pp7.setNickname("");
            pp7.setBirthdate(calendar);
            pp7.setRegisterType("google");
            pp7.setPassword("qwertyui");

            PasswordProfile pp8 = new PasswordProfile();
            pp8.setEmail("inigo.tarrino@opendeusto.es");
            pp8.setNickname("");
            pp8.setBirthdate(calendar);
            pp8.setRegisterType("google");
            pp8.setPassword("asdfghjk");

            PasswordProfile pp9 = new PasswordProfile();
            pp9.setEmail("mikel.huidobro@opendeusto.es");
            pp9.setNickname("");
            pp9.setBirthdate(calendar);
            pp9.setRegisterType("google");
            pp9.setPassword("zxcvbnm.");

            //Save Users in the DB
            PasswordProfileDAO.getInstance().save(pp1);
            PasswordProfileDAO.getInstance().save(pp2);
            PasswordProfileDAO.getInstance().save(pp3);
            PasswordProfileDAO.getInstance().save(pp4);
            PasswordProfileDAO.getInstance().save(pp5);
            PasswordProfileDAO.getInstance().save(pp6);
            PasswordProfileDAO.getInstance().save(pp7);
            PasswordProfileDAO.getInstance().save(pp8);
            PasswordProfileDAO.getInstance().save(pp9);

            TrainingSession ts1 = new TrainingSession();
            ts1.setTitle("Running");
            ts1.setSport("correr");
            ts1.setDistance(12);
            ts1.setDateOfStart(calendar);
            ts1.setDuration(60);
            ts1.setCreatorEmail("");

            TrainingSession ts2 = new TrainingSession();
            ts2.setTitle("Biciclismo");
            ts2.setSport("ciclismo");
            ts2.setDistance(24);
            ts2.setDateOfStart(calendar);
            ts2.setDuration(60);
            ts2.setCreatorEmail("");

            TrainingSession ts3 = new TrainingSession();
            ts3.setTitle("Natacion");
            ts3.setSport("natacion");
            ts3.setDistance(10);
            ts3.setDateOfStart(calendar);
            ts3.setDuration(200);
            ts3.setCreatorEmail("");

            TrainingSession ts4 = new TrainingSession();
            ts4.setTitle("Correr");
            ts4.setSport("correr");
            ts4.setDistance(20);
            ts4.setDateOfStart(calendar);
            ts4.setDuration(120);
            ts4.setCreatorEmail("");

            TrainingSession ts5 = new TrainingSession();
            ts5.setTitle("Cycling");
            ts5.setSport("ciclismo");
            ts5.setDistance(40);
            ts5.setDateOfStart(calendar);
            ts5.setDuration(120);
            ts5.setCreatorEmail("");

            //Save Users in the DB
            TrainingSessionDAO.getInstance().save(ts1);
            TrainingSessionDAO.getInstance().save(ts2);
            TrainingSessionDAO.getInstance().save(ts3);
            TrainingSessionDAO.getInstance().save(ts4);
            TrainingSessionDAO.getInstance().save(ts5);

            Challenge ch1 = new Challenge();
            ch1.setName("Correr como Usain Bolt");
            ch1.setDateOfStart(calendar);
            ch1.setDateOfEnd(calendar);
            ch1.setSport("correr");
            ch1.setEmailAceptante("");

            Challenge ch2 = new Challenge();
            ch2.setName("Nadar un kilometro");
            ch2.setDateOfStart(calendar);
            ch2.setDateOfEnd(calendar);
            ch2.setSport("natacion");
            ch2.setEmailAceptante("");

            Challenge ch3 = new Challenge();
            ch3.setName("Subir una colina");
            ch3.setDateOfStart(calendar);
            ch3.setDateOfEnd(calendar);
            ch3.setSport("ciclismo");
            ch3.setEmailAceptante("");

            Challenge ch4 = new Challenge();
            ch4.setName("Subir una montanya");
            ch4.setDateOfStart(calendar);
            ch4.setDateOfEnd(calendar);
            ch4.setSport("ciclismo");
            ch4.setEmailAceptante("");

            Challenge ch5 = new Challenge();
            ch5.setName("Nadar un rato");
            ch5.setDateOfStart(calendar);
            ch5.setDateOfEnd(calendar);
            ch5.setSport("natacion");
            ch5.setEmailAceptante("");

            //Save Users in the DB
            ChallengeDAO.getInstance().save(ch1);
            ChallengeDAO.getInstance().save(ch2);
            ChallengeDAO.getInstance().save(ch3);
            ChallengeDAO.getInstance().save(ch4);
            ChallengeDAO.getInstance().save(ch5);

            ChallengeWithDistance chd1 = new ChallengeWithDistance();
            chd1.setName("Correr como un rayo");
            chd1.setDateOfStart(calendar);
            chd1.setDateOfEnd(calendar);
            chd1.setSport("correr");
            chd1.setObjectiveDistance(30.5);
            chd1.setEmailAceptante("");

            ChallengeWithDistance chd2 = new ChallengeWithDistance();
            chd2.setName("Nadar dos kilometros");
            chd2.setDateOfStart(calendar);
            chd2.setDateOfEnd(calendar);
            chd2.setSport("natacion");
            chd2.setObjectiveDistance(2);
            chd2.setEmailAceptante("");

            ChallengeWithDistance chd3 = new ChallengeWithDistance();
            chd3.setName("Subir una colina en tu bici");
            chd3.setDateOfStart(calendar);
            chd3.setDateOfEnd(calendar);
            chd3.setSport("ciclismo");
            chd3.setObjectiveDistance(0.5);
            chd3.setEmailAceptante("");

            ChallengeWithDistance chd4 = new ChallengeWithDistance();
            chd4.setName("Subir el Gorbea");
            chd4.setDateOfStart(calendar);
            chd4.setDateOfEnd(calendar);
            chd4.setSport("ciclismo");
            chd4.setObjectiveDistance(8.2);
            chd4.setEmailAceptante("");

            ChallengeWithDistance chd5 = new ChallengeWithDistance();
            chd5.setName("Nadar un ratito");
            chd5.setDateOfStart(calendar);
            chd5.setDateOfEnd(calendar);
            chd5.setSport("natacion");
            chd5.setObjectiveDistance(3.2);
            chd5.setEmailAceptante("");

            //Save Users in the DB
            ChallengeWithDistanceDAO.getInstance().save(chd1);
            ChallengeWithDistanceDAO.getInstance().save(chd2);
            ChallengeWithDistanceDAO.getInstance().save(chd3);
            ChallengeWithDistanceDAO.getInstance().save(chd4);
            ChallengeWithDistanceDAO.getInstance().save(chd5);

            ChallengeWithTime cht1 = new ChallengeWithTime();
            cht1.setName("Correr para entrenar");
            cht1.setDateOfStart(calendar);
            cht1.setDateOfEnd(calendar);
            cht1.setSport("correr");
            cht1.setObjectiveTime(300);
            cht1.setEmailAceptante("");

            ChallengeWithTime cht2 = new ChallengeWithTime();
            cht2.setName("Nadar tres kilometros");
            cht2.setDateOfStart(calendar);
            cht2.setDateOfEnd(calendar);
            cht2.setSport("natacion");
            cht2.setObjectiveTime(60);
            cht2.setEmailAceptante("");

            ChallengeWithTime cht3 = new ChallengeWithTime();
            cht3.setName("Paseo en bici");
            cht3.setDateOfStart(calendar);
            cht3.setDateOfEnd(calendar);
            cht3.setSport("ciclismo");
            cht3.setObjectiveTime(30);
            cht3.setEmailAceptante("");

            ChallengeWithTime cht4 = new ChallengeWithTime();
            cht4.setName("Ruta en bici");
            cht4.setDateOfStart(calendar);
            cht4.setDateOfEnd(calendar);
            cht4.setSport("ciclismo");
            cht4.setObjectiveTime(120);
            cht4.setEmailAceptante("");

            ChallengeWithTime cht5 = new ChallengeWithTime();
            cht5.setName("Nadar un largo rato");
            cht5.setDateOfStart(calendar);
            cht5.setDateOfEnd(calendar);
            cht5.setSport("natacion");
            cht5.setObjectiveTime(50);
            cht5.setEmailAceptante("");

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