package ar.sarm.unq.sga.wicket.userstory;

import java.io.Serializable;

import ar.sarm.unq.sga.model.UserStory;

public class UserStoryController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	
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
	
	public void agregarUserStory(){
		UserStory userStory=new UserStory(getNombre());
		UserStoryStore.elUnico().agregarUserStory(userStory);
		
	}
	
    
}
