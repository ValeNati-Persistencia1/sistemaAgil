package ar.sarm.unq.sga.wicket.backlog;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.springframework.beans.factory.annotation.Autowired;

public class AddBacklogPage extends WebPage{

	private static final long serialVersionUID = 1L;
	
		@Autowired
		private BacklogController controller = new BacklogController();

		public AddBacklogPage() {
			agregarForm();

		}

		private void agregarForm() {
			Form<BacklogController> crearNuevoProyectoBacklogForm = new Form<BacklogController>("crearNuevoProyectoBacklogForm") {
				private static final long serialVersionUID = 1L;

				@Override
				protected void onSubmit() {
					//AddBacklogPage.this.controller.crearProyectoBacklog();
					this.setResponsePage(new BacklogPage());

				}
			};

			crearNuevoProyectoBacklogForm.add(new TextField<>("nombre", new PropertyModel<>(this.controller, "nombre")));
			
			crearNuevoProyectoBacklogForm.add(new TextArea<>("descripcion", new PropertyModel<>(this.controller, "descripcion")));

			crearNuevoProyectoBacklogForm.add(new Link<String>("cancelar") {
				private static final long serialVersionUID = 1L;

				@Override
				public void onClick() {
					this.setResponsePage(new BacklogPage());

				}

			});

			this.add(crearNuevoProyectoBacklogForm);
		
		}
	}
	
	


