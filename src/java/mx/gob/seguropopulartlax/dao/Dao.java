package mx.gob.seguropopulartlax.dao;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dao {

    private static Connection conexion = null;

    public static Connection conexionBD() {
        
        String userName ="sa";
        String password ="$4p2k17";
        
        String connectionUrl = "jdbc:sqlserver://187.237.97.179:1433;" +
			"databaseName=Vitacora_vehicular;";
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(connectionUrl,userName,password);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
}
