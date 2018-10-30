package ar.sarm.unq.sga.home;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;

import ar.sarm.unq.sga.model.Persistible;

@Repository
public abstract class HomeGeneralSession<T extends Persistible> implements Home<T> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(T object) {
		getSession().save(object);

	}

	@Override
	public void update(T object) {
		getSession().update(object);
	}

	@Override
	public void delete(T object) {
		getSession().delete(object);

	}

//	@Override
//	public T findByName(String name) {
//		Class<T> genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), HomeGeneralSession.class);
//		genericType.getSimpleName();//devuelve un string
//		
//		return getSession().get(genericType, name);
//		return getSession().createQuery(criteriaQuery)
//	}

	@Override
	public T find(long id) {
		Class<T> genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), HomeGeneralSession.class);
		return getSession().get(genericType, id);
	}

	@Override
	public void attach(T result) {
		if (this.isDetached(result)) {
			this.getSession().lock(result, LockMode.NONE);
		}
	}

	public boolean isDetached(T result) {
		return result != null && result.getId() != null;
	}

}
