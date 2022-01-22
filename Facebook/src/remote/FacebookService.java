package remote;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class FacebookService extends Thread {
    private DataInputStream in;
    private DataOutputStream out;
    private Socket tcpSocket;

    ArrayList<String> emails = new ArrayList<String>();
    ArrayList<String> passwords = new ArrayList<String>();

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
        String e1 = "ambrose@facebook.com";
        String e2 = "bredon@facebook.com";
        String e3 = "usuario@facebook.com";

        emails.add(e1);
        emails.add(e2);
        emails.add(e3);

        String p1 = "qwerty";
        String p2 = "asdfg";
        String p3 = "12345678";

        passwords.add(p1);
        passwords.add(p2);
        passwords.add(p3);

        //Facebook server
        try {
            //Read request from the client
            String email = this.in.readUTF();
            System.out.println("   - FacebookService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + email + "'");

            //Read request from the client
            String password = this.in.readUTF();
            System.out.println("   - FacebookService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + password + "'");

            boolean found = false;
            for (String e : emails) {
                for (String p : passwords) {
                    if (e.equals(email) && p.equals(password)) {
                        System.out.println("Login with Facebook Server completed.");
                        found = true;
                        //Send response
                        this.out.writeBoolean(true);
                    }
                }
            }
            if (!found) {
                System.out.println("Email not found. Login with Google failed.");
            }
        } catch (Exception e) {
            System.out.println("   # FacebookService error" + e.getMessage());
        } finally {
            try {
                tcpSocket.close();
            } catch (Exception e) {
                System.out.println("   # FacebookService closure error:" + e.getMessage());
            }
        }
    }

}