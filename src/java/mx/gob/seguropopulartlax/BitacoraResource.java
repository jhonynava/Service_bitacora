package mx.gob.seguropopulartlax;

import com.google.gson.Gson;
import java.sql.Date;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mx.gob.seguropopulartlax.entidades.Bitacora;
import mx.gob.seguropopulartlax.servicio.BitacoraServicio;
import mx.gob.seguropopulattlax.json.BitacoraJson;

/**
 * REST Web Service
 *
 * @author Desarrollo
 */
@Path("bitacora")
public class BitacoraResource {

    @Context
    private UriInfo context;

    public BitacoraResource() {
    }

    /**
     * Retrieves representation of an instance of mx.gob.seguropopulartlax.BitacoraResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBitacora(){
        try{
            String bitacoraToJson = BitacoraJson.getAllBitacora();
            return Response.ok(bitacoraToJson, MediaType.APPLICATION_JSON).build();
            
        } catch(Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + ex.toString()).build();
        }
    }
    
    @GET
    @Path("fecha")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBitacoraByFecha(@QueryParam("NO_ECONOMICO")String NO_ECONOMICO, @QueryParam("FECHA_INICIAL")Date FECHA_INICIAL, @QueryParam("FECHA_FINAL")Date FECHA_FINAL){
        try{
            String bitacoraToJsonByFecha = BitacoraJson.getAllBitacoraByFecha(NO_ECONOMICO, FECHA_INICIAL, FECHA_FINAL);
            return Response.ok(bitacoraToJsonByFecha, MediaType.APPLICATION_JSON).build();
        }catch(Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + ex.toString()).build();
        }
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBitacora(@QueryParam("ID_BITACORA")String ID_BITACORA, @QueryParam("FECHA") Date FECHA, @QueryParam("KILOMETRAJE_INICIAL")Float KILOMETRAJE_INICIAL, 
            @QueryParam("KILOMETRAJE_FINAL")Float KILOMETRAJE_FINAL, @QueryParam("IMPORTE")Float IMPORTE, 
            @QueryParam("TANQUE_INICIAL")Float TANQUE_INICIAL, @QueryParam("SUMINISTRO")Float SUMINISTRO, 
            @QueryParam("TANQUE_FINAL")Float TANQUE_FINAL, @QueryParam("DIFERENCIA")Float DIFERENCIA,@QueryParam("RECORRIDO") String RECORRIDO, 
            @QueryParam("NOMBRE_USUARIO")String NOMBRE_USUARIO, @QueryParam("FIRMA") int FIRMA, @QueryParam("OBSERVACIONES")String OBSERVACIONES, 
            @QueryParam("NO_ECONOMICO")String NO_ECONOMICO, @QueryParam("CURP")String CURP){
        try{
            BitacoraServicio bitacoraServicio = new  BitacoraServicio();
            bitacoraServicio.create(ID_BITACORA, FECHA, KILOMETRAJE_INICIAL, KILOMETRAJE_FINAL, IMPORTE, TANQUE_INICIAL, 
                    SUMINISTRO, TANQUE_FINAL, DIFERENCIA, RECORRIDO, NOMBRE_USUARIO, FIRMA, OBSERVACIONES, NO_ECONOMICO, CURP);
            
             String json = "Agregado correctamente";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + ex.toString()).build();
        }
    }
}