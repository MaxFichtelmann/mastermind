package de.fichtelmax.mastermind.vaadin.mvp.presenters;

import java.util.List;

public interface GuessInputPresenter
{
    List<String> obtainGuessValues();
    
    void processColorEvent( String sourceItemId, String color );
}
