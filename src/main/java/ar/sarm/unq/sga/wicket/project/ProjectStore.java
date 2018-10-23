package ar.sarm.unq.sga.wicket.project;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.Project;

@Component
public class ProjectStore extends HomeGeneralSession<Project>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// public void agregarProject(Project project) {
	// this.getSession().save(project);
	// }
	//
	// public void updateProject(Project project) {
	// this.getSession().update(project);
	// }
	//
	// public void deleteProject(Project project) {
	// this.getSession().delete(project);
	// }

	public List<Project> proyectos() {
		return getSession().createQuery("FROM Project", Project.class).list();
	}
	
}