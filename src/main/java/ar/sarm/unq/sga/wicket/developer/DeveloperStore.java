package ar.sarm.unq.sga.wicket.developer;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.Developer;
@Component
public class DeveloperStore extends HomeGeneralSession<Developer>{

	private static final long serialVersionUID = 1L;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public List<Developer> getDevelopers() {
		return getSession().createQuery("FROM Developer", Developer.class).list();
	}
public void agregarDeveloper(Developer dev){
	getSession().save(dev);
}
@Override
public Developer findByName(String name) {
	// TODO Auto-generated method stub
	return null;
}
}
