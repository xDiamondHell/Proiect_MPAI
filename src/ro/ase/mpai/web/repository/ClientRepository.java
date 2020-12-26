package ro.ase.mpai.web.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ro.ase.mpai.web.model.Client;
import ro.ase.mpai.web.model.Client.ClientBuilder;
import ro.ase.mpai.web.model.Comanda;

public class ClientRepository extends Repository<Client> implements IClientRepository {

	public ClientRepository(EntityManager entitymanager) {
		super(entitymanager, Client.class);
	}

	@Override
	public List<Client> getAllByLocalitate(String localitate) {
		return null;
	}

	@Override
	public Client getClientByEmail(String email) {
		TypedQuery<Client> query = entitymanager.createQuery("SELECT c FROM Client c WHERE c.email= :clientEmail" , Client.class).setParameter("clientEmail", email);	
		Client client = query.getSingleResult();
		
		System.out.println("Clientul gasit este " + client.toString());
		return client;
	}
	
}
