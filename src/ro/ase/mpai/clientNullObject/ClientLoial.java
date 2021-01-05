package ro.ase.mpai.clientNullObject;

import java.util.List;

import ro.ase.mpai.web.model.Client;
import ro.ase.mpai.web.model.Comanda;
import ro.ase.mpai.web.repository.ClientRepository;
import ro.ase.mpai.web.repository.ComandaRepository;

public class ClientLoial extends AbstractClient {

	public ClientLoial(String nume, ClientRepository clientRepository, ComandaRepository comandaRepository) {
		super(nume, clientRepository, comandaRepository);
	}

	@Override
	public double getDiscount() {

		Client client = clientRepository.getClientByEmail(email);
		List<Comanda> comenzi = comandaRepository.getClientOrdersByEmail(email);
		return comenzi.size() * 20;
	}

	@Override
	public String getEmail() {
		return email;
	}

}
