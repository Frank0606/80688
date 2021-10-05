package mx.uv;

import static spark.Spark.*;
import com.google.gson.*;

public class App 
{
    public static void main( String[] args )
    {

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
    
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
    
            return "OK";
        });

        get("/log", (req, res) -> {

            return "";
        });

        get("/registro", (req, res) -> {

            return "";
        });

        get("/usuariosRegistrados", (req, res) -> {

            return "";
        });
    }
}
