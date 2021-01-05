package ro.ase.mpai.clientNullObject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ro.ase.mpai.web.model.Client;
import ro.ase.mpai.web.repository.ClientRepository;
import ro.ase.mpai.web.repository.ComandaRepository;

public class ClientFactory {

	static EntityManagerFactory emfactory;
	static EntityManager entitymanager;
	static ClientRepository clientRepo;
	static ComandaRepository comandaRepo;

	static {
		emfactory = Persistence.createEntityManagerFactory("web");
		entitymanager = emfactory.createEntityManager();
		clientRepo = new ClientRepository(entitymanager);
		comandaRepo = new ComandaRepository(entitymanager);
	}

	public static AbstractClient getClient(String email) {

		Client client = clientRepo.getClientByEmail(email);
		return client == null ? new ClientNou(email, clientRepo, comandaRepo)
				: new ClientLoial(email, clientRepo, comandaRepo);
	}
}
