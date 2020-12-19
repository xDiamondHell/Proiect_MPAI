package ro.ase.mpai.vin;

public class VinFactory implements IAbstractFactory<IVin> {

	@Override
	public IVin create(String vin) {
		if("Alb".equalsIgnoreCase(vin)) {
			return new VinAlb();
		}else if("Rosu".equalsIgnoreCase(vin)) {
			return new VinRosu();
		}else if("Rose".equalsIgnoreCase(vin)) {
			return new VinRose();
		}
		return null;
	}
	
}
