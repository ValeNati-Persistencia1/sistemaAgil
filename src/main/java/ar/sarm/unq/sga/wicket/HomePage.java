package ar.sarm.unq.sga.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.component.IRequestablePage;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	public HomePage() {
		
		this.add(new Link<String>("proyecto") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage((IRequestablePage) new Exception("nada creado aun..rellenar"));
			}

		});

 }
}
