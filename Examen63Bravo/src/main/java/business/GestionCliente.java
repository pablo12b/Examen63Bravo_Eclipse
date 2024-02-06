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
	
	public void transferencia(String dni, double monto) {
		Cliente cliente = clienteDAO.getClientePorDNI(dni);
		System.out.println("El saldo del cliente "+cliente.getNombre()
						 + " antes de la transferencia es: "+cliente.getSaldo());
		cliente.setSaldo(cliente.getSaldo() + monto);
		System.out.println("El saldo del cliente "+cliente.getNombre()
		 				 + " despues de la transferencia es: "+cliente.getSaldo());
		Cliente administrador = clienteDAO.getClientePorDNI("xxxxxxxxxx");
		clienteDAO.update(cliente);
		administrador.setSaldo(cliente.getSaldo() - monto);
		clienteDAO.update(administrador);
	}
}
