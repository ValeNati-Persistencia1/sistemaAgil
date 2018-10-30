package ar.sarm.unq.sga.wicket.backlog;

import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.Backlog;

@Component
public class BacklogStore extends HomeGeneralSession<Backlog> {
	private static final long serialVersionUID = 1L;

	@Override
	public Backlog findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

//	public void agregarBacklog(Backlog backlog) {
//		this.getSession().save(backlog);
//	}
//
//	public void updateBacklo(Backlog backlog) {
//		this.getSession().update(backlog);
//	}
//
//	public void deleteBacklog(Backlog backlog) {
//		this.getSession().delete(backlog);
//	}
//
}
