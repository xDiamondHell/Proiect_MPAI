package ro.ase.mpai.web.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ro.ase.mpai.web.model.Client;

public class ClientRepository extends Repository<Client> implements IClientRepository {

	public ClientRepository(EntityManager entitymanager) {
		super(entitymanager, Client.class);
	}

	@Override
	public Client getClientByEmail(String email) {
		TypedQuery<Client> query = entitymanager
				.createQuery("SELECT c FROM Client c WHERE c.email= :clientEmail", Client.class)
				.setParameter("clientEmail", email);
		/* Client client = query.getSingleResult(); */
		List<Client> clients = query.getResultList();
		Client client = null;
		if (clients.size() > 0) {
			client = clients.get(0);
			System.out.println("Clientul gasit este " + client.toString());
		}

		return client;
	}

}
