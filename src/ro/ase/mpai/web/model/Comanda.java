package ro.ase.mpai.web.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comanda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int cod;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(referencedColumnName = "cod")
	protected Client client;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(referencedColumnName = "cod")
	protected MetodaPlata metodaplata;

	public Comanda() {

	}

	public Comanda(int id, Client client, MetodaPlata metodaplata) {
		this.cod = id;
		this.client = client;
		this.metodaplata = metodaplata;
	}

	public Comanda(Client client, MetodaPlata metodaplata) {
		this.client = client;
		this.metodaplata = metodaplata;
	}

	public int getId() {
		return cod;
	}

	public void setId(int cod) {
		this.cod = cod;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public MetodaPlata getMetodaPlata() {
		return metodaplata;
	}

	public void setMetodaPlata(MetodaPlata metodaPlata) {
		this.metodaplata = metodaPlata;
	}

	@Override
	public String toString() {
		return "Comanda [cod=" + cod + ", client=" + client + ", metodaPlata=" + metodaplata + "]";
	}

}
