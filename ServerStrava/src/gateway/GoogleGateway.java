package gateway;

//Son los import que aparecen en Auctions
import remote.IRemoteFacade;
import java.rmi.Naming;

public class GoogleGateway {
    public static GoogleGateway instance;
    private IRemoteFacade façade;

    private GoogleGateway() {
        try {
            //¿Qué URL hay que poner?
            String URL = "";
            this.façade = (IRemoteFacade) Naming.lookup(URL);
        } catch (Exception e) {
            System.err.println("# Error locating remote façade: " + e);
        }
    }

    public static GoogleGateway getInstance() {
        if(instance == null) {
            instance = new GoogleGateway();
        }

        return instance;
    }

    //Aqui iran los métodos

}
