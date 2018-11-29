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
import ar.sarm.unq.sga.model.SprintBacklog;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.model.Usuario;
import ar.sarm.unq.sga.wicket.backlog.BacklogStore;
import ar.sarm.unq.sga.wicket.backlog.SprintBacklogStore;
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

	private String nombreSprintBacklog;

	@Autowired
	private UserStoryStore userStoryStore; // agregado

	@Autowired
	private BacklogStore backlogStore;

	@Autowired
	private UsuarioStore usuarioStore;

	@Autowired
	private ProjectStore projectStore;

	@Autowired
	private SprintBacklogStore sprintBacklogStore;

	private Backlog backlog;

	private Project proyecto;

	private Usuario user;

	private String descripcion;

	private String valorCliente;

	private int historyPoint;

	private UserStory story;
	
	private SprintBacklog sprintBacklog;
	
	private String nombreUserStory;
	

	public ProjectController() {

	}

	// public ProjectController(Project proy, Usuario usuario) {
	// projectStore.attach(proy);
	// usuarioStore.attach(usuario);
	// proyecto = proy;
	// user = usuario;
	//
	// }

	public ProjectController(UserStory user) {
		this.getSprintBacklogs();
		userStoryStore.attach(user);
		story = user;
		story.setNombre(nombreUserStory);
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
		//SprintBacklog sB = new SprintBacklog();
		Backlog back = new Backlog("Backlog");
		projectStore.agregarProject(proyecto);
		//backlogStore.agregarBacklogStore(back);
		//sprintBacklogStore.agregarSprintBacklog(sB);
		proyecto.setBacklog(back);
		//proyecto.agregarSprintBacklog(sB);
	}

	public List<Project> getProyectos() {
		return projectStore.getProyectos();
	}

	public void attach(Project proy) {
		projectStore.attach(proy);
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
		return proyecto.getBacklog().getUserStories().stream().filter(u -> u.isEstaEnBacklogSprint() == true)
				.collect(Collectors.toList());
	}

	// public int getSumatoriaDeComplejidades() {
	// return this.getListaDeUserStoryEnSprintBacklog().stream().mapToInt(u ->
	// u.getHistoryPoint()).sum();
	// }

	// public String getSumatoriaDeComlejidadesString() {
	// return Integer.toString(getSumatoriaDeComplejidades());
	// }

	public SprintBacklog getSprintBacklog() {
		return sprintBacklog;
	}

	public void setSprintBacklog(SprintBacklog sprintBacklog) {
		this.sprintBacklog = sprintBacklog;
	}

	public void crearSprintBacklog() {
		projectStore.attach(proyecto);
		sprintBacklog = new SprintBacklog();
		sprintBacklog.setNombre(nombreSprintBacklog);
		sprintBacklogStore.agregarSprintBacklog(sprintBacklog);
		sprintBacklog.setProyecto(getProyecto());
		proyecto.setSprintBacklogs(sprintBacklog);
//		projectStore.insert(proyecto);
	}

	public int getSumarComplejidad() {
	return	proyecto.getBacklog().getUserStories().stream().mapToInt(u->u.getHistoryPoint()).sum();
		
	}
    public String getNombreUserStory() {
		return nombreUserStory;
	}
	public void setNombreUserStory(String nombreUserStory) {
		this.nombreUserStory = nombreUserStory;
	}
	public List<SprintBacklog>getSprintBacklogs(){
//		return this.projectStore.getListaSprintBacklogDelProjecto(proyecto);
		projectStore.attach(proyecto);
		return this.proyecto.getSprintBacklogs();
	}
	
	
}
