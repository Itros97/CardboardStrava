package rmiremote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GoogleService extends UnicastRemoteObject implements IGoogle {
    private static final long serialVersionUID = 1L;

    ArrayList<String> emails = new ArrayList<String>();
    ArrayList<String> passwords = new ArrayList<String>();

    //Attribute for the Singleton pattern
    public static GoogleService instance;

    public static GoogleService getInstance() {
        if (instance == null) {
            try {
                instance = new GoogleService();
            } catch(Exception ex) {
                System.err.println("  # Error initializing service(): " + ex.getMessage());
            }
        }

        return instance;
    }

    protected GoogleService() throws RemoteException {
        super();

        String e1 = "jaimeamann@opendeusto.es";
        String e2 = "m.lopez.gutierrez@opendeusto.es";
        String e3 = "inigo.tarrino@opendeusto.es";
        String e4 = "mikel.huidobro@opendeusto.es";
        String e5 = "revision@opendeusto.es";

        emails.add(e1);
        emails.add(e2);
        emails.add(e3);
        emails.add(e4);
        emails.add(e5);

        String p1 = "12345678";
        String p2 = "qwertyui";
        String p3 = "asdfghjk";
        String p4 = "zxcvbnm.";
        String p5 = "password";

        passwords.add(p1);
        passwords.add(p2);
        passwords.add(p3);
        passwords.add(p4);
        passwords.add(p5);
    }

    public boolean login(String email, String password) throws RemoteException {
        System.out.println(" - Logging in Google Server.");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        for (String e : emails) {
            for (String p : passwords) {
                if (e.equals(email) && p.equals(password)) {
                    System.out.println("Login with Google Server completed.");
                    return true;
                }
            }
        }
        System.out.println("Email not found. Login with Google failed.");
        return false;
    }

    //ANTIGUO
    /*public void register(String email, String nickname, GregorianCalendar birthdate,
                         double weightKg, int heightCm, int maximumHeartRate,
                         int reposeHeartRate, String googleOrFacebook
    ) throws RemoteException {
        System.out.println(" - Registering in 'COLOCAR AQUI UN LINK'....");

        try {
            HttpURLConnection con = (HttpURLConnection) (new URL(URL).openConnection());
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            con.disconnect();
        } catch(Exception ex) {
            System.out.println("  # Error in the register(): " + ex.getMessage());
        }
    }*/

}
