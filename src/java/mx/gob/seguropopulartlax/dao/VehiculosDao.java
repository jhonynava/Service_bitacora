package mx.gob.seguropopulartlax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.gob.seguropopulartlax.entidades.Vehiculos;


public class VehiculosDao {
    
    public List<Vehiculos> getAll(){
        List<Vehiculos> vehiculos = new ArrayList<>();
        
        try{
            try (Connection connection = Dao.conexionBD()) {
                String query = "SELECT * FROM VEHICULO";
                
                try (PreparedStatement ps = connection.prepareStatement(query); 
                        ResultSet rs = ps.executeQuery()) {
                    Vehiculos vehiculo;
                    
                    while(rs.next()){
                        vehiculo = new Vehiculos(rs.getString("NO_ECONOMICO"),
                                rs.getString("MARCA"), rs.getString("TIPO"),
                                rs.getInt("MODELO"), rs.getInt("CAPACIDAD_TANQUE"),
                                rs.getInt("CILINDRAJE"), rs.getString("TIPO_COMBUSTIBLE"),
                                rs.getString("NO_SERIE"), rs.getString("NO_MOTOR"),
                                rs.getString("PLACAS"), rs.getString("AREA_RESGUARDANTE"),
                                rs.getString("RESGUARDANTE"), rs.getBoolean("DISPONIBILIDAD"),
                                rs.getInt("IMAGEN"));
                        vehiculos.add(vehiculo);
                    }
                }
            }
            
        } catch(SQLException e){
            Logger.getLogger(VehiculosDao.class.getName()).log(Level.SEVERE,null,e);
        }
        return vehiculos;
    }
    
    public Vehiculos getVehiculo(String NO_ECONOMICO){
        Vehiculos vehiculo = new Vehiculos();
        try{
            try(Connection connection = Dao.conexionBD()){
                String query = "SELECT * FROM VEHICULO WHERE NO_ECONOMICO =?";
                try(PreparedStatement ps = connection.prepareStatement(query)){
                    ps.setString(1, NO_ECONOMICO);
                    try(ResultSet rs= ps.executeQuery()){
                        if(rs.next())
                            vehiculo = new Vehiculos(rs.getString("NO_ECONOMICO"),
                                rs.getString("MARCA"), rs.getString("TIPO"),
                                rs.getInt("MODELO"), rs.getInt("CAPACIDAD_TANQUE"),
                                rs.getInt("CILINDRAJE"), rs.getString("TIPO_COMBUSTIBLE"),
                                rs.getString("NO_SERIE"), rs.getString("NO_MOTOR"),
                                rs.getString("PLACAS"), rs.getString("AREA_RESGUARDANTE"),
                                rs.getString("RESGUARDANTE"), rs.getBoolean("DISPONIBILIDAD"),
                                rs.getInt("IMAGEN"));
                    }
                }
            }
        } catch(SQLException e){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,e);
        }
        return vehiculo;
    }
    
    public void addVehiculo(String NO_ECONOMICO, String MARCA, String TIPO, int MODELO, int CAPACIDAD_TANQUE,
                int CILINDRAJE, String TIPO_COMBUSTIBLE, String NO_SERIE, String NO_MOTOR, String PLACAS,
                String AREA_RESGUARDANTE, String RESGUARDANTE, Boolean DISPONIBILIDAD, int IMAGEN){
        try{
            try(Connection connection = Dao.conexionBD()){
                String query = "INSERT INTO VEHICULO " 
                    + "(NO_ECONOMICO, MARCA, TIPO, MODELO, CAPACIDAD_TANQUE, "
                    + "CILINDRAJE, TIPO_COMBUSTIBLE, NO_SERIE, NO_MOTOR, PLACAS, "
                    + "AREA_RESGUARDANTE, RESGUARDANTE, DISPONIBILIDAD, IMAGEN) " 
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                try(PreparedStatement ps = connection.prepareStatement(query)){
                    ps.setString(1, NO_ECONOMICO);
                    ps.setString(2, MARCA);
                    ps.setString(3, TIPO);
                    ps.setInt(4, MODELO);
                    ps.setInt(5, CAPACIDAD_TANQUE);
                    ps.setInt(6, CILINDRAJE);
                    ps.setString(7, TIPO_COMBUSTIBLE);
                    ps.setString(8, NO_SERIE);
                    ps.setString(9, NO_MOTOR);
                    ps.setString(10, PLACAS);
                    ps.setString(11, AREA_RESGUARDANTE);
                    ps.setString(12, RESGUARDANTE);
                    ps.setBoolean(13, DISPONIBILIDAD);
                    ps.setInt(14, IMAGEN);
                    ps.executeUpdate();
                }
            }
        } catch(SQLException e){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    public void updateVehiculo(Boolean DISPONIBILIDAD, String NO_ECONOMICO){
        try{
            Connection connection = Dao.conexionBD();
            String query = "UPDATE VEHICULO SET DISPONIBILIDAD=? "
                + "FROM VEHICULO WHERE NO_ECONOMICO=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setBoolean(1, DISPONIBILIDAD);
            ps.setString(2, NO_ECONOMICO);
            ps.executeUpdate();
        } catch(SQLException e){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    public void deleteVehiculo(String NO_ECONOMICO){
        try{
            Connection connection = Dao.conexionBD();
            String query = "DELETE FROM VEHICULO WHERE NO_ECONOMICO = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, NO_ECONOMICO);
            ps.executeUpdate();
        } catch(SQLException e){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}