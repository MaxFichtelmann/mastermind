package de.fichtelmax.mastermind.vaadin.mvp.view;

public interface SolutionView
{
    void createSolutionItem( String itemId );
    
    void setItemColor( String itemId, String color );
    
    String getItemColor( String itemId );
}
