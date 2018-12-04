package ar.sarm.unq.sga.wicket.project;

import java.io.Serializable;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;

import org.apache.wicket.model.IModel;
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

	private UserStory userStory;

	private SprintBacklog sprintBacklog;

	private String nombreUserStory;

	public ProjectController() {

	}

	public ProjectController(UserStory user) {
		this.getSprintBacklogs();
		userStoryStore.attach(user);
		userStory = user;
		userStory.setNombreUserStory(nombreUserStory);
	}

	public ProjectController(Project proy, SprintBacklog sprint) {
		proyecto = proy;
		sprintBacklog = sprint;
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

	public void agregarProyecto() {
		Project proyecto = new Project(getNombre());
		Backlog back = new Backlog("Backlog");
		projectStore.agregarProject(proyecto);
		proyecto.setBacklog(back);
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
				return projectStore.getListaUsEnSpBacklog(sprintBacklog);
	}

	public SprintBacklog getSprintBacklog() {
		return sprintBacklog;
	}

	public void setSprintBacklog(SprintBacklog sprintBacklog) {
		this.sprintBacklog = sprintBacklog;
	}

	public void crearSprintBacklog() {
		projectStore.attach(proyecto);
		sprintBacklog = new SprintBacklog();
		sprintBacklog.setNombreSprintBacklog(nombreSprintBacklog);
		sprintBacklogStore.agregarSprintBacklog(sprintBacklog);
		sprintBacklog.setProyecto(getProyecto());
		proyecto.setSprintBacklogs(sprintBacklog);
	}

	public int getSumarComplejidad() {
		return getListaDeUserStoryEnSprintBacklog().stream().mapToInt(us->us.getHistoryPoint()).sum();
	}

	public int getSumarComplejidadUSCompletas() {
		return getListaDeUserStoryEnSprintBacklog().stream().filter(us -> us.estaCompleta == true)
				.collect(Collectors.toList()).stream().mapToInt(us -> us.getHistoryPoint()).sum();

	}

	//// no anda no muestra el nombre!!!
	// public String getNombreUserStory() {
	//// return nombreUserStory;
	// return proyecto.getBacklog().getUserStory().getNombreUserStory();
	//
	// }

	public void setNombreUserStory(String nombreUserStory) {
		this.nombreUserStory = nombreUserStory;
	}

	public List<SprintBacklog> getSprintBacklogs() {
		// projectStore.attach(proyecto);
		return this.proyecto.getSprintBacklogs();
	}

	public String getNombreSprintBacklog() {
		return nombreSprintBacklog;
	}

	public void setNombreSprintBacklog(String nombreSprintBacklog) {
		this.nombreSprintBacklog = nombreSprintBacklog;
	}

	public void agregarUsertStorieEnSprintBacklog(UserStory userStory2) {
		projectStore.attach(proyecto);
		userStory2.setProject(getProyecto());
		userStory2.setEstaEnBacklogSprint(true);
		userStory2.setSprintBacklog(sprintBacklog);
        
	}
	public List<UserStory>getListaDeUserStoryEnSprintBacklogIncompletas(){
		return projectStore.getListaDeUserStoryEnSprintBacklogIncompletas();
	}


	public void cerrar(){
	projectStore.attach(proyecto);	
	projectStore.getListaDeUserStoryEnSprintBacklogIncompletas().forEach(us->us.setBacklog(null));
	projectStore.getListaDeUserStoryEnSprintBacklog().forEach(us->us.getSprintBacklog().setEstado(false));
		
	}
	

}
