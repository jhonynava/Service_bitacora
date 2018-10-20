package mx.gob.seguropopulattlax.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import mx.gob.seguropopulartlax.entidades.User;
import mx.gob.seguropopulartlax.servicio.UserServicio;

public class UserJson {
    
    public static String getAllUser(){
        
        JsonArray jsonArray = new JsonArray();
        List<User> users = new UserServicio().getAll();
        users.stream().map((user) -> {
            JsonObject usuario = new JsonObject();
            usuario.addProperty("curp", user.getCurp());
            usuario.addProperty("password", user.getPassword());
            usuario.addProperty("nombre", user.getNombre());
            usuario.addProperty("apaterno", user.getApaterno());
            usuario.addProperty("amaterno", user.getAmaterno());
            return usuario;            
        }).forEachOrdered((usuario) -> {
            jsonArray.add(usuario);
        });
        JsonObject mainObj = new JsonObject();
        mainObj.add("usuarios", jsonArray);
        String user = mainObj.toString();
        return user;
    }
    
    public static String getUser(User users){
        JsonObject usuario = new JsonObject();
        
        usuario.addProperty("curp", users.getCurp());
        usuario.addProperty("password", users.getPassword());
        usuario.addProperty("nombre", users.getNombre());
        usuario.addProperty("apaterno", users.getApaterno());
        usuario.addProperty("amaterno", users.getAmaterno());
        
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(usuario);
            
        JsonObject mainObj = new JsonObject();
        mainObj.add("usuarios", jsonArray);
        String user = mainObj.toString();
        return user;
    }
}
