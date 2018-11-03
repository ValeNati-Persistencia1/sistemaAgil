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

public class ListProjectPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SpringBean
	private ProjectController projectController;

	public ListProjectPage(Project proy) {
		projectController.attach(proy);
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
//				item.add(new Link<String>("detalleProyecto") {
//					private static final long serialVersionUID = 1L;
//
//					@Override
//					public void onClick() {
//						this.setResponsePage(new BacklogPage(item.getModelObject()));
//					}
//
//				});

//				 item.add(new Link<String>("addBacklog") {
//				 private static final long serialVersionUID = 1L;
//				
//				 @Override
//				 public void onClick() {
//				  this.setResponsePage(new BacklogPage());;
//				 }
				
//				 });

//				item.add(new Link<String>("listaBacklog") {
//					private static final long serialVersionUID = 1L;
//
//					@Override
//					public void onClick() {
////						this.setResponsePage(new AddBacklogPage());
//						;
//					}
//
//				});
				
				item.add(new Link<String>("borrarProyecto") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						ListProjectPage.this.projectController.borrarProyecto(item.getModelObject());
						this.setResponsePage(new ListProjectPage());
					}

				});

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