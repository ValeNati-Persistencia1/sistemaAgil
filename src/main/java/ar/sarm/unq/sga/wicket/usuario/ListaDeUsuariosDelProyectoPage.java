package ar.sarm.unq.sga.wicket.usuario;

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
import ar.sarm.unq.sga.wicket.project.ListProjectPage;
import ar.sarm.unq.sga.wicket.project.ProjectController;

public class ListaDeUsuariosDelProyectoPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SpringBean
	private ProjectController projectController;

	public ListaDeUsuariosDelProyectoPage(Project project) {
		projectController.attach(project);
		projectController.setProject(project);
		tablaDeUsuarios();
		botonVolver();
	}

	public ListaDeUsuariosDelProyectoPage() {
		tablaDeUsuarios();
		botonVolver();
	}

	private void tablaDeUsuarios() {

		this.add(new ListView<Usuario>("losUsuarios", new PropertyModel<>(this.projectController, "usuarios")) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Usuario> item) {

				CompoundPropertyModel<Usuario> elUsuario = new CompoundPropertyModel<>(item.getModelObject());
				item.add(new Label("nombre", elUsuario.bind("nombreUsuario")));
				item.add(new Label("apellido", elUsuario.bind("apellido")));

			}

		});

	}

	public void botonVolver() {
		this.add(new Link<String>("volver") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListProjectPage());

			}

		});
	}

}