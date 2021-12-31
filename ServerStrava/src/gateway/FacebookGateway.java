package gateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class FacebookGateway {

    private static FacebookGateway instance;
    //El puerto creo que esta bien escrito, pero no estoy seguro de si la IP se escribe asi
    String serverIP = "127.0.0.1";
    int serverPort = 8001;

    public static FacebookGateway getInstance() {
        if(instance == null) {
            instance = new FacebookGateway();
        }

        return instance;
    }

    //Se pasan parametros a login y a register
    public boolean login(String email, String password) {
        System.out.println("   - Login with Facebook Gateway");

        //Declaration of the socket to send/receive information to/from the server (an IP and a Port are needed)
        try (Socket socket = new Socket(serverIP, serverPort);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            //Send email to the server
            out.writeUTF(email);
            //Send password to the server
            out.writeUTF(password);
        } catch (Exception e) {
            System.out.println("   $ Socket Login error: " + e.getMessage());
            return false;
        }
        return true;
    }

    //ANTIGUO
    /*
    public void register(PasswordProfile pp) {
        System.out.println("   - Register with Facebook Gateway");

        try (Socket socket = new Socket(serverIP, serverPort) {
            socket.register(pp.getEmail(), pp.getNickname(), pp.getBirthdate(), pp.getWeightKg(), pp.getHeightCm(), pp.getReposeHeartRate(), pp.getMaximumHeartRate(), pp.getRegisterType());
        } catch (Exception e) {
            System.out.println("   $ Register error: " + e.getMessage());
        }
    }*/
}