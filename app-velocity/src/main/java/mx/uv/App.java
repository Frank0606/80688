package mx.uv;

import static spark.Spark.*;
import com.google.gson.*;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class App 
{
    public static void main( String[] args )
    {

        staticFiles.location("/");

        // este metodo ya no se logra ejecutar porque se ejecuta primero el location de arriba
        // Por default, abre primero un archivo que se llame index antes que cualquier otro archivo
        get("/", (req, res) -> "Respuesta");
        get("/hola", (req, res) -> "Hola mundo");

        // Redirecciones
        get("/pagina", (req, res) -> {

            res.redirect("estatica.html");
            return null;
        });


        // Hace que la URL no cambie
        // Representan a un archivo renderizandolo, para mantener en anonimo al recurso que se llamo
        get("/estatica", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new VelocityTemplateEngine().render(new ModelAndView(model, "estatica.html"));
        });

        get("/velocity", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "Lo que sea!");
            // Esto hace que pase la llave nombre con valor lo que sea. Pasa a el archivo que ponemos, velocity.vm
            // Pudiendo asi usar esta variable con valor lo que sea
            model.put("apellido", "de tal");
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/velocity.vm"));
        });

        /*get("/usuarios", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("usuarios", usaurios.values());
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/velocity.vm"));
        });*/

    }
}
