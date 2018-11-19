package ar.sarm.unq.sga.wicket.backlog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.Backlog;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.wicket.userstory.UserStoryStore;

@Component
public class BacklogStore extends HomeGeneralSession<Backlog> {
	private static final long serialVersionUID = 1L;
	private Backlog backlog;
	@Autowired
	private UserStoryStore userStoryStore;

	@Override
	public Backlog findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void agregarBacklogStore(Backlog back) {		
		this.getSession().save(back);

	}

	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}
	
	public List<UserStory>getUsersstories(){
		return userStoryStore.getUsersstories();
	}
	public void borrarUserStoryDeBacklog(UserStory us){
		this.getListaUserStoryEnBacklog(backlog).remove(us);
	}

	public List<UserStory>getListaUserStoryEnBacklog(Backlog back){
		return getSession().createQuery("FROM Backlog WHERE userStory = : us",UserStory.class)
				           .setParameterList("us",back.getUserStories())
				           .getResultList();
	}
	

}
