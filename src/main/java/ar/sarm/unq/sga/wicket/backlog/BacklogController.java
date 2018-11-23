package ar.sarm.unq.sga.wicket.backlog;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.model.Backlog;
import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.wicket.project.ProjectStore;
import ar.sarm.unq.sga.wicket.userstory.UserStoryController;
import ar.sarm.unq.sga.wicket.userstory.UserStoryStore;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class BacklogController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Project proyecto;

	private String nombreBacklog;

	@Autowired
	private BacklogStore backlogStore;

	@Autowired
	private ProjectStore projectStore;

	private UserStoryController userStoryController;

	private UserStory userStory;

	private Backlog backlog;

	private Object back;
	private String message;

	private UserStoryStore userStoryStore;

	protected List<UserStory> usersstories;

	public BacklogController(Project proy) {
		Project proyecto = proy;
		Backlog back = proy.getBacklog();
		backlogStore.attach(back);
	}

	public BacklogController(Backlog back) {
		usersstories = back.getUserStories();
		backlogStore.attach(backlog);
	}

	public BacklogController() {

	}

	public String getNombre() {
		return nombreBacklog;
	}

	public void setNombre(String nombre) {
		this.nombreBacklog = nombre;
	}

	public Backlog findByName() {
		try {
			this.setMessage(null);
			Backlog back = backlogStore.findByName(getNombre());
		} catch (Exception e) {
			setMessage("no existe el objeto");// TODO: handle exception
			back = null;
		}
		return (Backlog) back;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Project getProyecto() {
		return proyecto;
	}

	public void setProyecto(Project proyecto) {
		this.proyecto = proyecto;
	}

	public String getNombreBacklog() {
		return nombreBacklog;
	}

	public void setNombreBacklog(String nombreBacklog) {
		this.nombreBacklog = nombreBacklog;
	}

	public UserStory getUserStory() {
		return userStory;
	}

	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}

	private Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}

	public void attach(Backlog backlog) {
		backlogStore.attach(backlog);
	}

	public List<UserStory> getUsersstories() {
		return userStoryController.getUsersstories();
	}

	public void borrarUserStoryDeListaEnBacklog(UserStory us) {
		this.usersstories.remove(us);

	}
	
}
