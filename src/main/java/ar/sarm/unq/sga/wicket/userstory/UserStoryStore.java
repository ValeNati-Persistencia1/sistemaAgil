package ar.sarm.unq.sga.wicket.userstory;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.UserStory;

public class UserStoryStore extends HomeGeneralSession<UserStory>{

	private static final long serialVersionUID = 1L;
	
	private static UserStoryStore elUnico;

	public static UserStoryStore elUnico() {
		if(elUnico==null){
			elUnico=new UserStoryStore();
		}
		return elUnico;
	}
	
	public void agregarUserStory(UserStory userStory){
		this.getSession().save(userStory);
	}
	
	public void updateUserStory(UserStory userStory){
		this.getSession().update(userStory);
	}
	
	public void deleteUserStory(UserStory userStory){
		this.getSession().delete(userStory);
	}

	
	
	

}
