package remote;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GoogleService extends UnicastRemoteObject implements IGoogle {
    private static final long serialVersionUID = 1L;

    protected static final String URL = "https://free.currconv.com/api/v7/convert?q=USD_EUR,GBP_EUR&compact=ultra&apiKey=d4f1b436d25d00b16f3f";

    //Attribute for the Singleton pattern
    public static GoogleService instance;

    private GoogleService() throws RemoteException {
        super();
        connectToServer();
    }

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

    private static final void connectToServer() {
        System.out.println(" - Connecting to 'free.currconv.com'....");

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
            System.out.println("  # Error connecting to server(): " + ex.getMessage());
        }
    }

    public void login() throws RemoteException {
        System.out.println(" - Trying to login in 'free.currconv.com'....");

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

            inputLine = response.toString();
            System.out.println(" - Login successful!");
        } catch(Exception ex) {
            System.out.println("  # Login error: " + ex.getMessage());
        }
    }

    public void register() throws RemoteException {
        System.out.println(" - Trying to register in 'free.currconv.com'....");

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

            inputLine = response.toString();
            System.out.println(" - Registered with success!");
        } catch(Exception ex) {
            System.out.println("  # Register error: " + ex.getMessage());
        }
    }
}
