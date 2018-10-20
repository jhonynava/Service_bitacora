package mx.gob.seguropopulartlax.dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.gob.seguropopulartlax.entidades.User;

public class UserDao {
    
    public List<User> getAll(){
        JsonArray jsonArray = new JsonArray();
        List<User> users = new ArrayList<>();
        
        try{
            try (Connection connection = Dao.conexionBD()) {
                String query = "SELECT * FROM USUARIO";
                
                try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
                    User user;
                    
                    while(rs.next()){
                        user = new User(rs.getString("CURP"), rs.getString("PASSWORD"),
                                rs.getString("NOMBRE"), rs.getString("APATERNO"), rs.getString("AMATERNO"));
                        users.add(user);
                    }
                }
            }
        } catch(SQLException se){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,se);
        }
        
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
        
        return users;
    }
    
    public User get(String CURP, String PASSWORD){
        
        User user = new User();
        try{
            try (Connection connection = Dao.conexionBD()) {
                String query = "SELECT * FROM USUARIO WHERE CURP=? AND PASSWORD=?";
                try (PreparedStatement ps = connection.prepareStatement(query)) {
                    ps.setString(1, CURP);
                    ps.setString(2, PASSWORD);
                    try (ResultSet rs = ps.executeQuery()) {
                        if(rs.next()){
                            user = new User(rs.getString("CURP"), rs.getString("PASSWORD"),
                                    rs.getString("NOMBRE"), rs.getString("APATERNO"), rs.getString("AMATERNO"));
                        }
                    }
                }
            }
        }
        catch(SQLException se){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,se);
        }
        return user;
    }
    
    public void addUser(String CURP, String PASSWORD, String NOMBRE, String APATERNO, String AMATERNO){
        try{
            try (Connection connection = Dao.conexionBD()) {
                String query = "INSERT INTO USUARIO(CURP,PASSWORD, NOMBRE, APATERNO, AMATERNO)"
                        + " VALUES(?,?,?,?,?)";
                try (PreparedStatement ps = connection.prepareStatement(query)) {
                    ps.setString(1, CURP);
                    ps.setString(2, PASSWORD);
                    ps.setString(3, NOMBRE);
                    ps.setString(4, APATERNO);
                    ps.setString(5, AMATERNO);
                    ps.executeUpdate();
                }
            }
            
        }catch(SQLException se){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,se);
        }
    }
    
    public void updateUser(String CURP, String PASSWORD){
        try{
            Connection connection = Dao.conexionBD();
            String query= "UPDATE USUARIO SET PASSWORD =? FROM USUARIO WHERE CURP=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, PASSWORD);
            ps.setString(2, CURP);
            ps.executeUpdate();
        } catch(SQLException se){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,se);
        }
    }
    
    public void deleteUser(String CURP){
        try{
            Connection connection = Dao.conexionBD();
            String query = "DELETE FROM USUARIO WHERE CURP = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, CURP);
            ps.executeUpdate();
        } catch(SQLException e){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}