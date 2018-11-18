package ar.sarm.unq.sga.wicket.userstory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.UserStory;

@Component
public class UserStoryStore extends HomeGeneralSession<UserStory> {

	private static final long serialVersionUID = 1L;

	@Override
	public UserStory findByName(String name) {
		return findByName(name);
	}

	public List<UserStory> getUsersstories() {
		return getSession().createQuery("FROM UserStory", UserStory.class).list();
	}

	public void agregarUserStory(UserStory user) {
		getSession().save(user);
	}
//agregue la query
	public List<UserStory> getBacklogsCompletados() {
		return getSession().createQuery("FROM UserStory WHERE estaCompleta = : completa", UserStory.class)
				.setParameter("completa", true)
				.getResultList();
	}

//	public void agregarProjectAUserStory(Project project){ 
//	Query<UserStory> query= getSession().createQuery("FROM UserStory", UserStory.class);
//				query.setParameter("project", project);
//				//query.setParameterList("usersStories",this.getListUsersStories());
//	            ((Session) query).save(project);
//         
//	}

    
}
