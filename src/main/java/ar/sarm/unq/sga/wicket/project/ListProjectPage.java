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
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 8a7d54169c7d1e0e3ea9a616f849a1c0fb25c324
import ar.sarm.unq.sga.wicket.HomePage;
import ar.sarm.unq.sga.wicket.usuario.ListUsuariosPage;
<<<<<<< HEAD
=======
import ar.sarm.unq.sga.wicket.usuario.UsuarioPage;
=======
import ar.sarm.unq.sga.wicket.userstory.UserStoryPage;
>>>>>>> d99656b8b1b15837ddbbe47da59d961673fa22fd
>>>>>>> 8a7d54169c7d1e0e3ea9a616f849a1c0fb25c324

public class ListProjectPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SpringBean
	private ProjectController projectController;

	public ListProjectPage(Project proy) {
		projectController.attach(proy);
		Project proj = proy;
		tablaDeProyectos();
		// botonCancelar();
		botonVolver();
		botonAgregar();
	}

	public ListProjectPage() {
		tablaDeProyectos();
		// botonCancelar();
		botonVolver();
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
						ListProjectPage.this.projectController.getBacklog(item.getModelObject());
						this.setResponsePage(new HomePage());
					}

				});

				item.add(new Link<String>("verUsuarios") {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						ListProjectPage.this.projectController.mostrarUsuarios(item.getModelObject());
						this.setResponsePage(new ListUsuariosPage());
					}

				});

				item.add(new Link<String>("borrarProyecto") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						ListProjectPage.this.projectController.borrarProyecto(item.getModelObject());
						this.setResponsePage(new ListProjectPage());
					}

				});
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 8a7d54169c7d1e0e3ea9a616f849a1c0fb25c324

				item.add(new Link<String>("agregarUserStory") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
					}

				});
				item.add(new Link<String>("listaUserStory") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
					}

				});

<<<<<<< HEAD
=======
=======
				
>>>>>>> d99656b8b1b15837ddbbe47da59d961673fa22fd
>>>>>>> 8a7d54169c7d1e0e3ea9a616f849a1c0fb25c324
			}

		});

	}

	public void botonVolver() {
		this.add(new Link<String>("volver") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				// this.setResponsePage(new ListProjectPage());

			}

		});
	}

	// public void botonCancelar() {
	// this.add(new Link<String>("cancelar") {
	//
	// private static final long serialVersionUID = 1L;
	//
	// @Override
	// public void onClick() {
	// // this.setResponsePage(new ListProjectPage());
	//
	// }
	//
	// });
	// }

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