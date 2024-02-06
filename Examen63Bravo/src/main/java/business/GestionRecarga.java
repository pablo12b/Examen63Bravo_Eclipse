package business;

import java.util.List;

import dao.RecargaDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import model.Recarga;

@Stateless
public class GestionRecarga {
	@Inject
	private RecargaDAO recargaDAO;
	
	public void guardarRecarga(Recarga recarga) {
		Recarga rec = recargaDAO.read(recarga.getId());
	    if (rec != null) {
	    	recargaDAO.update(recarga);
	    } else {
	    	recargaDAO.insert(recarga);
	    }
	}
	
	public void removeRecarga(int codigo) {
		recargaDAO.remove(codigo);
	}
	
	public List<Recarga> getAll(){
		return recargaDAO.getAll();
	}
}
