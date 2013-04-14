package de.fichtelmax.mastermind.vaadin.mvp.view;

public interface SolutionView
{
    String createSolutionItem();
    
    void setItemColor( String itemId, String color );
    
    String getItemColor( String itemId );
}
