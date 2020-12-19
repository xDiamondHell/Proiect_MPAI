package ro.ase.mpai.vin;

public interface IAbstractFactory<T> {
	T create(String vin);
}
