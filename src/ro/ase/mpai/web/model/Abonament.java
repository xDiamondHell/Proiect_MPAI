package ro.ase.mpai.web.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Abonament {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod;
	String denumire;
	double pret;
	
	@OneToMany(mappedBy = "abonament")
	List<Contract> contracte;
	
	public Abonament() {
		
	}
	
	public Abonament(int cod, String denumire, double pret) {
		this.cod = cod;
		this.denumire = denumire;
		this.pret = pret;
	}
	
	public Abonament(String denumire, double pret) {
		this.denumire = denumire;
		this.pret = pret;
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
	public double getPret() {
		return pret;
	}
	public void setPret(double pret) {
		this.pret = pret;
	}
	
	public List<Contract> getContracte() {
		return contracte;
	}

	@Override
	public String toString() {
		return "Abonament [cod=" + cod + ", denumire=" + denumire + ", pret=" + pret + "]";
	}
	
	
}
