package ro.ase.mpai.vin;

public class Produs {

	public String denumire;
	public String caracteristici;

	public Produs() {
		this.denumire = "";
		this.caracteristici = "";

	}

	public Produs(String denumire, String caracteristici) {
		super();
		this.denumire = denumire;
		this.caracteristici = caracteristici;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getCaracteristici() {
		return caracteristici;
	}

	public void setCaracteristici(String caracteristici) {
		this.caracteristici = caracteristici;
	}

	@Override
	public String toString() {
		return "Produs [denumire=" + denumire + ", caracteristici=" + caracteristici + "]";
	}



}
