package de.fichtelmax.mastermind.vaadin.control;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.AbstractOrderedLayout;

import de.fichtelmax.mastermind.GuessResult;
import de.fichtelmax.mastermind.Mastermind;
import de.fichtelmax.mastermind.vaadin.components.GuessInputField;
import de.fichtelmax.mastermind.vaadin.components.HistoryItem;

public class MastermindController
{
    private Mastermind<String>          mastermind;
    private final AbstractOrderedLayout historyPane;
    private List<GuessInputField>       inputs;
    
    public MastermindController( AbstractOrderedLayout historyPane, List<GuessInputField> inputs, List<String> colorOptions )
    {
        this.historyPane = historyPane;
        this.inputs = inputs;
        this.mastermind = Mastermind.randomSolution( 4, colorOptions );
    }
    
    public void guess()
    {
        List<String> guess = new ArrayList<>( 4 );
        
        for ( GuessInputField input : inputs )
        {
            guess.add( input.getColor() );
        }
        
        GuessResult result = mastermind.guess( guess );
        
        historyPane.addComponent( new HistoryItem( guess, result ), 0 );
    }
    
    public void newGame( List<String> colorOptions )
    {
        mastermind = Mastermind.randomSolution( 4, colorOptions );
        historyPane.removeAllComponents();
        
        for ( GuessInputField input : inputs )
        {
            input.clear();
        }
    }
}
