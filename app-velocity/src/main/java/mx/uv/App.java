package mx.uv;
import mx.uv.Datos.Usuario;

import static spark.Spark.*;
import com.google.gson.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class App 
{
    private static Gson gson = new Gson();
    private static Map<String, Usuario> usuarios = new HashMap<>();

    public static void main( String[] args )
    {
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

        // este metodo ya no se logra ejecutar porque se ejecuta primero el location de arriba
        // Por default, abre primero un archivo que se llame index antes que cualquier otro archivo

        // Cuando se ejecuta en forma de jar, se ejecuta por determinado este get, ya no el static file
        //get("/", (req, res) -> "Respuesta");
        get("/", (req, res) -> {
            
            Map<String, Object> model = new HashMap<>();
            return new VelocityTemplateEngine().render(new ModelAndView(model, "index.html"));

        });

        get("/hola", (req, res) -> "Hola mundo");

        // Redirecciones
        get("/pagina", (req, res) -> {

            res.redirect("estatica.html");
            return null;
        });

        post("/usuario", (req, res) -> {
            String payload = req.body();
            String id = UUID.randomUUID().toString();
            Usuario u = gson.fromJson(payload, Usuario.class);
            u.setId(id);
            usuarios.put(id, u);

            JsonObject objetoJson = new JsonObject();
            objetoJson.addProperty("status", "ok");
            objetoJson.addProperty("id", id);
            return objetoJson;
        });

        // Hace que la URL no cambie
        // Representan a un archivo renderizandolo, para mantener en anonimo al recurso que se llamo
        get("/estatica", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new VelocityTemplateEngine().render(new ModelAndView(model, "estatica.html"));
        });

        // do this
        get("/velocity", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "lo que sea!");
            model.put("apellido", "de tal!");
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/velocity.vm"));
        });

        // do this
        get("/usuarios", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("usuarios", usuarios.values());
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/velocity.vm"));
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
