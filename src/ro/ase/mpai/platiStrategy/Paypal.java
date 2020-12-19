package ro.ase.mpai.platiStrategy;

public class Paypal implements IPlati {

	private String email;
	private String parola;

	public Paypal(String email, String parola) {
		this.email = email;
		this.parola = parola;
	}

	@Override
	public void plata(int suma) {
		System.out.println(suma + " plata cu Paypal");
	}

}
