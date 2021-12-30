package gateway;

import rmiremote.IGoogle;

import java.rmi.Naming;

public class GoogleGateway {

    private static GoogleGateway instance;
    private IGoogle googleService;

    private GoogleGateway() {
        try {
            String URL = "//127.0.0.1:1099/Google";
            this.googleService = (IGoogle) Naming.lookup(URL);
        } catch (Exception ex) {
            System.err.println("# Error locating remote facade: " + ex);
        }
    }

    public static GoogleGateway getInstance() {
        if(instance == null) {
            instance = new GoogleGateway();
        }

        return instance;
    }

    //Se pasan parametros a login y a register
    public boolean login(String email) {
        System.out.println("   - Login with Google Gateway");

        try {
            return this.googleService.login(email);
        } catch (Exception ex) {
            System.out.println("   $ Login error: " + ex.getMessage());
            return false;
        }
    }

    //ANTIGUO
    /*public void register(PasswordProfile pp) {
        System.out.println("   - Register with Google Gateway");

        try {
            this.googleService.register(pp.getEmail(), pp.getNickname(), pp.getBirthdate(), pp.getWeightKg(), pp.getHeightCm(), pp.getReposeHeartRate(), pp.getMaximumHeartRate(), pp.getRegisterType());
        } catch (Exception ex) {
            System.out.println("   $ Register error: " + ex.getMessage());
        }
    }*/

}