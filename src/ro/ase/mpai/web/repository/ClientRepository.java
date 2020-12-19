package ro.ase.mpai.web.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import ro.ase.mpai.web.model.Client;

public class ClientRepository extends Repository<Client> implements IClientRepository {

	public ClientRepository(EntityManager entitymanager) {
		super(entitymanager, Client.class);
	}

	@Override
	public List<Client> getAllByLocalitate(String localitate) {
		// TODO Auto-generated method stub
		return null;
	}

}
