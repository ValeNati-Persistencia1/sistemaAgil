package ar.sarm.unq.sga;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.wicket.project.ProjectStore;

@Component
public class GenerateData {

	@Autowired
	private ProjectStore projectStore;
	@Autowired
	private SessionFactory sessionFactory;

	// @Autowired Home<Developer>developerStore;

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
