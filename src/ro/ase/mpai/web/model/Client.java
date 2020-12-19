package ro.ase.mpai.web.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int cod;
	protected String CNP;
	protected String denumire;
	protected String adresa;
	protected String localitate;
	protected String email;
	protected String telefon;

	@OneToMany(mappedBy = "Client")
	List<Contract> contracte;

	private Client() {

	}

	public static class ClientBuilder {
		protected String CNP;
		protected String denumire;
		protected String adresa;
		protected String localitate;
		protected String email;
		protected String telefon;

		public ClientBuilder(String denumire, String adresa, String localitate, String email) {
			this.denumire = denumire;
			this.adresa = adresa;
			this.localitate = localitate;
			this.email = email;
		}

		public ClientBuilder setCNP(String cnp) {
			this.CNP = cnp;
			return this;
		}

		public ClientBuilder setTelefon(String telefon) {
			this.telefon = telefon;
			return this;
		}

		// Return the finally constructed Client object
		public Client build() {
			return new Client(CNP, denumire, adresa, localitate, email, telefon);
		}
	}

	private Client(String cnp, String denumire, String adresa, String localitate, String email,
			String telefon) {
		super();
		this.CNP = cnp;
		this.denumire = denumire;
		this.adresa = adresa;
		this.localitate = localitate;
		this.email = email;
		this.telefon = telefon;
	}

	private Client(String denumire, String adresa, String localitate, String email, String telefon) {

		this.denumire = denumire;
		this.adresa = adresa;
		this.localitate = localitate;
		this.email = email;
		this.telefon = telefon;
	}

	public int getCod() {
		return cod;
	}

	public String getDenumire() {
		return denumire;
	}

	public String getAdresa() {
		return adresa;
	}

	public String getLocalitate() {
		return localitate;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefon() {
		return telefon;
	}


	public List<Contract> getContracte() {
		return contracte;
	}

	@Override
	public String toString() {
		return "Client [cod=" + cod + ", denumire=" + denumire + ", adresa=" + adresa + ", localitate=" + localitate
				+ ", email=" + email + ", telefon=" + telefon + ", contracte=" + contracte.size() + "]";
	}

}
