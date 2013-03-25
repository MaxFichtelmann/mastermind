package hello;

import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@Title("Hello World")
public class World extends UI {
	private static final long serialVersionUID = -3597010074765770707L;

	@Override
	protected void init(VaadinRequest request) {
		HorizontalLayout main = new HorizontalLayout();
		setContent(main);

		main.addComponent(new Label("Hello World!"));
	}

}
