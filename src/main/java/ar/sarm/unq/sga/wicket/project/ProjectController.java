package ar.sarm.unq.sga.wicket.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.wicket.model.IModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.model.Backlog;
import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.Rol;
import ar.sarm.unq.sga.model.SprintBacklog;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.model.Usuario;
import ar.sarm.unq.sga.wicket.backlog.BacklogStore;
import ar.sarm.unq.sga.wicket.backlog.SprintBacklogStore;
import ar.sarm.unq.sga.wicket.userstory.UserStoryController;
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
	private UserStoryStore userStoryStore;

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

	private Rol rol;

	private String nombreRol;

	private String nombreUserStory;

	public int sumarComplejidad;

	public ProjectController() {

	}

	public ProjectController(UserStory user) {
		userStoryStore.attach(user);
		userStory = user;
		userStory.setNombreUserStory(nombreUserStory);
	}

	public ProjectController(Project proy, SprintBacklog sprint) {
		proyecto = proy;
		sprintBacklog = sprint;
	}

	public ProjectController(Project proy) {
		projectStore.attach(proy);
		proyecto = proy;

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
		projectStore.attach(proy);
		proy.getUsuarios().forEach(us -> us.borrarProyecto(proy));
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
		if (sprintBacklog.getEstadoAbierto() == true) {
			return sprintBacklog.getListaUserStory();
		} else {
			return sprintBacklog.getListaUserStoryCompletas();
		}

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

	public int getSumarComplejidadUSCompletas() {
		return sprintBacklog.getSumatoriaComplejidadUsCompletas();
	}

	public int getSumarComplejidad() {
		return sprintBacklog.getSumatoriaComplejidad();
	}

	public void setSumarComplejidad(int sumarComplejidad) {
		this.sumarComplejidad = sumarComplejidad;
	}

	public void setNombreUserStory(String nombreUserStory) {
		this.nombreUserStory = nombreUserStory;
	}

	public List<SprintBacklog> getSprintBacklogs() {
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
		sprintBacklog.setSumatoriaComplejidad(sprintBacklog.getSumatoriaComplejidad());
	}

	public void cerrarSprintBacklog() {
		projectStore.attach(proyecto);
		sprintBacklog.setEstadoAbierto(false);
		sprintBacklog.getListaUserStoryIncompletas().forEach(us -> us.setEstaEnBacklogSprint(false));
		sprintBacklogStore.updateSprintBacklog(sprintBacklog);
	}

	public List<SprintBacklog> getSprintBacklogsAbiertos() {
		return proyecto.getSprintBacklogsAbiertos();
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public void agregarRol() {
		projectStore.attach(proyecto);
		Rol rol= new Rol();
		rol.setNombreRol(getNombreRol());
		rol.setProject(proyecto);
		proyecto.addRol(rol);
	}
	
	public List<SprintBacklog> getSprintBacklogsCerrados() {
		return proyecto.getSprintBacklogsCerrados();
	}
}
