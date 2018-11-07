package ar.sarm.unq.sga.wicket.usuario;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.model.Usuario;
import ar.sarm.unq.sga.wicket.HomePage;

public class ListUsuariosPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SpringBean
	private UsuarioController usuarioController;

	private Usuario usuario;

	public ListUsuariosPage(Usuario usuario) {
		this.usuario = usuario;
		usuarioController.attach(usuario);
		tablaDeDevelopers();
	}

	public ListUsuariosPage() {
		tablaDeDevelopers();

	}

	//
	//
	public void tablaDeDevelopers() {
		this.add(new ListView<Usuario>("losDevelopers", new PropertyModel<>(this.usuarioController, "usuarios")) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Usuario> item) {
				CompoundPropertyModel<Usuario> elDeveloper = new CompoundPropertyModel<>(item.getModelObject());
				item.add(new Label("nombre", elDeveloper.bind("nombre")));
				item.add(new Label("apellido", elDeveloper.bind("apellido")));
				item.add(new Link<String>("verProyectos") {

					@Override
					public void onClick() {
						// TODO Auto-generated method stub
						// la idea es que vaya a la lista de sus proyectos

					}

				});
				item.add(new Link<String>("borrarUsuario") {

					@Override
					public void onClick() {
						ListUsuariosPage.this.usuarioController.borrarUsuario(item.getModelObject());
						// la idea es que vaya a la lista de sus proyectos

					}

				});
				item.add(new Link<String>("volver") {

					@Override
					public void onClick() {
						this.setResponsePage(new HomePage());
						
					}

				});



			}

		});
	}
}
