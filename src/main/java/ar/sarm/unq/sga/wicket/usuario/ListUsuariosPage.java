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
import ar.sarm.unq.sga.wicket.project.ListaDeProyectosDelUsuarioPage;
import ar.sarm.unq.sga.wicket.project.ProjectController;

public class ListUsuariosPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SpringBean
	private UsuarioController usuarioController;

	@SpringBean
	private ProjectController projectController;

	private Usuario usuario;
	private Project proyecto;

	public ListUsuariosPage(Project proy) {
		this.proyecto = proy;
		tablaDeDevelopers();
		agregarUsusario();
	}

	public ListUsuariosPage() {
		tablaDeDevelopers();
		agregarUsusario();

	}

	public void tablaDeDevelopers() {
		this.add(
				new ListView<Usuario>("losUsuarios", new PropertyModel<>(this.usuarioController, "listadoDeUsuarios")) {

					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					protected void populateItem(ListItem<Usuario> item) {
						CompoundPropertyModel<Usuario> elDeveloper = new CompoundPropertyModel<>(item.getModelObject());
						item.add(new Label("nombre", elDeveloper.bind("nombre")));
						item.add(new Label("apellido", elDeveloper.bind("apellido")));
						item.add(new Link<String>("verProyectos") {

							@Override
							public void onClick() {
								setResponsePage(new ListaDeProyectosDelUsuarioPage(item.getModelObject()));
							}

						});
						item.add(new Link<String>("borrarUsuario") {

							@Override
							public void onClick() {
								ListUsuariosPage.this.usuarioController.borrarUsuario(item.getModelObject());
								// la idea es que vaya a la lista de sus
								// proyectos

							}

						});
						item.add(new Link<String>("volver") {

							@Override
							public void onClick() {
								this.setResponsePage(new HomePage());

							}

						});
						item.add(new Link<String>("agregarUsuarioAlProyecto") {

							/**
							 * 
							 */
							private static final long serialVersionUID = 1L;

							@Override
							public void onClick() {
								this.setResponsePage(new ListProjectPage(proyecto, item.getModelObject()));

							}

						});

					}

				});
	}

	public void agregarUsusario() {
		this.add(new Link<String>("agregarUsuario") {

			@Override
			public void onClick() {
				this.setResponsePage(new UsuarioPage());

			}

		});

	}
}
