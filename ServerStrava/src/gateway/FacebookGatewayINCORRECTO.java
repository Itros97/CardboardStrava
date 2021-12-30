/*package gateway;

//Son los import que aparecen en Auctions
import java.rmi.Naming;

public class FacebookGatewayFALSO {
    public static FacebookGatewayFALSO instance;
    private IFacebook facebookService;

    private FacebookGatewayFALSO() {
        try {
            //¿Qué URL hay que poner?
            String URL = "";
            this.facebookService = (IFacebook) Naming.lookup(URL);
        } catch (Exception e) {
            System.err.println("# Error locating remote façade: " + e);
        }
    }

    public static FacebookGatewayFALSO getInstance() {
        if (instance == null) {
            instance = new FacebookGatewayFALSO();
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
*/