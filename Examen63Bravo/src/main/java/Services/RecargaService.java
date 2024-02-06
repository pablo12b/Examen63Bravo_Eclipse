package Services;

import java.util.List;

import business.GestionRecarga;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Recarga;

@Path("recargas")
public class RecargaService {
	
	@Inject
	private GestionRecarga gRecarga;
	
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
