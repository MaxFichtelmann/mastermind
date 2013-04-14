package de.fichtelmax.mastermind.vaadin.mvp.presenters;

import java.util.List;

import de.fichtelmax.mastermind.vaadin.mvp.view.SolutionView;

public interface SolutionPresenter
{
    void setShowSolution( boolean showSolution );
    
    void setSolution( List<String> colors );
    
    List<String> getSolution();
    
    SolutionView getView();
}
