package ar.sarm.unq.sga.wicket.userstory;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.Rol;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.model.Usuario;
import ar.sarm.unq.sga.wicket.HomePage;
import ar.sarm.unq.sga.wicket.project.ListProjectPage;
import ar.sarm.unq.sga.wicket.project.ProjectController;

public class UserStoryPage extends WebPage {

	private static final long serialVersionUID = 1L;

	@SpringBean
	private UserStoryController userStoryController;
	@SpringBean
	private ProjectController projectController;
	@SuppressWarnings("unused")
	private Project project;
	private UserStory userStory;

	public UserStoryPage() {
		this.agregarForm();
		this.volverAHomePage();

	}

	public UserStoryPage(UserStory us) {
		this.userStoryController.setUserStory(us);
		this.setUserStory(us);
		this.agregarForm();
		this.volverAHomePage();

	}

	public UserStoryPage(Project proy) {
		projectController.attach(proy);
		userStoryController.setProject(proy);
		this.agregarForm();
		this.volverAHomePage();
	}
	
	public UserStoryPage(Project proy, Usuario usuario,Rol rol){
		projectController.attach(proy);
		userStoryController.setUserStory(userStory);
		proy.setUsuario(usuario);
		proy.addRol(rol);
		proy.getBacklog().setUserStory(userStory);
		usuario.setProyecto(proy);
		rol.setProject(proy);
		this.agregarForm();
		this.volverAHomePage();
	}

	private void agregarForm() {
		Form<UserStoryController> crearUserStoryForm = new Form<UserStoryController>("crearUserStoryForm") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				UserStoryPage.this.userStoryController.agregarUserStoryALaLista();
				this.setResponsePage(new ListProjectPage());

			}
		};

		crearUserStoryForm.add(new TextField<>("nombre", new PropertyModel<>(this.userStoryController, "nombre")));

		crearUserStoryForm
				.add(new TextArea<>("descripcion", new PropertyModel<>(this.userStoryController, "descripcion")));

		crearUserStoryForm
				.add(new TextField<>("valorCliente", new PropertyModel<>(this.userStoryController, "valorCliente")));

		crearUserStoryForm
				.add(new TextField<>("historyPoint", new PropertyModel<>(this.userStoryController, "historyPoint")));

		crearUserStoryForm.add(new DropDownChoice<>("rol", new PropertyModel<>(this.userStoryController, "rol"),
				new PropertyModel<>(this.userStoryController, "roles"), new ChoiceRenderer<>("nombreRol")));

		crearUserStoryForm.add(new DropDownChoice<>("usuario", new PropertyModel<>(this.userStoryController, "usuario"),
				new PropertyModel<>(this.userStoryController, "usuarios"), new ChoiceRenderer<>("nombreUsuario")));

		// crearUserStoryForm.add(new Link<String>("verDetalleUserStory") {
		// private static final long serialVersionUID = 1L;
		//
		// @Override
		// public void onClick() {
		// this.setResponsePage(new VerDetalleUserStoryPage());
		//
		// }
		//
		// });
		// crearUserStoryForm.add(new
		// Link<String>("verListaUserStoriesEnBacklog") {
		// private static final long serialVersionUID = 1L;
		//
		// @Override
		// public void onClick() {
		// this.setResponsePage(new ListUsersStoriesEnBacklogPage());
		// }
		//
		// });

		crearUserStoryForm.add(new Link<String>("cancelar") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListProjectPage());

			}

		});
		// crearUserStoryForm.add(new Link<String>("verListaSprintBacklog") {
		// private static final long serialVersionUID = 1L;
		//
		// @Override
		// public void onClick() {
		// this.setResponsePage(new SprintBacklogPage());
		// }
		//
		// });
		//
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
