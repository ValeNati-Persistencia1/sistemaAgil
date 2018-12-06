package ar.sarm.unq.sga.wicket.userstory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.Rol;
import ar.sarm.unq.sga.model.SprintBacklog;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.model.Usuario;
import ar.sarm.unq.sga.wicket.backlog.BacklogStore;
import ar.sarm.unq.sga.wicket.project.ProjectStore;
import ar.sarm.unq.sga.wicket.usuario.UsuarioStore;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class UserStoryController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String descripcion;
	private String valorCliente;
	private int historyPoint;
	private Rol rol;
    private Usuario usuario;
	@Autowired
	private UserStoryStore userStoryStore;
	private UserStory story;
	private Project project;
	@Autowired
	private ProjectStore projectStore;
	@Autowired
    private UsuarioStore usuarioStore;
	@Autowired
	private BacklogStore backlogStore;

	private String nombreRol;
	private List<Rol> roles = new ArrayList<> ();
	
	public UserStoryController() {

	}

	public UserStoryController(UserStory userStory) {
		userStoryStore.attach(userStory);
		story = userStory;
		setUserStory(userStory);

	}

	public UserStoryController(Project proy) {
		projectStore.attach(proy);
		story.setProject(proy);
		project = proy;

	}

	public UserStoryController(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValorCliente() {
		return valorCliente;
	}

	public void setValorCliente(String valorCliente) {
		this.valorCliente = valorCliente;
	}

	public int getHistoryPoint() {
		return historyPoint;
	}

	public void setHistoryPoint(int historyPoint) {
		this.historyPoint = historyPoint;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void agregarUserStoryALaLista() {
		story= new UserStory(getNombre());
		story.setDescripcion(descripcion);
		story.setValorCliente(valorCliente);
		story.setHistoryPoint(historyPoint);
		story.setUsuario(usuario);
		usuario.setNombreUsuario(this.getNombreUsuario());
        story.setRol(rol);
        rol.setNombreRol(this.getNombreRol());
		project.getBacklog().setUserStory(story);
		story.setProject(project);
		story.setBacklog(project.getBacklog());
		userStoryStore.insert(story);
	}
	
	
	public void attach(UserStory us) {
		userStoryStore.attach(us);
	}

	public void borrarUserStory(UserStory modelObject) {
		userStoryStore.delete(modelObject);
	}

	public void agregarUserStoryABacklog(UserStory modelObject) {
		userStoryStore.insert(modelObject);
	}

	public List<UserStory> getUsersstories() {
		return userStoryStore.getListaDeUserStory();
	}

	public UserStory getUserStory() {
		return story;
	}

	public void setUserStory(UserStory userStory) {
		this.story = userStory;
	}

	public List<UserStory> getListaDeUserStoryEnSprintBacklog() {
		return projectStore.getListaDeUserStoryEnSprintBacklog();
	}

	public void borrarUserStoryDeListaEnBacklog() {
		userStoryStore.delete(story);

	}


	// public void agregarUsertStorieEnSprintBacklog(UserStory modelObject) {
	// userStoryStore.attach(modelObject);
	// modelObject.setEstaEnBacklogSprint(true);
	//
	// }
//	public void agregarUsertStorieEnSprintBacklog(Project proy, UserStory modelObject) {
//		userStoryStore.attach(modelObject);
//		projectStore.attach(proy);
//		modelObject.setEstaEnBacklogSprint(true);
//
//	}

	public void completarUserStory(UserStory modelObject) {
		userStoryStore.attach(modelObject);
		modelObject.setEstaCompleta(true);

	}

	public String getNombreDelSprintBacklogQueEstaLaUS() {
		return story.getSprintBacklog().getNombreSprintBacklog();
	}
	

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Rol>getRoles(){
		return project.getRoles();
	}
	
	public List<Usuario>getUsuarios(){
		return this.project.getUsuarios();
	}

	public String getNombreRol() {
		return this.nombreRol;
	}

	public String getNombreUsuario() {
		return this.usuario.getNombreUsuario();
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	

	
	
	
}

