package ro.ase.mpai.web.repository;

import java.util.List;

import jakarta.persistence.EntityManager;

public class Repository<T> implements IReposity<T> {

	EntityManager entitymanager;
	Class<T> clasa;
	
	public Repository(EntityManager entitymanager, Class<T> clasa) {
		this.entitymanager = entitymanager;
		this.clasa = clasa;
	}

	@Override
	public T get(int id) {
		return entitymanager.find(clasa, id);
	}

	@Override
	public List<T> getAll() {
		return entitymanager.createQuery("SELECT t FROM " + clasa.getSimpleName() + " t").getResultList();
	}

	@Override
	public void add(T item) {
		entitymanager.getTransaction().begin();
		entitymanager.persist(item);
		entitymanager.getTransaction().commit();
	}

	@Override
	public void update(T item) {
		entitymanager.getTransaction().begin();
		entitymanager.merge(item);
		entitymanager.getTransaction().commit();
	}

	@Override
	public void delete(T item) {
		entitymanager.getTransaction().begin();
		entitymanager.remove(item);
		entitymanager.getTransaction().commit();
	}

}
