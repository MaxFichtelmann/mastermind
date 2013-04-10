package de.fichtelmax.mastermind.vaadin.components;

import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.NativeButton;

import de.fichtelmax.mastermind.vaadin.control.MastermindController;

public class GuessButton extends NativeButton implements ClickListener
{
    private static final long    serialVersionUID = 7656365719613259143L;
    
    private MastermindController controller;
    
    public GuessButton( MastermindController controller )
    {
        super( "Guess!" );
        addStyleName( "guess" );
        
        this.controller = controller;
        addClickListener( this );
    }
    
    @Override
    public void buttonClick( ClickEvent event )
    {
        controller.guess();
    }
    
}
