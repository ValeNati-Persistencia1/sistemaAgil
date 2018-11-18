package ar.sarm.unq.sga.wicket.project;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.Usuario;
import ar.sarm.unq.sga.wicket.HomePage;
import ar.sarm.unq.sga.wicket.usuario.ListUsuariosPage;
import ar.sarm.unq.sga.wicket.usuario.ListaDeUsuariosDelProyectoPage;
import ar.sarm.unq.sga.wicket.usuario.UsuarioController;

public class ListaDeProyectosDelUsuarioPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@SpringBean
	private UsuarioController usuarioController;

	public ListaDeProyectosDelUsuarioPage(Usuario usuario) {
		usuarioController.setUsuario(usuario);
		tablaDeProyectosDelUsuario();
		volver();
		salir();
	}

	public ListaDeProyectosDelUsuarioPage() {
		tablaDeProyectosDelUsuario();
		volver();
		salir();
	}

	//
	//
	public void tablaDeProyectosDelUsuario() {
		this.add(new ListView<Project>("losProyectos",
				new PropertyModel<>(this.usuarioController, "listaDeProyectosDelUsuario")) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Project> item) {
				CompoundPropertyModel<Project> elProyecto = new CompoundPropertyModel<>(item.getModelObject());
				item.add(new Label("nombre", elProyecto.bind("nombre")));

			}
		});

	}

	public void volver() {
		this.add(new Link<String>("volver") {

			@Override
			public void onClick() {
				setResponsePage(new ListUsuariosPage());
			}

		});

	}

	public void salir() {
		this.add(new Link<String>("salir") {

			@Override
			public void onClick() {
				setResponsePage(new HomePage());
			}

		});
	}

}