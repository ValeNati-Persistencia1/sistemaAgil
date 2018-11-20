package ar.sarm.unq.sga.wicket.userstory;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.wicket.HomePage;
import ar.sarm.unq.sga.wicket.backlog.ListUsersStoriesEnBacklogPage;
import ar.sarm.unq.sga.wicket.backlog.SprintBacklogPage;

public class VerDetalleUserStoryPage extends WebPage {

	private static final long serialVersionUID = 5691036303664036670L;

	@SpringBean
	private UserStoryController userStoryController;

	@SuppressWarnings("unused")
	private UserStory userStory;

	public VerDetalleUserStoryPage() {
		this.addForm();
		this.salir();
		this.volverAtras();
	}

	public VerDetalleUserStoryPage(UserStory us, Project proy) {
		this.userStory = us;
		this.addForm();
		this.salir();
		this.volverAtras();
	}

	private void addForm() {
		this.add(new ListView<UserStory>("losUsersStories",new PropertyModel<>(this.userStoryController, "usersstories")) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<UserStory> item) {
				CompoundPropertyModel<UserStory> us = new CompoundPropertyModel<>(item.getModelObject());
				item.add(new Label("nombre", us.bind("nombre")));
				item.add(new TextArea<>("descripcion", us.bind("descripcion")));
				item.add(new Label("valorCliente", us.bind("valorCliente")));
				item.add(new Label("historyPoint", us.bind("historyPoint")));

//				item.add(new Link<String>("agregarUserStoryABacklog") {
//					private static final long serialVersionUID = 1L;
//
//					@Override
//					public void onClick() {
//						VerDetalleUserStoryPage.this.userStoryController.agregarUserStoryALaLista();
//						this.setResponsePage(new ListUsersStoriesEnBacklogPage());
//
//					}
//
//				});
				item.add(new Link<String>("agregarUserStoryASprintBacklog") {
				private static final long serialVersionUID = 1L;

				@Override
				public void onClick() {
//					VerDetalleUserStoryPage.this.userStoryController.agregarUsertStorieEnSprintBacklog(item.getModelObject());
//					this.setResponsePage(new SprintBacklogPage());

				}

			});


				item.add(new Link<String>("borrarUserStory") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						VerDetalleUserStoryPage.this.userStoryController.borrarUserStory(item.getModelObject());
						this.setResponsePage(new VerDetalleUserStoryPage());

					}

				});

			}

		});

	}
	

	public void salir() {
		this.add(new Link<String>("salir") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new HomePage());

			}

		});
	}

	public void volverAtras() {
		this.add(new Link<String>("volver") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new UserStoryPage());

			}

		});
	}

}
