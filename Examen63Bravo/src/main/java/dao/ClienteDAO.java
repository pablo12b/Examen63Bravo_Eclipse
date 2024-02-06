package dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import model.Cliente;

@Stateless
public class ClienteDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Cliente cliente) {
		em.persist(cliente);
	}
	
	public void update(Cliente cliente) {
		em.merge(cliente);
	}
	
	public void remove(int codigo) {
		Cliente cliente = em.find(Cliente.class, codigo);
		em.remove(cliente);
	}
	
	public Cliente read(int codigo) {
		Cliente cliente = em.find(Cliente.class, codigo);
		return cliente;
	}

	
	public List<Cliente> getAll(){
		String jpql = "SELECT c FROM Cliente c";
		Query q = em.createQuery(jpql, Cliente.class);
		return q.getResultList();
	}
}
