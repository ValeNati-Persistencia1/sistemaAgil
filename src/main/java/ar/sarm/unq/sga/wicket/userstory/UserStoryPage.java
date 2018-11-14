package ar.sarm.unq.sga.wicket.userstory;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.wicket.HomePage;
import ar.sarm.unq.sga.wicket.backlog.ListUsersStoriesEnBacklogPage;
import ar.sarm.unq.sga.wicket.project.ListProjectPage;

public class UserStoryPage extends WebPage {

	private static final long serialVersionUID = 1L;

	@SpringBean
	private UserStoryController userStoryController;

	@SuppressWarnings("unused")
	private Project project;
	private UserStory userStory;

	public UserStoryPage() {
		this.agregarForm();
		this.volverAHomePage();
		;
	}

	// public UserStoryPage(Project project){
	// this.project=project;
	// userStoryController.setProject(project);
	// agregarForm();
	// }
	public UserStoryPage(UserStory us) {
		this.userStoryController.attach(us);
		this.setUserStory(us);
		this.agregarForm();
		this.volverAHomePage();
		;
	}

	private void agregarForm() {
		Form<UserStoryController> crearUserStoryForm = new Form<UserStoryController>("crearUserStoryForm") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				UserStoryPage.this.userStoryController.agregarUserStoryALaLista();
				this.setResponsePage(new VerDetalleUserStoryPage());

			}
		};

		crearUserStoryForm
		         .add(new TextField<>("nombre", new PropertyModel<>(this.userStoryController, "nombre")));

		crearUserStoryForm
				.add(new TextArea<>("descripcion", new PropertyModel<>(this.userStoryController, "descripcion")));

		crearUserStoryForm
				.add(new TextField<>("valorCliente", new PropertyModel<>(this.userStoryController, "valorCliente")));

		crearUserStoryForm
				.add(new TextField<>("historyPoint", new PropertyModel<>(this.userStoryController, "historyPoint")));

		crearUserStoryForm.add(new Link<String>("verDetalleUserStory") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new VerDetalleUserStoryPage());

			}

		});
		crearUserStoryForm.add(new Link<String>("verListaUserStoriesEnBacklog") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListUsersStoriesEnBacklogPage());
			}

		});

		crearUserStoryForm.add(new Link<String>("cancelar") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListProjectPage());

			}

		});

		this.add(crearUserStoryForm);

	}

	public void volverAHomePage() {
		this.add(new Link<String>("volver") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new HomePage());

			}

		});
	}

	public UserStory getUserStory() {
		return userStory;
	}

	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}
}
