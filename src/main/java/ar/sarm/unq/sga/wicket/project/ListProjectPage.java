package ar.sarm.unq.sga.wicket.project;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import ar.sarm.unq.sga.model.Project;

public class ListProjectPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProjectController projectController;

	public ListProjectPage() {
		tablaDeProyectos();
		botonCancelar();
		botonVolver();
	}

	private void tablaDeProyectos() {
		this.add(new ListView<Project>("lasProyectos", new PropertyModel<>(this.projectController, "proyectos")) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Project> item) {

				CompoundPropertyModel<Project> elProyecto = new CompoundPropertyModel<>(item.getModelObject());
				item.add(new Label("nombre", elProyecto.bind("nombre")));

				item.add(new Link<String>("detalleProyecto") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						// this.setResponsePage(new
						// DetalleProyecto(item.getModelObject()));
					}

				});

				item.add(new Link<String>("addBacklog") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						// this.setResponsePage(new Backlog());;
					}

				});

				item.add(new Link<String>("listaBacklog") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						// this.setResponsePage(new ListaBacklog());;
					}

				});
				
				item.add(new Link<String>("agregarProyecto"){

					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
//						this.setResponsePage(new ProjectPage());
						
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
//				this.setResponsePage(new ListProjectPage());

			}

		});
	}

	public void botonCancelar() {
		this.add(new Link<String>("cancelar") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
//				this.setResponsePage(new ListProjectPage());

			}

		});
	}
}