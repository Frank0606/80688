package mx.uv;

import static spark.Spark.*;

//import java.util.Map;

import com.google.gson.*;

public class App 
{
    public static void main( String[] args ) {

        port(getHerokuAssignedPort());
        staticFiles.location("/");

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

        JsonObject objectsJson[] = new JsonObject[2];
        //
        int contadores[] = new int[2];
        int contadores2[] = new int[2];
        contadores[0] = 0;
        contadores2[0] = 0;

        get("/", (req, res) -> {
            res.redirect("logeo.html");
            return null;
        });

        post("/logearUsuario", (req, res) -> {

            String usuario = req.queryParams("Usuario");
            String contraseña = req.queryParams("Contraseña");
            String usuarioR, contraseñaR, respuesta = "0";

            for(int i=0; i<2; i++) {

                usuarioR = objectsJson[i].get("Usuario").getAsString();
                contraseñaR = objectsJson[i].get("Contraseña").getAsString();
                
                if(usuario.equals(usuarioR) && contraseña.equals(contraseñaR)) {

                    respuesta = "Usuario valido. Bienvenido " + usuario;
                    break;

                }

            }

            return respuesta;

        });

        post("/registrarUsuarios", (req, res) -> {
            
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticion = arbol.getAsJsonObject();

            Object usuario = peticion.get("usuario");
            Object password = peticion.get("contraseña");

            JsonObject objectJson = new JsonObject();
            objectJson.addProperty("Usuario", usuario.toString().replace("\"", ""));
            objectJson.addProperty("Contraseña", password.toString().replace("\"", ""));

            objectsJson[contadores[0]] = objectJson;
            contadores[0] = contadores[0] + 1;

            return objectJson;
        });

        post("/usuariosRegistrados", (req, res) -> {

            JsonObject objectJson[] = new JsonObject[2];

            for(int i = 0; i<2; i++){
                
                objectJson[i] = objectsJson[i];

            }

            return "Aun no puedo :(";

        });
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
