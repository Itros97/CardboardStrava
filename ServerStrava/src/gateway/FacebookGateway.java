package gateway;

import data.domain.PasswordProfile;

import java.io.DataOutputStream;
import java.net.Socket;

public class FacebookGateway {

    private static FacebookGateway instance;

    public static FacebookGateway getInstance() {
        if(instance == null) {
            instance = new FacebookGateway();
        }

        return instance;
    }

    if (args.length < 3) {
        System.err.println(" # Usage: TCPSocketClient [SERVER IP] [PORT] [MESSAGE]");
        System.exit(1);
    }
    //args[0] = Server IP
    String serverIP = args[0];
    //args[1] = Server socket port
    int serverPort = Integer.parseInt(args[1]);

    //Se pasan parametros a login y a register
    public boolean login(String email) {
        System.out.println("   - Login with Facebook Gateway");

        //Declaration of the socket to send/receive information to/from the server (an IP and a Port are needed)
        try (Socket socket = new Socket(serverIP, serverPort);
                DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            out.writeUTF(email);
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