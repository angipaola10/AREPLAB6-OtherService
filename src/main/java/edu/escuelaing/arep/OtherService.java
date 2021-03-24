package edu.escuelaing.arep;

import static spark.Spark.*;

public class OtherService {

    public static void main(String[] args){

        port(getPort());
        staticFileLocation("/");
        secure("keystore/arepkeystore.p12", "123456", "keystore/myTrustStore", "654321");

        get("/otherService", (req, res) -> {
            return "Hello from Other Service!";
        });

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001;
    }

}
