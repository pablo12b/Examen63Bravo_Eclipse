package business;

import java.util.List;

import dao.ClienteDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import model.Cliente;

@Stateless
public class GestionCliente {
	@Inject
	private ClienteDAO clienteDAO;
	
	public void guardarCliente(Cliente cliente) {
		Cliente cli = clienteDAO.read(cliente.getId());
		if(cli != null) {
			clienteDAO.update(cliente);
		}else {
			clienteDAO.insert(cliente);
		}
		
	}
	
	public void removeCliente(int codigo) {
		clienteDAO.remove(codigo);
	}
	
	public List<Cliente> getAll(){
		return clienteDAO.getAll();
	}
}
