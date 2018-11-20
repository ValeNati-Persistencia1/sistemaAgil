//package ar.sarm.unq.sga.wicket.userstory;
//
//import org.apache.wicket.markup.html.WebPage;
//import org.apache.wicket.markup.html.basic.Label;
//import org.apache.wicket.markup.html.link.Link;
//import org.apache.wicket.markup.html.list.ListItem;
//import org.apache.wicket.markup.html.list.ListView;
//import org.apache.wicket.model.CompoundPropertyModel;
//import org.apache.wicket.model.PropertyModel;
//import org.apache.wicket.spring.injection.annot.SpringBean;
//
//import ar.sarm.unq.sga.model.Backlog;
//import ar.sarm.unq.sga.model.Project;
//import ar.sarm.unq.sga.model.UserStory;
//import ar.sarm.unq.sga.wicket.HomePage;
//import ar.sarm.unq.sga.wicket.backlog.ListUsersStoriesEnBacklogPage;
//import ar.sarm.unq.sga.wicket.backlog.SprintBacklogPage;
//import ar.sarm.unq.sga.wicket.project.ListProjectPage;
//import ar.sarm.unq.sga.wicket.project.ProjectController;
//
//public class ListaDeUserStoryDelProyectoPage extends WebPage {
//
//	/**
//	 * 
//	 */
//	@SpringBean
//	protected ProjectController projectController;
//	@SpringBean
//	protected UserStoryController userStoryController;
//
//	private Project proyecto;
//	private Backlog backlog;
//
//	private static final long serialVersionUID = 1L;
//
//	public ListaDeUserStoryDelProyectoPage() {
//
//	}
//
//	public ListaDeUserStoryDelProyectoPage(Project proy) {
//		 userStoryController.attach(proy.getBacklog().getUserStory());
//		backlog = proy.getBacklog();
//		 userStoryController.setProject(proy);
//		this.proyecto = proy;
//		projectController.attach(proy);
//		projectController.setProject(proy);
//		lista();
//		volverAtras();
//	}
//
//	private void lista() {
//		this.add(new ListView<UserStory>("losUsersStories",
//				new PropertyModel<>(this.projectController, "listaDeUserStoryDelProyecto")) {
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			protected void populateItem(ListItem<UserStory> item) {
//				CompoundPropertyModel<UserStory> us = new CompoundPropertyModel<>(item.getModelObject());
//				item.add(new Label("nombre", us.bind("nombre")));
//
//				item.add(new Link<String>("agregarASprintBacklog") {
//					private static final long serialVersionUID = 1L;
//
//					@Override
//					public void onClick() {
////						userStoryController.agregarUsertStorieEnSprintBacklog();
////						this.setResponsePage(new SprintBacklogPage());
//
//						
//
//					}
//
//				});
//
//				item.add(new Link<String>("borrarUserStory") {
//					private static final long serialVersionUID = 1L;
//
//					@Override
//					public void onClick() {
//						ListaDeUserStoryDelProyectoPage.this.userStoryController.borrarUserStory(item.getModelObject());
//						this.setResponsePage(new VerDetalleUserStoryPage());
//
//					}
//
//				});
//
//			}
//
//		});
//
//	}
//
//	public void salir() {
//		this.add(new Link<String>("salir") {
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void onClick() {
//				this.setResponsePage(new ListProjectPage());
//
//			}
//
//		});
//	}
//
//	public void volverAtras() {
//		this.add(new Link<String>("volver") {
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void onClick() {
//				this.setResponsePage(new ListProjectPage());
//
//			}
//
//		});
//	}
//
//}
