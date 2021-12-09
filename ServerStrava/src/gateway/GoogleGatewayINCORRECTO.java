/*package gateway;

import rmiserver.IGoogle;

public class GoogleGatewayFALSO {

    private GoogleGatewayFALSO() {
        if (args.length != 3) {
            System.out.println("uso: java [policy] [codebase] es.deusto.ingenieria.sd.rmi.Client [ip] [port] [name]");
            System.exit(0);
        }

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
            IGoogle serviceStub = (IGoogle) java.rmi.Naming.lookup(name);
            System.out.println("* Message comming from the server: '" + serviceStub.sayHello() + "'");
        } catch (Exception e) {
            System.err.println("- Exception running the client: " + e.getMessage());
            e.printStackTrace();
        }
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

}*/