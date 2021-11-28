package server;

import remote.FacebookService;
import remote.IFacebook;

import java.rmi.Naming;

public class FacebookServer {
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

        try {
            IFacebook remoteObject = FacebookService.getInstance();
            Naming.rebind(name, remoteObject);
            System.out.println(" * Google Server '" + name + "' started!!");
        } catch (Exception ex) {
            System.out.println(" # Google Server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
