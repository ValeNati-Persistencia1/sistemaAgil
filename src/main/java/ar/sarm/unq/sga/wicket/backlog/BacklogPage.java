//package ar.sarm.unq.sga.wicket.backlog;
//
//import org.apache.wicket.markup.html.WebPage;
//import org.apache.wicket.markup.html.form.Form;
//import org.apache.wicket.markup.html.form.TextField;
//import org.apache.wicket.markup.html.link.Link;
//import org.apache.wicket.model.PropertyModel;
//import org.apache.wicket.spring.injection.annot.SpringBean;
//
//import ar.sarm.unq.sga.model.Backlog;
//import ar.sarm.unq.sga.model.Project;
//import ar.sarm.unq.sga.wicket.HomePage;
//import ar.sarm.unq.sga.wicket.project.ProjectController;
//import ar.sarm.unq.sga.wicket.project.ProjectPage;
//
//public class BacklogPage extends WebPage {
//	@SpringBean
//	private BacklogController backlogController;
//	@SpringBean
//	private ProjectController projectController;
//	private Project proyecto;
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	public BacklogPage() {
//		agregarForm();
//
//	}
//	public BacklogPage(Project proy) {
////		projectController.attach(proy);
//		agregarForm();
//
//	}
//
//	
//	private void agregarForm() {
//		Form<BacklogController> crearBacklogForm = new Form<BacklogController>("crearBacklogForm") {
//			private static final long serialVersionUID = 1L;
//			private Project proy;
//
//			@Override
//			protected void onSubmit() {
////				BacklogPage.this.backlogController.agregarBacklog(proy);
//				this.setResponsePage(new ProjectPage());
//
//			}
//		};
//
//		crearBacklogForm.add(new TextField<>("nombre", new PropertyModel<>(this.backlogController, "nombre")));
//
//		crearBacklogForm.add(new Link<String>("cancelar") {
//
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void onClick() {
//				this.setResponsePage(new HomePage());
//
//			}
//
//		});
//
//		this.add(crearBacklogForm);
//	}
//}
