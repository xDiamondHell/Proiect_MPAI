package ro.ase.mpai.web.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Contract {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;

	@ManyToOne
	@JoinColumn(referencedColumnName = "cod")
	protected Client client;
	@ManyToOne
	@JoinColumn(referencedColumnName = "cod")
	protected Abonament abonament;

	protected Date data;
	protected int durata;
	protected double discount;

	public Contract() {

	}

	public Contract(int id, Client client, Abonament abonament, Date data, int durata, double discount) {
		this.id = id;
		this.client = client;
		this.abonament = abonament;
		this.data = data;
		this.durata = durata;
		this.discount = discount;
	}

	public Contract(Client client, Abonament abonament, Date data, int durata, double discount) {
		this.client = client;
		this.abonament = abonament;
		this.data = data;
		this.durata = durata;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Abonament getAbonament() {
		return abonament;
	}

	public void setAbonament(Abonament abonament) {
		this.abonament = abonament;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Contract [id=" + id + ", client=" + client.getDenumire() + ", abonament=" + abonament.getDenumire()
				+ ", data=" + data + ", durata=" + durata + ", discount=" + discount + "]";
	}
}
