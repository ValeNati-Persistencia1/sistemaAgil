package ar.sarm.unq.sga;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.wicket.project.ProjectStore;

@Component
@Transactional
public class GenerateData {

	@Autowired
	private ProjectStore projectStore;
	@Autowired
	private SessionFactory sessionFactory;

	protected void generate() {
		Project proyecto = new Project("proyectito2");

		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
		projectStore.insert(proyecto);
		// acá van los .insert
		ts.commit();
		// Developer dev=new Developer("Jose");
		// developerStore.insert(dev);

	}
}
