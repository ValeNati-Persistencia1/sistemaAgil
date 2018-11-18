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

@Service
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class UserStoryController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String descripcion;
	private String valorCliente;
	private String historyPoint;
	@Autowired
	private UserStoryStore userStoryStore;
	private UserStory userStory;
	private Project project;
	
	
	public UserStoryController(){
		
	}
	public UserStoryController(String nombre){
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion=descripcion;
	}
	
	public String getValorCliente() {
		return valorCliente;
	}
	
	public void setValorCliente(String valorCliente) {
		this.valorCliente = valorCliente;
	}
	
	public String getHistoryPoint() {
		return historyPoint;
	}
	
	public void setHistoryPoint(String historyPoint) {
		this.historyPoint = historyPoint;
	}
	
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	public void agregarUserStoryALaLista(){
        UserStory us= new UserStory(getNombre());
        us.setDescripcion(descripcion);
        us.setValorCliente(valorCliente);
        us.setHistoryPoint(historyPoint);
		userStoryStore.insert(us);
	}
	public void attach(UserStory us) {
        userStoryStore.attach(us);		
	}
	
	public void borrarUserStory(UserStory modelObject) {
		userStoryStore.delete(modelObject);	
	}
	
	public void agregarUserStoryABacklog(UserStory modelObject){
		userStoryStore.insert(modelObject);
	}
	
	public List<UserStory>getUsersstories(){
		return userStoryStore.getUsersstories();
	}
	
	public UserStory getUserStory() {
		return userStory;
	}
	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}
	
	
    
}
