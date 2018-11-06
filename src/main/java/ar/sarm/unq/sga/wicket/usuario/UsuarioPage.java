package ar.sarm.unq.sga.wicket.usuario;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;

import ar.sarm.unq.sga.wicket.HomePage;

public class UsuarioPage extends WebPage{

	private static final long serialVersionUID = 1L;
	@SpringBean
<<<<<<< HEAD:src/main/java/ar/sarm/unq/sga/wicket/usuario/UsuarioPage.java
	private UsuarioController usuarioController;
=======
	private UsuarioController developerController;
>>>>>>> d99656b8b1b15837ddbbe47da59d961673fa22fd:src/main/java/ar/sarm/unq/sga/wicket/usuario/UsuarioPage.java
	
	public UsuarioPage(){
		agregarForm();
		
	}

	private void agregarForm() {
		@SuppressWarnings("rawtypes")
		Form<UsuarioController>crearDeveloperForm=new Form<UsuarioController>("crearDeveloperForm"){
			private static final long serialVersionUID = 1L;
			
			@Override
			protected void onSubmit() {
<<<<<<< HEAD:src/main/java/ar/sarm/unq/sga/wicket/usuario/UsuarioPage.java
				UsuarioPage.this.usuarioController.agregarUsuario();
				this.setResponsePage(new ListUsuariosPage());
=======
				UsuarioPage.this.developerController.agregarDeveloper();
				this.setResponsePage(new HomePage());
>>>>>>> d99656b8b1b15837ddbbe47da59d961673fa22fd:src/main/java/ar/sarm/unq/sga/wicket/usuario/UsuarioPage.java
			
			}	
					
		};
		
		crearDeveloperForm.add(new TextField<>("nombre", new PropertyModel<>(usuarioController, "nombre")));
		crearDeveloperForm.add(new TextField<>("apellido", new PropertyModel<>(usuarioController, "apellido")));
		crearDeveloperForm.add(new Link<String>("cancelar") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
                 this.setResponsePage(new HomePage());				
			}
		});
		this.add(crearDeveloperForm);
	}

}
