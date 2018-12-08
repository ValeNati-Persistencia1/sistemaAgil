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
import ar.sarm.unq.sga.model.SprintBacklog;
import ar.sarm.unq.sga.wicket.HomePage;

public class HistoriaProyectoPage extends WebPage {

	private static final long serialVersionUID = 1L;

	@SpringBean
	private ProjectController projectController;

	public HistoriaProyectoPage(Project modelObject) {
		projectController.attach(modelObject);
		projectController.setProject(modelObject);
		this.tablaSprintsAnteriores();
		this.botonCancelar();
	}

	public  void tablaSprintsAnteriores(){ 	
		this.add(new ListView<SprintBacklog>("sprintsBacklogsAnteriores",
				new PropertyModel<>(this.projectController, "sprintBacklogs")) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<SprintBacklog> item) {
				CompoundPropertyModel<SprintBacklog> sprintAnterior = new CompoundPropertyModel<>(item.getModel());
				item.add(new Label("nombre", sprintAnterior.bind("nombreSprintBacklog")));
			
				
				item.add(new Link<String>("tareasIncompletas") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
	                // this.setResponsePage(new SprintBacklogPage(proyecto, sprint));
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

}
