package ar.sarm.unq.sga.wicket.userstory;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.model.UserStory;
@Controller
@Transactional
public class UserStoryController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String descripcion;
	@Autowired
	private UserStoryStore userStoryStore;
	private UserStory userStory;
	
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
	
	public UserStory getUserStory(){
		return userStory;
	}
//	
//	public void agregarUserStory(){
//		userStoryStore.attach(this.getUserStory());
//		userStoryStore.insert(this.getUserStory());
//	}
	
	public void agregarUserStoryALaLista(){
        UserStory us= new UserStory(getNombre());
        us.setDescripcion(descripcion);
		userStoryStore.insert(us);
	}
	public void attach(UserStory us) {
        userStoryStore.attach(us);		
	}
	public void borrarUserStory(UserStory modelObject) {
		userStoryStore.delete(modelObject);
		
	}
	public List<UserStory>getUsersStories(){
		return userStoryStore.getUsersStories();
	}
	
    
}
