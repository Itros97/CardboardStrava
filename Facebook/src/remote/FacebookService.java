package remote;

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

    public void login() {
        //Facebook server
        try {
            //Read request from the client
            String email = this.in.readUTF();
            System.out.println("   - FacebookService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + email + "'");

            //AQUI TIENE QUE IR LA CONEXION CON EL SERVICIO EXTERNO

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

}