package mx.gob.seguropopulattlax.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import mx.gob.seguropopulartlax.entidades.Vehiculos;
import mx.gob.seguropopulartlax.servicio.VehiculoServicio;

public class VehiculoJson {
    
    public static String getAllVehiculos(){
        
        JsonArray jsonArray = new JsonArray();
        List<Vehiculos> vehiculos = new VehiculoServicio().getAll();
        vehiculos.stream().map((vehi) ->{
            JsonObject vehiculo =  new JsonObject();
            vehiculo.addProperty("no_economico", vehi.getNo_economico());
            vehiculo.addProperty("marca", vehi.getMarca());
            vehiculo.addProperty("tipo", vehi.getTipo());
            vehiculo.addProperty("modelo", vehi.getModelo());
            vehiculo.addProperty("capacidad_tanque", vehi.getCapacidad_tanque());
            vehiculo.addProperty("cilindraje", vehi.getCilindraje());
            vehiculo.addProperty("tipo_combustible", vehi.getTipo_combustible());
            vehiculo.addProperty("no_serie", vehi.getNo_serie());
            vehiculo.addProperty("no_motor", vehi.getNo_motor());
            vehiculo.addProperty("placas", vehi.getPlacas());
            vehiculo.addProperty("area_resguardante", vehi.getArea_resguardante());
            vehiculo.addProperty("resguardante", vehi.getResguardante());
            vehiculo.addProperty("disponibilidad", vehi.isDisponibilidad());
            vehiculo.addProperty("imagen", vehi.getImagen());
            return vehiculo;
        }).forEachOrdered((vehiculo) ->{
            jsonArray.add(vehiculo);
        });
        JsonObject mainObj = new JsonObject();
        mainObj.add("vehiculos", jsonArray);
        String vehiculo = mainObj.toString();
        return vehiculo;
    }
    
    public static String getVehiculo(Vehiculos vehiculos){
        JsonObject vehiculo = new JsonObject();
        vehiculo.addProperty("no_economico", vehiculos.getNo_economico());
        vehiculo.addProperty("marca", vehiculos.getMarca());
        vehiculo.addProperty("tipo", vehiculos.getTipo());
        vehiculo.addProperty("modelo", vehiculos.getModelo());
        vehiculo.addProperty("capacidad_tanque", vehiculos.getCapacidad_tanque());
        vehiculo.addProperty("cilindraje", vehiculos.getCilindraje());
        vehiculo.addProperty("tipo_combustible", vehiculos.getTipo_combustible());
        vehiculo.addProperty("no_serie", vehiculos.getNo_serie());
        vehiculo.addProperty("no_motor", vehiculos.getNo_motor());
        vehiculo.addProperty("placas", vehiculos.getPlacas());
        vehiculo.addProperty("area_resguardante", vehiculos.getArea_resguardante());
        vehiculo.addProperty("resguardante", vehiculos.getResguardante());
        vehiculo.addProperty("disponibilidad", vehiculos.isDisponibilidad());
        vehiculo.addProperty("imagen", vehiculos.getImagen());
        
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(vehiculo);
                
        JsonObject mainOnj = new JsonObject();
        mainOnj.add("vehiculos", jsonArray);
        String vehi = mainOnj.toString();
        return vehi;
    }
}
