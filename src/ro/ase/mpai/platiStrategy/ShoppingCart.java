package ro.ase.mpai.platiStrategy;

public class ShoppingCart {

	public void plata(IPlati metodaPlata, int suma) {
		metodaPlata.plata(suma);
	}
}
