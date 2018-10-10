package ar.sarm.unq.sga;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.hibernate.SessionFactoryContainer;
import ar.sarm.unq.sga.home.Home;
import ar.sarm.unq.sga.model.Project;

@Component
public class GenerateData {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private Home<Project> projectStore;
	

	protected void generate() {
		Session s =sessionFactory.getCurrentSession();
		Transaction transaction = s.beginTransaction();

		try {
			Project proyecto = new Project("proyectito2");
			projectStore.insert(proyecto);
			transaction.commit();
			
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
			
		} finally {
			s.close();
		}
	}

}
