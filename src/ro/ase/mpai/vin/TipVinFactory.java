package ro.ase.mpai.vin;

public class TipVinFactory implements IAbstractFactory<ITipVin>{

	@Override
	public ITipVin create(String vin) {
		if("Sec".equalsIgnoreCase(vin)) {
			return new TipVinSec();
		}else if("DemiSec".equalsIgnoreCase(vin)) {
			return new TipVinDemiSec();
		}else if("Dulce".equalsIgnoreCase(vin)) {
			return new TipVinDulce();
		}else if("DemiDulce".equalsIgnoreCase(vin)) {
			return new TipVinDemiDulce();
		}
		return null;
	}

}
