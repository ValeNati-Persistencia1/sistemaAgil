package ar.sarm.unq.sga.wicket.developer;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.model.Developer;
import ar.sarm.unq.sga.model.Project;
@Controller
@Transactional
public class DeveloperController implements Serializable {

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
		Developer dev=new Developer(getNombre());
	    developerStore.insert(dev);
	}
	
//	public List<Project> getProyectos(){
//		return getDeveloper().getProyectos();
//	}
    
    
}
