package ar.sarm.unq.sga.home;

	import java.io.Serializable;

import org.hibernate.Session;

import ar.sarm.unq.sga.model.Persistible;

	public interface Home<T extends Persistible>extends Serializable {

		public T findByName(String name);
		public void insert(T object);
		public void update(T object);
		public void delete(T object);
		public T find(long id);
		public Session getSession();
		public void attach(T result);

	}


