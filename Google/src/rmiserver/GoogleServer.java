package rmiserver;

import rmiremote.GoogleService;
import rmiremote.IGoogle;

import java.rmi.Naming;

public class GoogleServer {
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

        try {
            IGoogle serviceObject = GoogleService.getInstance();
            Naming.rebind(name, serviceObject);
            System.out.println("* Server '" + name + "' active and waiting...");
        } catch (Exception e) {
            System.err.println("- Exception running the server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
