

import java.net.InetSocketAddress;                  // package for socket
import java.net.InetAddress;                        // package for IP address
import com.sun.net.httpserver.HttpServer;           // server package
import java.io.IOException;                         // package to implement the exception

public class Server {

    public static void main(String args[]) throws IOException {

        int port = 9000;                                                              // initializing the port#
        InetAddress localhost = InetAddress.getLocalHost();                          // getting the ip address of server
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);      // creating server object using http
        System.out.println("IP address: " + (localhost.getHostAddress()).trim());
        System.out.println("Port#: " + port);
        System.out.println("Server has started successfully");
        server.createContext("/", new HandlerClass());                              // creating the context so handler class can take requests
        server.createContext("/echoHeader", new EchoHeaderHandler());

        server.start();                                                             // running the server        
        
    }
  
}



