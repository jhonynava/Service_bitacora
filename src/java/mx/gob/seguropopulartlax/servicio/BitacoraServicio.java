package mx.gob.seguropopulartlax.servicio;

import java.sql.Date;
import java.util.List;
import mx.gob.seguropopulartlax.dao.BitacoraDao;
import mx.gob.seguropopulartlax.entidades.Bitacora;

public class BitacoraServicio {
    
    private final BitacoraDao bitacoraDao;
    
    public BitacoraServicio(){
        bitacoraDao = new BitacoraDao();
    }
    
    public List<Bitacora> getAll(){
        return bitacoraDao.getAll();
    }
    
    public List<Bitacora> getBitacorabyFecha(String NO_ECONOMICO, Date FECHA_INICIAL, Date FECHA_FINAL){
        return bitacoraDao.getBitacorabyFecha(NO_ECONOMICO, FECHA_INICIAL, FECHA_FINAL);
    }
    
    public void create(String ID_BITACORA, Date FECHA, Float KILOMETRAJE_INICIAL, Float KILOMETRAJE_FINAL,
            Float IMPORTE, Float TANQUE_INICIAL, Float SUMINISTRO, Float TANQUE_FINAL, Float DIFERENCIA, 
            String RECORRIDO, String NOMBRE_USUARIO, int FIRMA, String OBSERVACIONES, String NO_ECONOMICO, String CURP){
        
        bitacoraDao.addBitacora(ID_BITACORA, FECHA, KILOMETRAJE_INICIAL, KILOMETRAJE_FINAL, IMPORTE, TANQUE_INICIAL, 
                SUMINISTRO, TANQUE_FINAL, DIFERENCIA, RECORRIDO, NOMBRE_USUARIO, FIRMA, OBSERVACIONES, NO_ECONOMICO, CURP);
    }
}
