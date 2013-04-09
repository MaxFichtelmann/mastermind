package de.fichtelmax.mastermind.vaadin.components;

import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ColorDragField extends VerticalLayout {
	private static final long serialVersionUID = -3826351615919771871L;
	private Label main;

	public ColorDragField(String color) {
		main = new ColorField(color);
		main.setWidth("50px");
		main.setHeight("50px");

		DragAndDropWrapper dragWrapper = new DragAndDropWrapper(main);
		dragWrapper.setDragStartMode(DragStartMode.COMPONENT);
		dragWrapper.setSizeUndefined();

		addComponent(dragWrapper);
	}
}
