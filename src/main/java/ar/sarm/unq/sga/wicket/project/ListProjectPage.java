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
import ar.sarm.unq.sga.wicket.backlog.CrearSprintBacklogPage;
import ar.sarm.unq.sga.wicket.backlog.ListUsersStoriesEnBacklogPage;
import ar.sarm.unq.sga.wicket.backlog.ListaDeSprintBacklogDeUnProyecto;
import ar.sarm.unq.sga.wicket.userstory.UserStoryController;
import ar.sarm.unq.sga.wicket.userstory.UserStoryPage;
import ar.sarm.unq.sga.wicket.usuario.ListUsuariosPage;
import ar.sarm.unq.sga.wicket.usuario.ListaDeUsuariosDelProyectoPage;
import ar.sarm.unq.sga.wicket.usuario.UsuarioController;

public class ListProjectPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SpringBean
	private ProjectController projectController;
	@SpringBean
	protected UsuarioController usuarioController;
	@SpringBean
	private UserStoryController userStoryController;
	private Usuario user;
	private Project proyecto;

//	public ListProjectPage(Usuario usuario, Project proy) {
//		user = usuario;
//		proyecto = proy;
//		this.usuarioController.attach(usuario);
//		this.projectController.setUsuario(usuario);
//		this.projectController.setProject(proy);
//		tablaDeProyectos();
//		botonCancelar();
//		botonAgregar();
//	}

	public ListProjectPage(Usuario usuario) {
		user = usuario;
		this.usuarioController.attach(usuario);
		this.projectController.setUsuario(usuario);
		tablaDeProyectos();
		botonCancelar();
		botonAgregar();
	}

	public ListProjectPage() {
		tablaDeProyectos();
		botonCancelar();
		botonAgregar();

	}

	public ListProjectPage(Project proy) {
		proyecto = proy;
		projectController.attach(proy);
		projectController.setProject(proyecto);
		tablaDeProyectos();
		botonCancelar();
		botonAgregar();
	}

	private void tablaDeProyectos() {

		this.add(new ListView<Project>("losProyectos", new PropertyModel<>(this.projectController, "proyectos")) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Project> item) {

				CompoundPropertyModel<Project> elProyecto = new CompoundPropertyModel<>(item.getModelObject());
				item.add(new Label("nombre", elProyecto.bind("nombre")));
				item.add(new Link<String>("verBacklog") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						this.setResponsePage(new ListUsersStoriesEnBacklogPage(item.getModelObject()));
					}
				});
				item.add(new Link<String>("verUsuarios") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						this.setResponsePage(new ListaDeUsuariosDelProyectoPage(item.getModelObject()));
					}

				});

				item.add(new Link<String>("borrarProyecto") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						ListProjectPage.this.projectController.borrarProyecto(item.getModelObject());
						this.setResponsePage(new ProjectPage());
					}

				});

				item.add(new Link<String>("agregarUserStory") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						this.setResponsePage(new UserStoryPage(item.getModelObject()));
					}

				});
				item.add(new Link<String>("verListaSprintBacklog") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						this.setResponsePage(new ListaDeSprintBacklogDeUnProyecto(item.getModelObject()));
					}

				});
				item.add(new Link<String>("agregarProyectoAlUsuario") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						setResponsePage(new ListUsuariosPage(item.getModelObject()));
					}

				});
				item.add(new Link<String>("agregarSprintBacklog") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						this.setResponsePage(new CrearSprintBacklogPage(item.getModelObject()));
					}

				});
				item.add(new Link<String>("historiaProyecto") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						this.setResponsePage(new HistoriaProyectoPage(item.getModelObject()));
					}

				});
				
			}

		});

	}

	public void botonCancelar() {
		this.add(new Link<String>("cancelar") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new HomePage());

			}

		});
	}

	public void botonAgregar() {
		this.add(new Link<String>("agregarProyecto") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new ProjectPage());

			}

		});

	}
}
