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
    private String apellido;
    @Autowired
    private UsuarioStore usuarioStore;

	private Usuario usuario;

	private String message;
    
    public UsuarioController(){
    	
    }
    
    public UsuarioController(String nombre, String apellido){
    	this.nombre=nombre;
    	this.apellido= apellido;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void agregarUsuario(){
		Usuario dev=new Usuario(getNombre(), getApellido());
	    usuarioStore.insert(dev);
	}

	public void attach(Usuario developer) {
		usuarioStore.attach(developer);
		
	}
	
//	public List<Project>getProyectos(){
//		return developerStore.getProyectos(getApellido());
//	}
    
	public Usuario findByName() {
		try {
			this.setMessage(null);
			usuario = usuarioStore.findByName(getNombre());
		} catch (Exception e) {
			setMessage("no existe el objeto");// TODO: handle exception
			usuario = null;
		}
		return usuario;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Usuario>getUsuarios(){
		return usuarioStore.getUsuarios();
	}

	public void borrarUsuario(Usuario dev) {
		usuarioStore.borrarUsuario(dev);
		
	}
}