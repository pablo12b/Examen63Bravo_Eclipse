package Services;

import java.util.List;

import business.GestionRecarga;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Recarga;

@Path("recargas")
public class RecargaServices {
	@Inject
	private GestionRecarga gRecarga;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Recarga recarga) {
		try{
			gRecarga.guardarRecarga(recarga);
			return Response.ok(recarga).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String borrar(@QueryParam("codigo") int codigo) {
		try{
			gRecarga.removeRecarga(codigo);
			return "OK";
		}catch (Exception e) {
			// TODO: handle exception
			return "Error";
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getRecargas(){
		List <Recarga> lista = gRecarga.getAll();
		if(lista.size()>0) {
			return Response.ok(lista).build();
		}
		ErrorMessage em = new ErrorMessage(6, "No se registran Recargas");
		return Response.status(Response.Status.NOT_FOUND).entity(em).build();
	}

}
