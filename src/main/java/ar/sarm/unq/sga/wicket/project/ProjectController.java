package ar.sarm.unq.sga.wicket.project;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.model.Backlog;
import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.model.Usuario;
import ar.sarm.unq.sga.wicket.backlog.BacklogStore;
import ar.sarm.unq.sga.wicket.userstory.UserStoryStore;
import ar.sarm.unq.sga.wicket.usuario.UsuarioStore;

@Controller
@Transactional
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProjectController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	@Autowired
	private UserStoryStore userStoryStore; // agregado

	@Autowired
	private BacklogStore backlogStore;

	@Autowired
	private UsuarioStore usuarioStore;

	@Autowired
	private ProjectStore projectStore;

	private Backlog backlog;

	private Project proyecto;

	private String message;

	private Usuario user;

	private String descripcion;

	private String valorCliente;

	private int historyPoint;

	private UserStory story;

	public ProjectController() {

	}

	public ProjectController(Project proy, Usuario usuario) {
		projectStore.attach(proy);
		usuarioStore.attach(usuario);
		proyecto = proy;
		user = usuario;

	}

	public ProjectController(UserStory user) {
		userStoryStore.attach(user);
		story = user;
	}

	public ProjectController(String name) {
		this.nombre = name;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// arreglado con leo
	public void agregarProyecto() {
		Project proyecto = new Project(getNombre());
		Backlog back = new Backlog("Backlog");
		projectStore.agregarProject(proyecto);
		backlogStore.agregarBacklogStore(back);
		proyecto.setBacklog(back);
	}

	public List<Project> getProyectos() {
		return projectStore.getProyectos();
	}

	public Project findByName() {
		try {
			this.setMessage(null);
			proyecto = projectStore.findByName(getNombre());
		} catch (Exception e) {
			setMessage("no existe el objeto");// TODO: handle exception
			proyecto = null;
		}
		return proyecto;
	}

	public void attach(Project proy) {
		projectStore.attach(proy);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Backlog getBacklog() {
		return proyecto.getBacklog();
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}

	public String nombreBacklog() {
		return this.proyecto.getBacklog().getNombre();
	}

	public void borrarProyecto(Project proy) {
		projectStore.deleteProject(proy);

	}

	public List<Usuario> getUsuarios() {
		projectStore.attach(proyecto);
		return proyecto.getUsuarios();
		// return usuarioStore.getVerUsuario(getProyecto());
	}

	public void agregarProyectoAlUsuario(Usuario modelObject, Project proy) {
		projectStore.attach(proy);
		usuarioStore.attach(modelObject);
		proy.setUsuario(modelObject);
		modelObject.addProyecto(proy);
	}

	public Project getProyecto() {
		return proyecto;
	}

	public void setProject(Project proy) {
		proyecto = proy;

	}

	public List<UserStory> getListaDeUserStoryDelProyecto() {
		return proyecto.getBacklog().getUserStories().stream().filter(u -> u.isEstaEnBacklogSprint() == false)
				.collect(Collectors.toList());
	}

	public void setUsuario(Usuario usuario) {
		user = usuario;

	}

	public List<UserStory> getListaDeUserStoryEnSprintBacklog() {
		// return getListaDeUserStoryDelProyecto().stream().filter(u ->
		// u.isEstaEnBacklogSprint() == true)
		// .collect(Collectors.toList());
		return proyecto.getBacklog().getUserStories().stream().filter(u -> u.isEstaEnBacklogSprint() == true)
				.collect(Collectors.toList());
	}

}
