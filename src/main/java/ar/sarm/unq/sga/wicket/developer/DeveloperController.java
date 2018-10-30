package ar.sarm.unq.sga.wicket.developer;

import java.io.Serializable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.model.Developer;
import ar.sarm.unq.sga.model.Persistible;
@Controller
@Transactional
public class DeveloperController<T extends Persistible> implements Serializable {

	private static final long serialVersionUID = 1L;

    private String nombre;
    @Autowired
    private DeveloperStore developerStore;
    
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
//        developerStore.insert(developer);
//        developerStore.attach(developer);
		developerStore.agregarDeveloper(developer);
	}
//	public List<Developer>getDevelopers(){
//		return
//	}
    
    
}
