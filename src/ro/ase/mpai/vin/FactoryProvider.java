package ro.ase.mpai.vin;

public class FactoryProvider {

	public static IAbstractFactory getFactory(String choice) {
		if("Vin".equalsIgnoreCase(choice)){
            return new VinFactory();
        }
        else if("Tip".equalsIgnoreCase(choice)){
            return new TipVinFactory();
        }
		return null;
	}
}
