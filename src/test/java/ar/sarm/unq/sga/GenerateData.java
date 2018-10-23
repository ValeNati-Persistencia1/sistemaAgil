package ar.sarm.unq.sga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.home.Home;
import ar.sarm.unq.sga.model.Developer;
import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.wicket.developer.DeveloperStore;
@Component
@Transactional
public class GenerateData {

	@Autowired
	private Home<Project> projectStore;

	protected void generate() {
		Project proyecto = new Project("proyectito2");
		projectStore.insert(proyecto);

	}

}
	
	
	
	
