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
        String e1 = "jaimeamann@opendeusto.es";
        String e2 = "m.lopez.gutierrez@opendeusto.es";
        String e3 = "inigo.tarrino@opendeusto.es";
        String e4 = "mikel.huidobro@opendeusto.es";

        emails.add(e1);
        emails.add(e2);
        emails.add(e3);
        emails.add(e4);

        String p1 = "12345678";
        String p2 = "qwertyui";
        String p3 = "asdfghjk";
        String p4 = "zxcvbnm.";

        passwords.add(p1);
        passwords.add(p2);
        passwords.add(p3);
        passwords.add(p4);

        //Facebook server
        try {
            //Read request from the client
            String email = this.in.readUTF();
            System.out.println("   - FacebookService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + email + "'");

            //Read request from the client
            String password = this.in.readUTF();
            System.out.println("   - FacebookService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + password + "'");

            for (String e : emails) {
                for (String p : passwords) {
                    if (e.equals(email) && p.equals(password)) {
                        System.out.println("Login with Facebook Server completed.");
                        //Send response
                        this.out.writeBoolean(true);
                    }
                }
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