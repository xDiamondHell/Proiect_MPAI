package ro.ase.mpai.web.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class MetodaPlata {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod;
	
	String denumire;
	
	@OneToMany(mappedBy = "metodaplata")
	private List<Comanda> comenzi = new ArrayList<>();
	
	public MetodaPlata() {
		
	}
	
	public MetodaPlata(int cod, String denumire) {
		this.cod = cod;
		this.denumire = denumire;
	}
	
	public MetodaPlata(String denumire) {
		this.denumire = denumire;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	
	public List<Comanda> getComenzi() {
		return comenzi;
	}

	@Override
	public String toString() {
		return "MetodaPlata [cod=" + cod + ", denumire=" + denumire + ", comenzi=" + comenzi + "]";
	}

}
