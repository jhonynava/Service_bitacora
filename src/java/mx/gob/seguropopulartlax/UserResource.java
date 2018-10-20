package mx.gob.seguropopulartlax;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mx.gob.seguropopulartlax.entidades.User;
import mx.gob.seguropopulartlax.servicio.UserServicio;
import mx.gob.seguropopulattlax.json.UserJson;

/**
 * REST Web Service
 *
 * @author Desarrollo
 */
@Path("user")
public class UserResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    /**
     * Retrieves representation of an instance of mx.gob.seguropopulartlax.UserResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        try{
            String allUserToJson = UserJson.getAllUser();
            
            return Response.ok(allUserToJson, MediaType.APPLICATION_JSON).build();
        } catch(Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + ex.toString()).build();
        }
    }
    
    @GET
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@QueryParam("CURP") String CURP, @QueryParam("PASSWORD") String PASSWORD) {
        
        try{
            User users = new UserServicio().get(CURP, PASSWORD);
            String userToJson = UserJson.getUser(users);
            
            return Response.ok(userToJson, MediaType.APPLICATION_JSON).build();
        } catch(Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + ex.toString()).build();
        }
    }
    
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(@QueryParam("CURP") String CURP, @QueryParam("PASSWORD") String PASSWORD, @QueryParam("NOMBRE") String NOMBRE, @QueryParam("APATERNO")String APATERNO, @QueryParam("AMATERNO") String AMATERNO) {
        
        try{
            UserServicio userServicio = new UserServicio();
            userServicio.create(CURP, PASSWORD, NOMBRE, APATERNO, AMATERNO);
            
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
    public Response updateUser(@QueryParam("CURP") String CURP, @QueryParam("PASSWORD") String PASSWORD){
        try{
            UserServicio userServicio = new UserServicio();
            userServicio.update(CURP, PASSWORD);
            String json = "Actualizado correctamente";
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + ex.toString()).build();
        }
    }
    
    @DELETE
    @Path("delete")
    @Consumes
    @Produces
    public Response deleteUser(@QueryParam("CURP") String CURP){
        try{
            UserServicio userServicio = new UserServicio();
            userServicio.delete(CURP);
            String json = "Eliminado correctamente";
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + ex.toString()).build();
        }
    }
}
