package ar.sarm.unq.sga.wicket.developer;

import java.io.Serializable;

import ar.sarm.unq.sga.model.Developer;

public class DeveloperController implements Serializable {

	private static final long serialVersionUID = 1L;

    private String nombre;
    
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
		Developer developer=new Developer();
		DeveloperStore.elUnico().agregarDeveloper(developer);
	}
    
    
}
