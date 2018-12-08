package ar.sarm.unq.sga.wicket.backlog;

import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.SprintBacklog;

@Component
public class SprintBacklogStore extends HomeGeneralSession<SprintBacklog> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public SprintBacklog findByName(String name) {
		return null;
	}

	public void agregarSprintBacklog(SprintBacklog sBacklog) {
		this.getSession().save(sBacklog);
	}
	public void updateSprintBacklog(SprintBacklog sBacklog) {
		this.getSession().update(sBacklog);
	}

	public void deleteSprintBacklog(SprintBacklog sBacklog) {
		this.getSession().delete(sBacklog);
	}

}
