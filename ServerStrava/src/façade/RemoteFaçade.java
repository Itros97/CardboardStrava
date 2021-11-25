package façade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteFaçade extends UnicastRemoteObject implements IRemoteFacade  {
    private static final long serialVersionUID = 1L;
    private static RemoteFacade instance;
    //public User state;

    private RemoteFacade() throws RemoteException {
    }

    public static RemoteFacade getInstance() {
        if (instance == null) {
            try {
                instance = new RemoteFacade();
            } catch (Exception var1) {
                System.err.println("# Error creating RemoteFacade: " + var1);
            }
        }

        return instance;
    }


}
