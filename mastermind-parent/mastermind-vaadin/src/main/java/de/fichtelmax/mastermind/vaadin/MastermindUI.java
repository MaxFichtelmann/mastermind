package de.fichtelmax.mastermind.vaadin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.fichtelmax.mastermind.GuessResult;
import de.fichtelmax.mastermind.Mastermind;

@Theme("mastermind")
@Title("Mastermind")
public class MastermindUI extends UI {
	private static final long serialVersionUID = -8024776458773591101L;

	@SuppressWarnings("serial")
	@Override
	protected void init(VaadinRequest request) {
		Layout main = new VerticalLayout();
		setContent(main);

		final Label value = new Label();

		List<String> colors = Arrays.asList("red", "green", "yellow", "blue",
				"purple", "orange");

		final Mastermind<String> mastermind = Mastermind.randomSolution(4,
				colors);

		HorizontalLayout buttons = new HorizontalLayout();
		final HorizontalLayout guessLayout = new HorizontalLayout();
		final List<String> guess = new ArrayList<>();
		for (final String color : colors) {
			NativeButton button = new NativeButton();
			button.setWidth("50px");
			button.setHeight("50px");
			button.setStyleName(color);

			button.addClickListener(new ClickListener() {

				@Override
				public void buttonClick(ClickEvent event) {
					Label guessItem = new Label();
					guessItem.setStyleName(color);
					guessItem.setWidth("75px");
					guessItem.setHeight("75px");
					guessLayout.addComponent(guessItem);
					guess.add(color);
				}
			});

			buttons.addComponent(button);
		}

		final HorizontalLayout solutionState = new HorizontalLayout();
		Button guessButton = new Button("Guess!");
		guessButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				solutionState.removeAllComponents();
				guessLayout.removeAllComponents();
				GuessResult guessResult = mastermind.guess(guess);
				for (int i = 0; i < guessResult.getDirectHits(); i++) {
					Label black = new Label();
					black.setStyleName("black");
					black.setWidth("75px");
					black.setHeight("75px");
					solutionState.addComponent(black);
				}
				for (int i = 0; i < guessResult.getColorHits(); i++) {
					Label white = new Label();
					white.setStyleName("white");
					white.setWidth("75px");
					white.setHeight("75px");
					solutionState.addComponent(white);
				}
				guess.clear();
			}
		});

		Button clearButton = new Button("Clear");
		clearButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				solutionState.removeAllComponents();
				guessLayout.removeAllComponents();
				guess.clear();
			}
		});

		main.addComponent(buttons);
		main.addComponent(value);
		main.addComponent(guessLayout);
		main.addComponent(guessButton);
		main.addComponent(solutionState);
		main.addComponent(clearButton);
	}
}
