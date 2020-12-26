package ro.ase.mpai.web.model;

import java.util.ArrayList;
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
	private int cod;

	//componente obligatorii
	private String denumire;
	private String adresa;
	private String localitate;
	private String email;
	
	//componente optionale
	private String CNP;
	private String telefon;

	@OneToMany(mappedBy = "client")
	private List<Comanda> comenzi = new ArrayList<>();

	public void setCod(int cod) {
		this.cod = cod;
	}

	public void setCNP(String CNP) {
		this.CNP = CNP;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public void setLocalitate(String localitate) {
		this.localitate = localitate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public int getCod() {
		return cod;
	}

	public String getCNP() {
		return CNP;
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

	private Client(ClientBuilder clientBuilder) {
		super();
		this.CNP = clientBuilder.CNP;
		this.denumire = clientBuilder.denumire;
		this.adresa = clientBuilder.adresa;
		this.localitate = clientBuilder.localitate;
		this.email = clientBuilder.email;
		this.telefon = clientBuilder.telefon;
	}

	public Client() {
		super();
	}

	public static class ClientBuilder {
		//componente obligatorii
		private String denumire;
		private String adresa;
		private String localitate;
		private String email;
		
		//componente optionale
		private String CNP;
		private String telefon;

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

		public Client build() {
			return new Client(this);
		}
	}

	@Override
	public String toString() {
		return "Client [cod=" + cod + ", CNP=" + CNP + ", denumire=" + denumire + ", adresa=" + adresa + ", localitate="
				+ localitate + ", email=" + email + ", telefon=" + telefon + ", comenzi=" + comenzi + "]";
	}

}
