package ro.ase.mpai.platiStrategy;

public class Card implements IPlati {
	private String nume;
	private String numarCard;
	private String cvv;
	private String dataExpirare;

	public Card(String nume, String numarCard, String cvv, String dataExpirare) {
		this.nume = nume;
		this.numarCard = numarCard;
		this.cvv = cvv;
		this.dataExpirare = dataExpirare;
	}

	@Override
	public void plata(double amount) {
		System.out.println(amount + " plata cu card.");
	}
}
