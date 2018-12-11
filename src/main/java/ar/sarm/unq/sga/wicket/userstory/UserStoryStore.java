package ar.sarm.unq.sga.wicket.userstory;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.Fibonacci;
import ar.sarm.unq.sga.model.UserStory;

@Component
public class UserStoryStore extends HomeGeneralSession<UserStory> {

	private static final long serialVersionUID = 1L;

	@Override
	public UserStory findByName(String name) {
		return findByName(name);
	}

	public void agregarUserStory(UserStory user) {
		getSession().save(user);
	}


	public List<UserStory> getListaDeUserStory() {
		Query<UserStory> query = getSession()
				.createQuery("from UserStory WHERE estaEnBacklogSprint = : estaEnBacklogSprint ", UserStory.class);
		query.setParameter("estaEnBacklogSprint", false);
		return query.list();
	}

//	public void sumstories() {
//		Fibonacci fib = Fibonacci.CINCO;
//		Double fibD = fib.getNumero();
//	}
}
