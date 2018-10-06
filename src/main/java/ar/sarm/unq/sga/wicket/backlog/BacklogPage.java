package ar.sarm.unq.sga.wicket.backlog;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

import ar.sarm.unq.sga.wicket.HomePage;

public class BacklogPage extends WebPage {
	private BacklogController controller = new BacklogController();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BacklogPage() {
		agregarForm();

	}

	private void agregarForm() {
		Form<BacklogController> crearBacklogForm = new Form<BacklogController>("crearBacklogForm") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				BacklogPage.this.controller.agregarBacklog();
				this.setResponsePage(new HomePage());

			}
		};

		crearBacklogForm.add(new TextField<>("nombre", new PropertyModel<>(this.controller, "nombre")));

		crearBacklogForm.add(new Link<String>("cancelar") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new HomePage());

			}

		});

		this.add(crearBacklogForm);
	}
}
