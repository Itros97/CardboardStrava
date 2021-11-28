package gateway;

//Son los import que aparecen en Auctions
import remote.IFacebook;
import java.rmi.Naming;

public class FacebookGateway {
    public static FacebookGateway instance;
    private IFacebook facebookService;

    private FacebookGateway() {
        try {
            //¿Qué URL hay que poner?
            String URL = "";
            this.facebookService = (IFacebook) Naming.lookup(URL);
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

    public void login() {
        System.out.println("   - Login with Google Gateway");

        try {
            this.facebookService.login();
        } catch (Exception ex) {
            System.out.println("   $ Login error: " + ex.getMessage());
        }
    }

    public void register() {
        System.out.println("   - Register with Google Gateway");

        try {
            this.facebookService.register();
        } catch (Exception ex) {
            System.out.println("   $ Register error: " + ex.getMessage());
        }
    }


}
