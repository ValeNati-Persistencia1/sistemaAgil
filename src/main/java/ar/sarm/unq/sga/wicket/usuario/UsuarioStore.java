package ar.sarm.unq.sga.wicket.usuario;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.Usuario;

@Component
public class UsuarioStore extends HomeGeneralSession<Usuario> {

	private static final long serialVersionUID = 1L;

	public List<Usuario> getUsuarios() {
		return getSession().createQuery("FROM Usuario", Usuario.class).list();
	}

	public void agregarUsuario(Usuario dev) {
		getSession().save(dev);
	}

	public void borrarUsuario(Usuario dev) {
		getSession().delete(dev);
	}

	@Override
	public Usuario findByName(String name) {
		return this.getSession().createQuery("FROM Usuario WHERE nombreUsuario = : name", Usuario.class)
				.setParameter("name", name).getSingleResult();
	}

	public List<Project> getListaDeProyectosDeUsuario(Usuario usuario) {
		return getSession().createQuery("FROM Project WHERE id = : proy", Project.class)
				.setParameter("proy", usuario.getId()).list();
	}

	public List<Usuario> getVerUsuario(Project proy) {
		Query<Usuario> query = getSession().createQuery("FROM Usuario WHERE project_id = : id", Usuario.class);
		query.setParameter("id", proy.getId());
		return query.getResultList();
	}

	public List<Usuario> getListadoDeUsaurios() {
		return getSession().createQuery("FROM Usuario", Usuario.class).list();

	}

}