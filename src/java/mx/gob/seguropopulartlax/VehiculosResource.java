package mx.gob.seguropopulartlax;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mx.gob.seguropopulartlax.entidades.Vehiculos;
import mx.gob.seguropopulartlax.servicio.VehiculoServicio;

/**
 * REST Web Service
 *
 * @author Jhoncode
 */
@Path("vehiculos")
public class VehiculosResource {

    @Context
    private UriInfo context;

    public VehiculosResource() {
    }

    /**
     * Retrieves representation of an instance of mx.gob.seguropopulartlax.VehiculosResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllVehiculos() {
        try{
            List<Vehiculos> vehiculos = new VehiculoServicio().getAll();
            String json = new Gson().toJson(vehiculos);
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + ex.toString()).build();
        }
    }
    
    @GET
    @Path("getVehiculo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVehiculo(@QueryParam("NO_ECONOMICO")String NO_ECONOMICO){
        try{
            Vehiculos vehiculos = new VehiculoServicio().getVehiculo(NO_ECONOMICO);
            String json = new Gson().toJson(vehiculos);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + ex.toString()).build();
        }
    }
    
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addVehiculo(@QueryParam("NO_ECONOMICO") String NO_ECONOMICO, @QueryParam("MARCA") String MARCA, 
        @QueryParam("TIPO") String TIPO,@QueryParam("MODELO") int MODELO, @QueryParam("CAPACIDAD_TANQUE") int CAPACIDAD_TANQUE,
        @QueryParam("CILINDRAJE") String CILINDRAJE, @QueryParam("TIPO_COMBUSTIBLE") String TIPO_COMBUSTIBLE,
        @QueryParam("NO_SERIE") String NO_SERIE, @QueryParam("NO_MOTOR") String NO_MOTOR, @QueryParam("PLACAS") String PLACAS,
        @QueryParam("AREA_RESGUARDANTE") String AREA_RESGUARDANTE, @QueryParam("RESGUARDANTE") String RESGUARDANTE, 
        @QueryParam("DISPONIBILIDAD") Boolean DISPONIBILIDAD, @QueryParam("IMAGEN") int IMAGEN){
        
        try{
            VehiculoServicio vehiculoServicio =  new VehiculoServicio();
            vehiculoServicio.createVehiculo(NO_ECONOMICO, MARCA, TIPO, MODELO, CAPACIDAD_TANQUE, 
                    IMAGEN, TIPO_COMBUSTIBLE, NO_SERIE, NO_MOTOR, PLACAS, AREA_RESGUARDANTE, RESGUARDANTE, 
                    DISPONIBILIDAD, IMAGEN);
            String json = "Agregado correctamente";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + ex.toString()).build();
        }
    }

    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateVehiculo(@QueryParam("DISPONIBILIDAD") Boolean DISPONIBILIDAD, 
            @QueryParam("NO_ECONOMICO") String NO_ECONOMICO) {
        try{
            VehiculoServicio vehiculoServicio = new VehiculoServicio();
            vehiculoServicio.updateVehiculo(DISPONIBILIDAD, NO_ECONOMICO);
            String json = "Actualizado correctamente";
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + ex.toString()).build();
        }
    }
    
    @DELETE
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteVehiculo(@QueryParam("NO_ECONOMICO") String NO_ECONOMICO){
        try{
            VehiculoServicio vehiculoServicio = new VehiculoServicio();
            vehiculoServicio.delete(NO_ECONOMICO);
            String json = "Eliminado correctamente";
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }catch(Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + ex.toString()).build();
        }
    }
}

