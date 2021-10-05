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

        before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));

        //**************************************

        get("/saludar", (req, res) -> {

            String usuario = req.queryParams("nombre");
            String password = req.queryParams("password");
            String respuesta;
            System.out.println(usuario + " " + password);

            if(usuario.equals("root") && password.equals("123456")) {
                respuesta = "Bienvenido: ";
            }else{
                respuesta = "Usuario o contraseña equivocada ";
            }

            return respuesta + usuario + "<a href='http://127.0.0.1:5500/index.html'> Volver</a>";
        });

        post("/saludar", (req, res) -> {

            String usuario = req.queryParams("nombre");
            String password = req.queryParams("password");
            String respuesta;
            System.out.println(usuario + " " + password);

            if(usuario.equals("root") && password.equals("123456")) {
                respuesta = "Bienvenido: ";
            }else{
                respuesta = "Usuario o contraseña equivocada ";
            }

            return respuesta + usuario + "<a href='http://127.0.0.1:5500/index.html'> Volver</a>";
        });

        post("/saludarJson", (req, res) -> {

            System.out.println(req.body());

            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticion = arbol.getAsJsonObject();

            Object usuario = peticion.get("firstName");
            System.out.println(usuario + " " + peticion.get("password"));

            JsonObject objectJson = new JsonObject();
            objectJson.addProperty("Usuario", usuario.toString());
            objectJson.addProperty("Access", "granted");
            objectJson.addProperty("Time", "11111111");

            return objectJson;
        });
    }
}
