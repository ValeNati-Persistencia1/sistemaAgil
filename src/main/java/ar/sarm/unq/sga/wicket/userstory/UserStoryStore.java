package ar.sarm.unq.sga.wicket.userstory;

import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.UserStory;
@Component
public class UserStoryStore extends HomeGeneralSession<UserStory>{

	private static final long serialVersionUID = 1L;

	@Override
	public UserStory findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

//	public void agregarUserStory(UserStory userStory){
//		this.getSession().save(userStory);
//	}
//	
//	public void updateUserStory(UserStory userStory){
//		this.getSession().update(userStory);
//	}
//	
//	public void deleteUserStory(UserStory userStory){
//		this.getSession().delete(userStory);
//	}

	
	
	
	

}
