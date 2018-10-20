package mx.gob.seguropopulartlax.servicio;

import java.util.List;
import mx.gob.seguropopulartlax.dao.VehiculosDao;
import mx.gob.seguropopulartlax.entidades.Vehiculos;

public class VehiculoServicio {
    private final VehiculosDao vehiculosDao;
    
    public VehiculoServicio(){
        vehiculosDao = new VehiculosDao();
    }
    
    public List<Vehiculos> getAll(){
        return vehiculosDao.getAll();
    }
    
    public Vehiculos getVehiculo(String NO_ECONOMICO){
        return vehiculosDao.getVehiculo(NO_ECONOMICO);
    }
    
    public void createVehiculo(String NO_ECONOMICO, String MARCA, String TIPO, int MODELO, int CAPACIDAD_TANQUE,
                int CILINDRAJE, String TIPO_COMBUSTIBLE, String NO_SERIE, String NO_MOTOR, String PLACAS,
                String AREA_RESGUARDANTE, String RESGUARDANTE, Boolean DISPONIBILIDAD, int IMAGEN){
        vehiculosDao.addVehiculo(NO_ECONOMICO, MARCA, TIPO, MODELO, CAPACIDAD_TANQUE, CILINDRAJE, 
                TIPO_COMBUSTIBLE, NO_SERIE, NO_MOTOR, PLACAS, AREA_RESGUARDANTE, RESGUARDANTE, 
                DISPONIBILIDAD, IMAGEN);
    }
    
    public void updateVehiculo(Boolean DISPONIBILIDAD,String NO_ECONOMICO){
        vehiculosDao.updateVehiculo(DISPONIBILIDAD, NO_ECONOMICO);
    }
    
    public void delete(String NO_ECONOMICO){
        vehiculosDao.deleteVehiculo(NO_ECONOMICO);
    }
}
