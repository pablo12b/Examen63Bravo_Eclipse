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
		Cliente administrador = new Cliente();
		administrador.setDni("xxxxxxxxxx");
		administrador.setNombre("admin");
		administrador.setSaldo(0);
		clienteDAO.insert(administrador);
		System.out.println("Se ingreso el administrador");
	}

}
