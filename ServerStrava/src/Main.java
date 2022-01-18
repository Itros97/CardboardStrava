import java.rmi.Naming;

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
            System.out.println(" * STRAVA server '" + name + "' started!!");
        } catch (Exception ex) {
            System.err.println(" # STRAVA Server Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void initDB() {
        try {
            //Create Profiles
            Profile p1 = new Profile();

            Profile p2 = new Profile();

            Profile p3 = new Profile();

            //Save Users in the DB
            ProfileDAO.getInstance().save(p1);
            ProfileDAO.getInstance().save(p2);
            ProfileDAO.getInstance().save(p3);

            PasswordProfile pp1 = new PasswordProfile();

            PasswordProfile pp2 = new PasswordProfile();

            PasswordProfile pp3 = new PasswordProfile();

            //Save Users in the DB
            PasswordProfileDAO.getInstance().save(p1);
            PasswordProfileDAO.getInstance().save(p2);
            PasswordProfileDAO.getInstance().save(p3);

            TrainingSession ts1 = new TrainingSession();

            TrainingSession ts2 = new TrainingSession();

            TrainingSession ts3 = new TrainingSession();

            //Save Users in the DB
            TrainingSessionDAO.getInstance().save(p1);
            TrainingSessionDAO.getInstance().save(p2);
            TrainingSessionDAO.getInstance().save(p3);

            Challenge ch1 = new Challenge();

            Challenge ch2 = new Challenge();

            Challenge ch3 = new Challenge();

            //Save Users in the DB
            ChallengeDAO.getInstance().save(p1);
            ChallengeDAO.getInstance().save(p2);
            ChallengeDAO.getInstance().save(p3);

            ChallengeWithDistance chd1 = new ChallengeWithDistance();

            ChallengeWithDistance chd2 = new ChallengeWithDistance();

            ChallengeWithDistance chd3 = new ChallengeWithDistance();

            //Save Users in the DB
            ChallengeWithDistanceDAO.getInstance().save(p1);
            ChallengeWithDistanceDAO.getInstance().save(p2);
            ChallengeWithDistanceDAO.getInstance().save(p3);

            ChallengeWithTime cht1 = new ChallengeWithTime();

            ChallengeWithTime cht2 = new ChallengeWithTime();

            ChallengeWithTime cht3 = new ChallengeWithTime();

            //Save Users in the DB
            ChallengeWithTimeDAO.getInstance().save(p1);
            ChallengeWithTimeDAO.getInstance().save(p2);
            ChallengeWithTimeDAO.getInstance().save(p3);
        } catch (Exception ex) {
            System.out.println(" $ Error initializing data base:" + ex.getMessage());
        }
    }

}