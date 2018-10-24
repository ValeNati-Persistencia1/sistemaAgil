package ar.sarm.unq.sga.wicket.developer;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.Developer;
import ar.sarm.unq.sga.model.Project;
@Component
public class DeveloperStore extends HomeGeneralSession<Developer>{

	private static final long serialVersionUID = 1L;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public List<Developer> developers() {
		return getSession().createQuery("FROM Developer", Developer.class).list();
	}

}
