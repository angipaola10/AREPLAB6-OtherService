package edu.escuelaing.arep;

import static spark.Spark.*;

/**
 * Service that offers a endpoint to login service.
 */
public class OtherService {

    /**
     * Main method that start the server.
     *
     * @param args the args of the main method
     */
    public static void main(String[] args){

        port(getPort());
        staticFileLocation("/");
        secure("keystore/arepkeystore.p12", "123456", "keystore/myTrustStore", "654321");

        get("/otherService", (req, res) -> {
            return "Hello from Other Service!";
        });

    }

    /**
     * Gets port of server.
     *
     * @return the port of server
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001;
    }

}
