package ar.sarm.unq.sga.wicket.project;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.SprintBacklog;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.model.Usuario;

@Component
public class ProjectStore extends HomeGeneralSession<Project> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Project project;

	public void agregarProject(Project project) {
		this.getSession().save(project);

	}

	public void updateProject(Project project) {
		this.getSession().update(project);
	}

	public void deleteProject(Project project) {
		this.getSession().delete(project);
	}

	public List<Project> getProyectos() {
		return getSession().createQuery("FROM Project", Project.class).list();
	}

	public void attach(String proy) {
		this.attach(getProject());
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public Project findByName(String name) {
		return getSession().createQuery("FROM Project WHERE nombre = :name", Project.class).setParameter("name", name)
				.getSingleResult();
	}

	public void setUsuario(Usuario modelObject) {
		project.setUsuario(modelObject);

	}

	public List<UserStory> getListaDeUserStoryEnSprintBacklog() {
		Query<UserStory> query = getSession()
				.createQuery("from UserStory us WHERE estaEnBacklogSprint = : estaEnBacklogSprint", UserStory.class);
		query.setParameter("estaEnBacklogSprint", true);
		return query.list();

	}

	// public List<SprintBacklog> getListaSprintBacklogDelProjecto(Project
	// proyecto) {
	// return getSession().createQuery("From project proj WHERE sprintBacklogs =
	// :sps", SprintBacklog.class)
	// .setParameter("proj", proyecto).setParameter("sps",
	// proyecto.getSprintBacklogs()).getResultList();
	//
	// }
	//
}