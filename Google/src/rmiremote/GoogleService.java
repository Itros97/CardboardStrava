package rmiremote;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GoogleService extends UnicastRemoteObject implements IGoogle {
    private static final long serialVersionUID = 1L;
    protected static final String URL = "";
    private int cont = 0;

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
    }

    public boolean login(String email) throws RemoteException {
        System.out.println(" - Logging in 'COLOCAR AQUI UN LINK'....");

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
            return true;

            } catch(Exception ex) {
                System.out.println("  # Error in the login(): " + ex.getMessage());
                return false;
        }
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
