package ar.sarm.unq.sga.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

import ar.sarm.unq.sga.wicket.project.ListProjectPage;
import ar.sarm.unq.sga.wicket.project.ProjectPage;
import ar.sarm.unq.sga.wicket.userstory.UserStoryPage;
import ar.sarm.unq.sga.wicket.usuario.ListUsuariosPage;
import ar.sarm.unq.sga.wicket.usuario.UsuarioPage;

public class HomePage extends WebPage {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HomePage.class);
	private static final long serialVersionUID = 1L;

	public HomePage() {
		log.debug("construyendo la lista de proyectos");

		this.add(new Link<String>("losProyectos") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				log.debug("antes de derivar a la ListProjectPage");
				this.setResponsePage(new ListProjectPage());
			}

		});

		this.add(new Link<String>("usuario") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				log.debug("antes de derivar el develper page");
				this.setResponsePage(new UsuarioPage());
			}

		});

	}
}
