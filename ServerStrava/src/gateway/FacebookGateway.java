package gateway;

//Son los import que aparecen en Auctions
import remote.IRemoteFacade;
import java.rmi.Naming;

public class FacebookGateway {
    public static FacebookGateway instance;
    private IRemoteFacade façade;

    private FacebookGateway() {
        try {
            //¿Qué URL hay que poner?
            String URL = "";
            this.façade = (IRemoteFacade) Naming.lookup(URL);
        } catch (Exception e) {
            System.err.println("# Error locating remote façade: " + e);
        }
    }

    public static FacebookGateway getInstance() {
        if (instance == null) {
            instance = new FacebookGateway();
        }

        return instance;
    }

//Aqui iran los métodos


}
