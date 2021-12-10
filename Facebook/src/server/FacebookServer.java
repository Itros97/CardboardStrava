/*package server;

import remote.FacebookService;

import java.net.ServerSocket;

public class FacebookServer {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println(" # Usage: TCPSocketEchoServer [PORT]");
            System.exit(1);
        }

        //args[1] = Server socket port
        int serverPort = Integer.parseInt(args[0]);

        //Declaration of the ServerSocket (only a port number is needed)
        try (ServerSocket tcpFacebookServerSocket = new ServerSocket(serverPort);) {
            System.out.println(" - FacebookServer: Waiting for connections '" + tcpFacebookServerSocket.getInetAddress().getHostAddress() + ":" + tcpFacebookServerSocket.getLocalPort() + "' ...");

            //The main thread is always waiting for connections
            while (true) {
                //When a connection from a client is received, a new EchoService is created. The "accept()" method returns the socket to
                //communicate with the client.
                new FacebookService(tcpFacebookServerSocket.accept());
                System.out.println(" - FacebookServer: New client connection accepted. Client Number: " + numClients++);
            }
        } catch (Exception e) {
            System.out.println("# FacebookServer: IO error:" + e.getMessage());
        }

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
*/