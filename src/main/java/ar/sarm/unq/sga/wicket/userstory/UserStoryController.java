package ar.sarm.unq.sga.wicket.userstory;

import java.awt.Button;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.AttributeModifier;
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
import ar.sarm.unq.sga.wicket.BotonConfirmar;
import ar.sarm.unq.sga.wicket.backlog.BacklogStore;
import ar.sarm.unq.sga.wicket.project.ProjectStore;
import ar.sarm.unq.sga.wicket.usuario.UsuarioStore;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class UserStoryController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombreUserStory;
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

	public boolean camposCompletos = false;

	public UserStoryController() {

	}

	public UserStoryController(Project proy) {
		// projectStore.attach(proy);
		story.setProject(proy);
		project = proy;

	}

	public boolean isCamposCompletos() {
		return camposCompletos;
	}

	public UserStoryController(String nombre) {
		this.nombreUserStory = nombre;
	}

	public String getNombre() {
		return nombreUserStory;
	}

	public void setNombre(String nombre) {
		this.nombreUserStory = nombre;
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

	// public void agregarUserStoryALaLista() {
	// UserStory us = new UserStory(getNombre());
	// us.setDescripcion(descripcion);
	// us.setValorCliente(valorCliente);
	// us.setHistoryPoint(historyPoint);
	// // us.setUsuario(usuario);
	// userStoryStore.insert(us);
	// project.getBacklog().setUserStory(us);
	// us.setProject(project);
	// us.setBacklog(project.getBacklog());
	//
	//
	// }

	public void agregarUserStoryALaLista() {
		if (!(descripcion == null && valorCliente == null && historyPoint == 0 && rol == null)) {
			// this.camposCompletos=false;
			story = new UserStory(getNombre());
			story.setDescripcion(descripcion);
			story.setValorCliente(valorCliente);
			story.setHistoryPoint(historyPoint);
			story.setUsuario(usuario);
			usuario.setNombreUsuario(this.getNombreDeUsuario());
			rol.setNombreRol(getNombreRol());
			story.setRol(rol);
			project.getBacklog().setUserStory(story);
			story.setProject(project);
			story.setBacklog(project.getBacklog());
			userStoryStore.insert(story);
		}
	}

	public String getNombreRol() {
		return rol.getNombreRol();
	}

	public String getNombreDeUsuario() {
		return usuario.getNombreUsuario();

	}

	public void attach(UserStory us) {
		userStoryStore.attach(us);
	}

	public void agregarUserStoryABacklog(UserStory modelObject) {
		userStoryStore.insert(modelObject);
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}


	public void completarUserStory(UserStory modelObject) {
		userStoryStore.attach(modelObject);
		modelObject.setEstaCompleta(true);

	}

	public String getNombreDelSprintBacklogQueEstaLaUS() {
		return story.getSprintBacklog().getNombreSprintBacklog();
	}

	public int getTotal() {
		return this.getListaDeUserStoryEnSprintBacklog().stream().mapToInt(us -> us.getHistoryPoint()).sum();
	}

	public Rol getRol() {
		return rol;
	}

	public List<Usuario> getUsuarios() {
		return project.getUsuarios();
	}

	public List<Rol> getRoles() {
		return project.getRoles();

	}


}
