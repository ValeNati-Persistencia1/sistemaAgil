
package ar.sarm.unq.sga.home;

import org.hibernate.Session;

import ar.sarm.unq.sga.hibernate.SessionFactoryContainer;

public abstract class HomeGeneralSession<T> implements Home<T> {

	private static final long serialVersionUID = 1L;
	static private HomeGeneralSession instance;

	public static HomeGeneralSession getInstance(){
		return  instance;
	}
	public Session getSession() {
		return SessionFactoryContainer.getSessionFactory().getCurrentSession();
	}

	@Override
	public void insert(T object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(T object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(T object) {
		// TODO Auto-generated method stub

	}

	@Override
	public T findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
