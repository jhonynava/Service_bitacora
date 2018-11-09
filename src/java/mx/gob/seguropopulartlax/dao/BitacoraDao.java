package mx.gob.seguropopulartlax.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.gob.seguropopulartlax.entidades.Bitacora;

public class BitacoraDao {
    
    public List<Bitacora> getAll(){
        List<Bitacora> bitacoras =  new ArrayList<>();
        
        try{
            try(Connection connection = Dao.conexionBD()){
                String query = "SELECT * FROM BITACORA";
                try(PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery() ){
                    Bitacora bitacora;
                    
                    while(rs.next()){
                        bitacora = new Bitacora(rs.getInt("ID_BITACORA"),rs.getDate("FECHA"), 
                                rs.getFloat("KILOMETRAJE_INICIAL"), rs.getFloat("KILOMETRAJE_FINAL"), 
                                rs.getFloat("IMPORTE"), rs.getString("TANQUE_INICIAL"),
                                rs.getFloat("SUMINISTRO"), rs.getString("TANQUE_FINAL"),
                                rs.getFloat("DIFERENCIA"), rs.getString("RECORRIDO"), 
                                rs.getString("NOMBRE_USUARIO"), rs.getInt("FIRMA"), 
                                rs.getString("OBSERVACIONES"), rs.getString("NO_ECONOMICO"), 
                                rs.getString("CURP"));
                        
                        bitacoras.add(bitacora);
                    }
                }
            }
        } catch(SQLException e){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,e);
        }
        return bitacoras;
    }
    
    public List<Bitacora> getBitacorabyFecha(String NO_ECONOMICO, Date FECHA_INICIAL, Date FECHA_FINAL){
        List<Bitacora> bitacoras =  new ArrayList<>();
        
        try{ 
            try(Connection connection = Dao.conexionBD()){
                Bitacora bitacora;
                
                String query = "SELECT * FROM BITACORA WHERE FECHA BETWEEN ? AND ? AND NO_ECONOMICO=?";
                
                PreparedStatement ps = connection.prepareStatement(query); 
                ps.setDate(1, FECHA_INICIAL);
                ps.setDate(2, FECHA_FINAL);
                ps.setString(3, NO_ECONOMICO);
                ResultSet rs = ps.executeQuery();
                    
                while(rs.next()){
                    bitacora = new Bitacora(rs.getInt("ID_BITACORA"),rs.getDate("FECHA"), 
                        rs.getFloat("KILOMETRAJE_INICIAL"), rs.getFloat("KILOMETRAJE_FINAL"), 
                        rs.getFloat("IMPORTE"), rs.getString("TANQUE_INICIAL"),
                        rs.getFloat("SUMINISTRO"), rs.getString("TANQUE_FINAL"),
                        rs.getFloat("DIFERENCIA"), rs.getString("RECORRIDO"), 
                        rs.getString("NOMBRE_USUARIO"), rs.getInt("FIRMA"), 
                        rs.getString("OBSERVACIONES"), rs.getString("NO_ECONOMICO"), 
                        rs.getString("CURP"));   
                    bitacoras.add(bitacora);
                }
            }
            
        } catch(SQLException e){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,e);
        }
        return bitacoras;
    }
    
    public void addBitacora(String ID_BITACORA, Date FECHA, Float KILOMETRAJE_INICIAL, Float KILOMETRAJE_FINAL,
            Float IMPORTE, String TANQUE_INICIAL, Float SUMINISTRO, String TANQUE_FINAL, Float DIFERENCIA, 
            String RECORRIDO, String NOMBRE_USUARIO, int FIRMA, String OBSERVACIONES, String NO_ECONOMICO, String CURP){
        try{
            try(Connection connection = Dao.conexionBD()){
                String query = "INSERT INTO BITACORA (FECHA, KILOMETRAJE_INICIAL, KILOMETRAJE_FINAL,IMPORTE, TANQUE_INICIAL, "
                        + "SUMINISTRO, TANQUE_FINAL, DIFERENCIA, RECORRIDO, NOMBRE_USUARIO, FIRMA, OBSERVACIONES, NO_ECONOMICO, "
                        + "CURP) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try(PreparedStatement ps = connection.prepareStatement(query)){
                    ps.setDate(1, FECHA);
                    ps.setFloat(2, KILOMETRAJE_INICIAL);
                    ps.setFloat(3, KILOMETRAJE_FINAL);
                    ps.setFloat(4, IMPORTE);
                    ps.setString(5, TANQUE_INICIAL.replace("-", "/"));
                    ps.setFloat(6, SUMINISTRO);
                    ps.setString(7, TANQUE_FINAL.replace("-", "/"));
                    ps.setFloat(8, DIFERENCIA);
                    ps.setString(9, RECORRIDO);
                    ps.setString(10, NOMBRE_USUARIO);
                    ps.setInt(11, FIRMA);
                    ps.setString(12, OBSERVACIONES);
                    ps.setString(13, NO_ECONOMICO);
                    ps.setString(14, CURP);
                    ps.executeUpdate();
                }
            }
        } catch(SQLException e){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
