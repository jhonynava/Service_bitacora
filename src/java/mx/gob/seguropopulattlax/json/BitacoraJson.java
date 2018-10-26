package mx.gob.seguropopulattlax.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import mx.gob.seguropopulartlax.entidades.Bitacora;
import mx.gob.seguropopulartlax.servicio.BitacoraServicio;

public class BitacoraJson {
    
    public static String getAllBitacora(){
        
        JsonArray jsonArray = new JsonArray();
        List<Bitacora> bitacoras = new BitacoraServicio().getAll();
        bitacoras.stream().map((bitaco) ->{
            JsonObject bitacora = new JsonObject();
            bitacora.addProperty("id_bitacora",bitaco.getId_bitacora());
            SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = sfd.format(bitaco.getFecha());
            bitacora.addProperty("fecha", fecha);
            bitacora.addProperty("kilometraje_inicial", bitaco.getKilometraje_inicial());
            bitacora.addProperty("kilometraje_final", bitaco.getKilometraje_final());
            bitacora.addProperty("importe", bitaco.getImporte());
            bitacora.addProperty("tanque_inicial", bitaco.getTanque_inicial());
            bitacora.addProperty("suministro", bitaco.getSuministro());
            bitacora.addProperty("tanque_final", bitaco.getTanque_final());
            bitacora.addProperty("diferencia", bitaco.getDiferencia());
            bitacora.addProperty("nombre_usuario", bitaco.getFirma());
            bitacora.addProperty("observaciones", bitaco.getObservaciones());
            bitacora.addProperty("no_economico", bitaco.getNo_economico());
            bitacora.addProperty("curp", bitaco.getCurp());
            return bitacora;
        }).forEachOrdered((bitacora)->{
            jsonArray.add(bitacora);
        });
        JsonObject mainObj = new JsonObject();
        mainObj.add("bitacoras", jsonArray);
        String bitacora = mainObj.toString();
        return bitacora;
    }
    
    public static String getAllBitacoraByFecha(String NO_ECONOMICO, Date FECHA_INICIAL, Date FECHA_FINAL){
        
        JsonArray jsonArray = new JsonArray();
        List<Bitacora> bitacoras = new BitacoraServicio().getBitacorabyFecha(NO_ECONOMICO, FECHA_INICIAL, FECHA_FINAL);
        
       bitacoras.stream().map((bitaco) ->{
            JsonObject bitacora = new JsonObject();
            bitacora.addProperty("id_bitacora",bitaco.getId_bitacora());
            SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = sfd.format(bitaco.getFecha());
            bitacora.addProperty("fecha", fecha);
            bitacora.addProperty("kilometraje_inicial", bitaco.getKilometraje_inicial());
            bitacora.addProperty("kilometraje_final", bitaco.getKilometraje_final());
            bitacora.addProperty("importe", bitaco.getImporte());
            bitacora.addProperty("tanque_inicial", bitaco.getTanque_inicial());
            bitacora.addProperty("suministro", bitaco.getSuministro());
            bitacora.addProperty("tanque_final", bitaco.getTanque_final());
            bitacora.addProperty("diferencia", bitaco.getDiferencia());
            bitacora.addProperty("nombre_usuario", bitaco.getFirma());
            bitacora.addProperty("observaciones", bitaco.getObservaciones());
            bitacora.addProperty("no_economico", bitaco.getNo_economico());
            bitacora.addProperty("curp", bitaco.getCurp());
            return bitacora;
        }).forEachOrdered((bitacora)->{
            jsonArray.add(bitacora);
        });
        JsonObject mainObj = new JsonObject();
        mainObj.add("bitacoras", jsonArray);
        String bitacoraTexto = mainObj.toString();
        return bitacoraTexto;
    }
}
