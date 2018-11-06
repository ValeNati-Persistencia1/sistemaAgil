package ar.sarm.unq.sga.wicket.usuario;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.Usuario;
@Component
public class UsuarioStore extends HomeGeneralSession<Usuario>{

	private static final long serialVersionUID = 1L;


	public List<Usuario> getDevelopers() {
		return getSession().createQuery("FROM Developer", Usuario.class).list();
	}
	
   
    
    @Override
    public Usuario findByName(String name) {
	    return null;
    }
}
