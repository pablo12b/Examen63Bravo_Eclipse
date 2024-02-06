package business;

import dao.ClienteDAO;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import model.Cliente;

@Singleton
@Startup
public class GestionDatos {
	@Inject
	private ClienteDAO clienteDAO;
	
	@PostConstruct
	public void init() {
		System.out.println("Iniciando examen....");
	}
}
