package ar.sarm.unq.sga.wicket.userstory;

import java.io.Serializable;

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
	public UserStory getUserStory(){
		return userStory;
	}
//	
//	public void agregarUserStory(){
//		userStoryStore.attach(this.getUserStory());
//		userStoryStore.insert(this.getUserStory());
//	}
	
	public void agregarUserStory(){
        UserStory us= new UserStory(getNombre());
		userStoryStore.insert(us);
	}
	
    
}
