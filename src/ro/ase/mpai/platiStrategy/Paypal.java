package ro.ase.mpai.platiStrategy;

public class Paypal implements IPlati {

	private String email;
	private String parola;

	public Paypal(String email, String pwd) {
		this.email = email;
		this.parola = pwd;
	}

	@Override
	public void plata(int suma) {
		System.out.println(suma + " plata cu Paypal");
	}

}
