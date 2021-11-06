package mx.uv;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import mx.uv.bd.*;

public class App {

    private static Gson gson = new Gson();
    private static Map<String, usuario> usuarios = new HashMap<>();
    
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

        //--------------------------------------------------------

        get("/usuarios", (req, res)-> {
            before((rq,rs)-> rs.type("application/json"));
            DAO dao = new DAO();
            return gson.toJson(dao.listaUsuario());
        });

        post("/usuario", (req, res) -> {
            String payload = req.body();
            String id = UUID.randomUUID().toString();
            usuario u = gson.fromJson(payload, usuario.class);
            u.setId(id);

            DAO dao = new DAO();

            JsonObject objetoJson = new JsonObject();
            objetoJson.addProperty("status", dao.crearUsuario(u));
            objetoJson.addProperty("id", id);

            return objetoJson;
        });

        post("/actualizar", (req, res) -> {

            DAO dao = new DAO();
            String payload = req.body();
            usuario u = gson.fromJson(payload, usuario.class);
            
            JsonObject objetoJson = new JsonObject();
            objetoJson.addProperty("status", dao.actualizarUsuario(u));
            objetoJson.addProperty("id", u.getId());

            return objetoJson;
        });

        post("/eliminar", (req, res) -> {

            DAO dao = new DAO();
            String payload = req.body();
            usuario u = gson.fromJson(payload, usuario.class);

            JsonObject objetoJson = new JsonObject();
            objetoJson.addProperty("status", dao.eliminarUsuario(u.getId()));
            objetoJson.addProperty("id", u.getId());

            return objetoJson;
        });

    }
}
