package ar.sarm.unq.sga;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.model.Developer;
import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.wicket.developer.DeveloperStore;
import ar.sarm.unq.sga.wicket.project.ProjectStore;
import ar.sarm.unq.sga.wicket.userstory.UserStoryStore;

@Component
@Transactional
public class GenerateData {

	@Autowired
	private ProjectStore projectStore;
	
	@Autowired
	private DeveloperStore developerStore;
	
	@Autowired
	private UserStoryStore userStoryStore;
	
	@Autowired
	private SessionFactory sessionFactory;

	protected void generate() {
		Project proyecto = new Project("proyectito2");
		
		Developer developer=new Developer("developer");
        UserStory userstory=new UserStory("userstory");
        
		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
		projectStore.insert(proyecto);
		
		developerStore.insert(developer);
		userStoryStore.insert(userstory);

		ts.commit();
		

	}
}
