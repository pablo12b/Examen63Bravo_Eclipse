package business;

import java.util.Date;
import java.util.List;
import dao.ClienteDAO;
import dao.RecargaDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import model.Cliente;
import model.Recarga;

@Stateless
public class GestionCliente {
	@Inject
	private ClienteDAO clienteDAO;
	@Inject
	private RecargaDAO recargaDAO;
	
	public void guardarCliente(Cliente cliente) {
	    if (cliente.getNombre().length() < 4) {
	        throw new IllegalArgumentException("El nombre debe tener al menos 4 letras.");
	    }
	    if (cliente.getDni().length() != 10) {
	        throw new IllegalArgumentException("El DNI debe tener exactamente 10 caracteres.");
	    }
	    Cliente cli = clienteDAO.read(cliente.getId());
	    if (cli != null) {
	        clienteDAO.update(cliente);
	    } else {
	        clienteDAO.insert(cliente);
	    }
	}
	
	public void removeCliente(int codigo) {
		clienteDAO.remove(codigo);
	}
	
	public List<Cliente> getAll(){
		return clienteDAO.getAll();
	}
	
	public Cliente transferencia(String dni, double monto) {
		Cliente cliente = clienteDAO.getClientePorDNI(dni);
		System.out.println("El saldo del cliente "+cliente.getNombre()
						 + " antes de la transferencia es: "+cliente.getSaldo());
		cliente.setSaldo(cliente.getSaldo() + monto);
		System.out.println("El saldo del cliente "+cliente.getNombre()
		 				 + " despues de la transferencia es: "+cliente.getSaldo());
		Recarga recarga = new Recarga();
		recarga.setCliente(cliente);
		recarga.setSaldo(cliente.getSaldo());
		recarga.setFecha(new Date());
		recargaDAO.insert(recarga);
		return cliente;
	}
}
