package ar.sarm.unq.sga.wicket.backlog;

import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.SprintBacklog;
@Component
public class SprintBacklogStore extends HomeGeneralSession<SprintBacklog> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public SprintBacklog findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public void agregarSprintBacklog(SprintBacklog sBacklog){
		this.getSession().save(sBacklog);
	}
}
