package ar.sarm.unq.sga.wicket.backlog;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.springframework.beans.factory.annotation.Autowired;

import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.wicket.project.ProjectPage;
import ar.sarm.unq.sga.wicket.userstory.UserStoryController;

public class SprintBacklogPage extends WebPage {

	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	private UserStoryController controller;
	
	
	
	public SprintBacklogPage(){
		this.agregarAUserStoryFormBacklogsCompletadas();
	}

	public void agregarAUserStoryFormBacklogsCompletadas() {
		//this.add(new ListView<UserStory>("sublistaBacklogsCompletados",new PropertyModel<>(this.controller, "backlogsCompletados")){
    this.add(new ListView<UserStory>("sublistaSprintBacklogCompletados",new PropertyModel<>(this.controller, "backlogsCompletados")) {
	
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<UserStory> item) {
				CompoundPropertyModel<UserStory> backlogCompletado = new CompoundPropertyModel<>(item.getModel());
				item.add(new Label("nombre", backlogCompletado.bind("nombre")));

				item.add(new Link<String>("borrarBacklog") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						//this.setResponsePage(new UserStory(item.getModelObject()));
						//this.setResponsePage(new EliminarBacklogPage(item.getModelObject()));
					}

				});
				
			item.add(new Link<String>("sacarDeSublistaBacklogsCompletados"){

				private static final long serialVersionUID = 1L;

				@Override
				public void onClick() {
					//this.setResponsePage(new UserStory(item.getModelObject()));
					//this.setResponsePage(new SacarBacklogsCompletadosPage(item.getModelObject()));
					
				}
				
			});
			}
		});
	
		this.add(new Link<String>("salir") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
			//	this.setResponsePage(new BacklogPage());
				this.setResponsePage(new ProjectPage());

			}

		});
	}

}
