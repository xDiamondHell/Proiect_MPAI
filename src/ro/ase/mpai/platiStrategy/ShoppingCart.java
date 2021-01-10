package ro.ase.mpai.platiStrategy;

public class ShoppingCart {

	public void plata(IPlati metodaPlata, double suma) {
		metodaPlata.plata(suma);
	}
}
