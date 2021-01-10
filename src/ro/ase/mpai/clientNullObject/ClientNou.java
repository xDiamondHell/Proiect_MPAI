package ro.ase.mpai.clientNullObject;

import ro.ase.mpai.web.repository.ClientRepository;
import ro.ase.mpai.web.repository.ComandaRepository;

public class ClientNou extends AbstractClient{

	public ClientNou(String nume, ClientRepository clientRepository, ComandaRepository comandaRepository) {
		super(nume, clientRepository, comandaRepository);
	}

	@Override
	public double getDiscount() {
		return 1;
	}

	@Override
	public String getEmail() {
		return email;
	}

}
