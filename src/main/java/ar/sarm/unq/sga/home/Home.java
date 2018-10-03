package ar.sarm.unq.sga.home;

	import java.io.Serializable;

	public interface Home<T> extends Serializable {

		public T findByName(String name);
		public void insert(T object);
		public void update(T object);
		public void delete(T object);

	}


