package gateway;

//Son los import que aparecen en Auctions

import java.rmi.Naming;


public class GoogleGateway {
    public static GoogleGateway instance;
    private IGoogle googleService;

    private GoogleGateway() {
        try {
            //¿Qué URL hay que poner?
            String URL = "";
            this.googleService = (IGoogle) Naming.lookup(URL);
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

    public void login() {
        System.out.println("   - Login with Google Gateway");

        try {
            this.googleService.login();
        } catch (Exception ex) {
            System.out.println("   $ Login error: " + ex.getMessage());
        }
    }

    public void register() {
        System.out.println("   - Register with Google Gateway");

        try {
            this.googleService.register();
        } catch (Exception ex) {
            System.out.println("   $ Register error: " + ex.getMessage());
        }
    }


}
