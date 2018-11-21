package ar.sarm.unq.sga.wicket.userstory;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.UserStory;

@Component
public class UserStoryStore extends HomeGeneralSession<UserStory> {

	private static final long serialVersionUID = 1L;

	@Override
	public UserStory findByName(String name) {
		return findByName(name);
	}

	// cambiado por getlistaUserStory, q va a mostrar los user story q no estan
	// en sprintBacklog
	// public List<UserStory> getUsersstories() {
	// return getSession().createQuery("FROM UserStory",
	// UserStory.class).list();
	// }

	public void agregarUserStory(UserStory user) {
		getSession().save(user);
	}

	// agregue la query
	public List<UserStory> getBacklogsCompletados() {
		return getSession().createQuery("FROM UserStory WHERE estaCompleta = : completa", UserStory.class)
				.setParameter("completa", true).getResultList();
	}

	public List<UserStory> getListaDeUserStoryEnSprintBacklog() {
		Query<UserStory> query = getSession()
				.createQuery("from UserStory WHERE estaEnBacklogSprint = : estaEnBacklogSprint", UserStory.class);
		query.setParameter("estaEnBacklogSprint", true);
		return query.list();
	}

	public List<UserStory> getListaDeUserStory() {
		Query<UserStory> query = getSession()
				.createQuery("from UserStory WHERE estaEnBacklogSprint = : estaEnBacklogSprint", UserStory.class);
		query.setParameter("estaEnBacklogSprint", false);
		return query.list();
	}

}
