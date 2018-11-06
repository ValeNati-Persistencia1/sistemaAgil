package ar.sarm.unq.sga.wicket.userstory;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.UserStory;
@Component
public class UserStoryStore extends HomeGeneralSession<UserStory>{

	private static final long serialVersionUID = 1L;

	@Override
	public UserStory findByName(String name) {
		return findByName(name);
	}
	
	public List<UserStory>getUsersStories(){
		return getSession().createQuery("FROM UserStory",UserStory.class).list();
	}

	
	
  

	
	
	

	
	
	
	
	
	
	
}
