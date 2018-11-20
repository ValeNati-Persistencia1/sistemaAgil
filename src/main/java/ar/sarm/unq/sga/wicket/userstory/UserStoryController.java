package ar.sarm.unq.sga.wicket.userstory;

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
import ar.sarm.unq.sga.wicket.project.ProjectController;
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
	@Autowired
	private UserStoryStore userStoryStore;
	private UserStory userStory;
	private Project project;
	@Autowired
	private ProjectStore projectStore;


	public UserStoryController() {

	}
	public UserStoryController(UserStory user) {
		userStoryStore.attach(user);
		userStory=user;
		

	}
	public UserStoryController(Project proy) {
		projectStore.attach(proy);
		project=proy;

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
		userStoryStore.insert(us);
		project.getBacklog().setUserStory(us);
		us.setProject(project);
		us.setBacklog(project.getBacklog());
		//agregue ultima linea para la lista de proyecto
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
		return userStory;
	}

	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}

	public void agregarUsertStorieEnSprintBacklog(UserStory user) {
		//Backlog back = new Backlog("Backlog/sprint");
		user.setEstaEnBacklogSprint(true);
		
		
		

	}
	public List<UserStory>getListaDeUserStoryEnSprintBacklog(){
		return userStoryStore.getListaDeUserStoryEnSprintBacklog();
	}
	
	public int getComplejidad(){
		return userStoryStore.getTotalComplejidad();
	}
}
