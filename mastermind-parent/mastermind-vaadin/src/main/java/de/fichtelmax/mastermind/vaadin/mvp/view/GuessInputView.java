package de.fichtelmax.mastermind.vaadin.mvp.view;

public interface GuessInputView
{
    String createField();
    
    void setFieldColor( String itemId, String color );
    
    String getFieldColor( String itemId );
    
    void relayDropEvent( String color );
}
