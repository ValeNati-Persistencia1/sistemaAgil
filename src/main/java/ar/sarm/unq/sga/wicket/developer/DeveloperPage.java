package ar.sarm.unq.sga.wicket.developer;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;

import ar.sarm.unq.sga.wicket.HomePage;

public class DeveloperPage extends WebPage{

	private static final long serialVersionUID = 1L;
	@SpringBean
	private DeveloperController developerController;
	
	public DeveloperPage(){
		agregarForm();
		
	}

	private void agregarForm() {
		@SuppressWarnings("rawtypes")
		Form<DeveloperController>crearDeveloperForm=new Form<DeveloperController>("crearDeveloperForm"){
			private static final long serialVersionUID = 1L;
			
			@Override
			protected void onSubmit() {
				DeveloperPage.this.developerController.agregarDeveloper();
				this.setResponsePage(new HomePage());
			
			}	
					
		};
		
		crearDeveloperForm.add(new TextField<>("nombre", new PropertyModel<>(developerController, "nombre")));
		
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
