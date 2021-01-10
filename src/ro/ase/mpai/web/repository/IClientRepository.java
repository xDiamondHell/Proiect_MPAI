package ro.ase.mpai.web.repository;

import ro.ase.mpai.web.model.Client;

public interface IClientRepository {
	Client getClientByEmail(String email);

}
