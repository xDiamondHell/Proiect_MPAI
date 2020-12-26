package ro.ase.mpai.web.repository;

import ro.ase.mpai.web.model.Client;
import java.util.List;

public interface IClientRepository {

	List<Client> getAllByLocalitate(String localitate);
	
	Client getClientByEmail(String email);

}
