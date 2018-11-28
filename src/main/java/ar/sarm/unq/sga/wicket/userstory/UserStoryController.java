package ar.sarm.unq.sga.wicket.userstory;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.model.Usuario;
import ar.sarm.unq.sga.wicket.backlog.BacklogStore;
import ar.sarm.unq.sga.wicket.project.ProjectStore;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class UserStoryController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String descripcion;
	private String valorCliente;
	private int historyPoint;
	private Usuario usuario;

	@Autowired
	private UserStoryStore userStoryStore;
	private UserStory user;
	private Project project;

	@Autowired
	private ProjectStore projectStore;

	@Autowired
	private BacklogStore backlogStore;

	public UserStoryController() {

	}

	public UserStoryController(UserStory userStory) {
		userStoryStore.attach(userStory);
		user = userStory;
		setUserStory(userStory);

	}

	public UserStoryController(Project proy) {
		projectStore.attach(proy);
		user.setProject(proy);
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
		UserStory us = new UserStory(getNombre());
		us.setDescripcion(descripcion);
		us.setValorCliente(valorCliente);
		us.setHistoryPoint(historyPoint);
		// us.setUsuario(usuario);
		userStoryStore.insert(us);
		project.getBacklog().setUserStory(us);
		us.setProject(project);
		us.setBacklog(project.getBacklog());

		// agregue ultima linea para la lista de proyecto
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
		return user;
	}

	public void setUserStory(UserStory userStory) {
		this.user = userStory;
	}

	public List<UserStory> getListaDeUserStoryEnSprintBacklog() {
		return projectStore.getListaDeUserStoryEnSprintBacklog();
	}

	// public int getComplejidad() {
	// return userStoryStore.getTotalComplejidad();
	// }

	public void borrarUserStoryDeListaEnBacklog() {
		userStoryStore.delete(user);

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/// no tocar funciona
	public void agregarUsertStorieEnSprintBacklog(UserStory modelObject) {
		userStoryStore.attach(modelObject);
	//	modelObject.setEstaEnBacklogSprint(true);

	}

	public void completarUserStory(UserStory modelObject) {
		userStoryStore.attach(modelObject);
		modelObject.setEstaCompleta(true);

	}

	// public TipoDeRol getTipoDeRol() {
	// return tipoDeRol;
	// }
	//
	// public void setTipoDeRol(TipoDeRol tipoDeRol) {
	// this.tipoDeRol = tipoDeRol;
	// }

}
