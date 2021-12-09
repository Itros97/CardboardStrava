package rmiserver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GoogleServer extends UnicastRemoteObject implements IGoogle {
    private static final long serialVersionUID = 1L;
    private int cont = 0;

    protected GoogleServer() throws RemoteException {
        super();
    }

    public void login() throws RemoteException {

    }

    public void register() throws RemoteException {

    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("usage: java [policy] [codebase] rmiserver.GoogleServer [ip] [port] [name]");
            System.exit(0);
        }

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

        try {
            IGoogle serviceObject = new GoogleServer();
            Naming.rebind(name, serviceObject);
            System.out.println("* Server '" + name + "' active and waiting...");
        } catch (Exception e) {
            System.err.println("- Exception running the server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
