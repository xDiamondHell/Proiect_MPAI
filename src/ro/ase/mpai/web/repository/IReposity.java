package ro.ase.mpai.web.repository;

import java.util.List;

public interface IReposity<T> {
	T get(int id);

	List<T> getAll();

	void add(T item);

	void update(T item);

	void delete(T item);

}
