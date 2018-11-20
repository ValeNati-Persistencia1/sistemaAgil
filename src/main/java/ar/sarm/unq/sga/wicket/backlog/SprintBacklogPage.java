package ar.sarm.unq.sga.wicket.backlog;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.wicket.userstory.UserStoryController;

public class SprintBacklogPage extends WebPage {

	private static final long serialVersionUID = 1L;

	@SpringBean
	private UserStoryController userStoryController;
	// cambie el nombre por userStoryController;

	public SprintBacklogPage() {
		this.agregarAUserStoryFormBacklogsCompletadas();
	}

	public SprintBacklogPage(UserStory user) {
		userStoryController.attach(user);
		userStoryController.setUserStory(user);
		this.agregarAUserStoryFormBacklogsCompletadas();
	}

	public void agregarAUserStoryFormBacklogsCompletadas() {
		this.add(new ListView<UserStory>("sublistaSprintBacklogCompletados",
				new PropertyModel<>(this.userStoryController, "listaDeUserStoryEnSprintBacklog")) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<UserStory> item) {
				CompoundPropertyModel<UserStory> backlogCompletado = new CompoundPropertyModel<>(item.getModel());
				item.add(new Label("nombre", backlogCompletado.bind("nombre")));
				item.add(new Label("completa",backlogCompletado.bind("estaCompleta")));
				item.add(new Label("complejidad",backlogCompletado.bind("historyPoint")));
//			item.add(new TextField<UserStoryController>("complejidad", new PropertyModel<>(userStoryController,"complejidad")));

				item.add(new Link<String>("borrarBacklog") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						// this.setResponsePage(new
						// UserStory(item.getModelObject()));
						// this.setResponsePage(new
						// EliminarBacklogPage(item.getModelObject()));
					}

				});
//				this.add(new Link<String>("salir") {
//
//					private static final long serialVersionUID = 1L;
//
//					@Override
//					public void onClick() {
//						// this.setResponsePage(new BacklogPage());
//						this.setResponsePage(new ListUsersStoriesEnBacklogPage());
//
//					}
//
//				});
			}


			
		});
	}
}
			

//				item.add(new Link<String>("sacarDeSublistaBacklogsCompletados") {
//
//					private static final long serialVersionUID = 1L;
//
//					@Override
//					public void onClick() {
//						// this.setResponsePage(new
//						// UserStory(item.getModelObject()));
//						// this.setResponsePage(new
//						// SacarBacklogsCompletadosPage(item.getModelObject()));
//
//					}
//
//				});
			
		
//		}
