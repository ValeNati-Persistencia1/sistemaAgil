package ar.sarm.unq.sga.wicket.usuario;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.model.Usuario;
import ar.sarm.unq.sga.model.Project;
@Controller
@Transactional
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

    private String nombre;
    @Autowired
    private UsuarioStore usuarioStore;
    
    public UsuarioController(){
    	
    }
    
    public UsuarioController(String nombre){
    	this.nombre=nombre;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public void agregarUsuario(){
		Usuario dev=new Usuario(getNombre());
	    usuarioStore.insert(dev);
	}
	
//	public List<Project> getProyectos(){
//		return getDeveloper().getProyectos();
//	}
    
    
}
