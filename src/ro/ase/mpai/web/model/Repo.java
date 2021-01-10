package ro.ase.mpai.web.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

//simulare acces la baza de date
public class Repo {
	static EntityManager entitymanager;
	Class<Comanda> clasa;

	private static ArrayList<Client> clienti = new ArrayList<>();

	/*
	 * static {
	 * 
	 * for (int i=1; i<= 15; i++) { clienti.add(new Client(i, "", "Client " + i,
	 * "Adresa " + i, "Localitate " + i, i+"@email.com", "072212345"+i, )); } }
	 */
	public static ArrayList<Client> getAll() {
		return clienti;
	}

	public static Client get(int cod) {
		// validare cod 0 < cod <=size()
		return clienti.get(cod - 1);
	}

	public static void add(Client client) {
		clienti.add(client);
	}

}
