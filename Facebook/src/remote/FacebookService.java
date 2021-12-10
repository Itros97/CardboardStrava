/*package remote;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class FacebookService extends Thread {
    private DataInputStream in;
    private DataOutputStream out;
    private Socket tcpSocket;

    public FacebookService(Socket socket) {
        try {
            this.tcpSocket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.start();
        } catch (Exception e) {
            System.out.println("# FacebookService - TCPConnection IO error:" + e.getMessage());
        }
    }

    public void run() {
        //Facebook server
        try {
            //Read request from the client
            String data = this.in.readUTF();
            System.out.println("   - FacebookService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");

            //Send response to the client
            this.out.writeUTF(data.toUpperCase());
            System.out.println("   - FacebookService - Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data.toUpperCase() + "'");
        } catch (Exception e) {
            System.out.println("   # FacebookService error" + e.getMessage());
        } finally {
            try {
                tcpSocket.close();
            } catch (Exception e) {
                System.out.println("   # FacebookService error:" + e.getMessage());
            }
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
}*/