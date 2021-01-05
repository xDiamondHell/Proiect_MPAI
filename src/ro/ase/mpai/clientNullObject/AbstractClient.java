package ro.ase.mpai.clientNullObject;

import ro.ase.mpai.web.repository.ClientRepository;
import ro.ase.mpai.web.repository.ComandaRepository;

public abstract class AbstractClient {
	protected String email;
	protected ClientRepository clientRepository;
	protected ComandaRepository comandaRepository;

	public abstract double getDiscount();

	public abstract String getEmail();

	public AbstractClient(String nume, ClientRepository clientRepository, ComandaRepository comandaRepository ) {
		super();
		this.email = nume;
		this.clientRepository = clientRepository;
		this.comandaRepository = comandaRepository;
	}

}
