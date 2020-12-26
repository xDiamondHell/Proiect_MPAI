package ro.ase.mpai.web.repository;


import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ro.ase.mpai.web.model.Comanda;

public class ComandaRepository extends Repository<Comanda> implements IComandaRepository {

	public ComandaRepository(EntityManager entitymanager) {
		super(entitymanager, Comanda.class);
	}

	@Override
	public List<Comanda> getClientOrdersByEmail(String email) {
		String emailParameter = email;
		TypedQuery<Comanda> query = entitymanager.createQuery("SELECT c FROM Comanda c JOIN c.client cl ON cl.email = '" + emailParameter + "'" , Comanda.class);	
		List<Comanda> comenzi = query.getResultList();
		System.out.println("Comenzile plasate sunt:");
		System.out.println(comenzi);
		return comenzi;
	}
}
