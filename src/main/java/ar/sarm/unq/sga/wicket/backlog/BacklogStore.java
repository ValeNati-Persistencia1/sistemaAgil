package ar.sarm.unq.sga.wicket.backlog;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.Backlog;
import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.wicket.project.ProjectStore;

public class BacklogStore extends HomeGeneralSession<Backlog> {
	private static BacklogStore elunico;

	public static BacklogStore elunico() {
		if (elunico == null) {
			elunico = new BacklogStore();
		}
		return elunico;
	}

	public void agregarBacklog(Backlog backlog) {
		this.getSession().save(backlog);
	}

	public void updateBacklo(Backlog backlog) {
		this.getSession().update(backlog);
	}

	public void deleteBacklog(Backlog backlog) {
		this.getSession().delete(backlog);
	}

	@Override
	public Backlog find(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
