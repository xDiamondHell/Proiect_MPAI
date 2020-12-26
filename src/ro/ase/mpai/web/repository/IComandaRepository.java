package ro.ase.mpai.web.repository;

import java.util.List;

import ro.ase.mpai.web.model.Comanda;

public interface IComandaRepository {
	
	List<Comanda> getClientOrdersByEmail(String email);
}
