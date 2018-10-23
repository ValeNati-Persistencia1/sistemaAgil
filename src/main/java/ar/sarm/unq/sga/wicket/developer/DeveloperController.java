package ar.sarm.unq.sga.wicket.developer;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.sarm.unq.sga.home.Home;
import ar.sarm.unq.sga.model.Developer;
import ar.sarm.unq.sga.model.Persistible;

public class DeveloperController<T extends Persistible> implements Serializable {

	private static final long serialVersionUID = 1L;

    private String nombre;
    @Autowired
    private Home<Developer>developerStore;
    private T result;
    
    public DeveloperController(){
    	
    }
    
    public DeveloperController(String nombre){
    	this.nombre=nombre;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public void agregarDeveloper(){
		Developer developer=new Developer(getNombre());
        developerStore.insert(developer);
        developerStore.attach(developer);
	}
//	public List<Developer>getDevelopers(){
//		return
//	}
    
    
}
