package ar.sarm.unq.sga.wicket.backlog;

import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.Backlog;
import ar.sarm.unq.sga.model.Project;

@Component
public class BacklogStore extends HomeGeneralSession<Backlog> {
	private static final long serialVersionUID = 1L;
	private Backlog backlog;

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

	// public void agregarBacklog(Backlog back) {
	// this.getSession().save(back);
	// }
	//
	// public void updateBacklo(Backlog backlog) {
	// this.getSession().update(backlog);
	// }
	//
	// public void deleteBacklog(Backlog backlog) {
	// this.getSession().delete(backlog);
	// }
	//

}
