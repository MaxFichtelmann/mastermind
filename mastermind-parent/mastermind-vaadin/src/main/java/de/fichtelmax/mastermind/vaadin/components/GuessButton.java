package de.fichtelmax.mastermind.vaadin.components;

import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.NativeButton;

import de.fichtelmax.mastermind.vaadin.control.MastermindController;

public class GuessButton extends NativeButton implements ClickListener
{
    private static final String  SOLUTION_CAPTION = "Correct Solution! Try again?";
    private static final String  GUESS_CAPTION    = "Guess!";
    
    private static final long    serialVersionUID = 7656365719613259143L;
    
    private MastermindController controller;
    
    private boolean              gameFinished     = false;
    
    public GuessButton( MastermindController controller )
    {
        super( GUESS_CAPTION );
        addStyleName( "guess" );
        
        this.controller = controller;
        addClickListener( this );
    }
    
    @Override
    public void buttonClick( ClickEvent event )
    {
        if ( !gameFinished )
        {
            if ( controller.guess() )
            {
                setCaption( SOLUTION_CAPTION );
                gameFinished = true;
            }
        }
        else
        {
            setCaption( GUESS_CAPTION );
            controller.newGame();
            gameFinished = false;
        }
    }
    
}
