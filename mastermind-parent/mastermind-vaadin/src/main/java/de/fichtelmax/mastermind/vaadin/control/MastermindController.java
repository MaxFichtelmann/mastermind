package de.fichtelmax.mastermind.vaadin.control;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.AbstractOrderedLayout;

import de.fichtelmax.mastermind.GuessResult;
import de.fichtelmax.mastermind.Mastermind;
import de.fichtelmax.mastermind.MastermindImpl;
import de.fichtelmax.mastermind.vaadin.components.GuessInputField;
import de.fichtelmax.mastermind.vaadin.components.HistoryItem;
import de.fichtelmax.mastermind.vaadin.components.SolutionZone;

public class MastermindController
{
    private static final int            SIZE = 4;
    private Mastermind<String>          mastermind;
    private final AbstractOrderedLayout historyPane;
    private List<GuessInputField>       inputs;
    private List<String>                colorOptions;
    private SolutionZone                solutionZone;
    
    public MastermindController( AbstractOrderedLayout historyPane, List<GuessInputField> inputs, List<String> colorOptions,
            SolutionZone solutionZone )
    {
        this.historyPane = historyPane;
        this.inputs = inputs;
        this.colorOptions = colorOptions;
        this.solutionZone = solutionZone;
        this.mastermind = MastermindImpl.randomSolution( SIZE, colorOptions );
    }
    
    public boolean guess()
    {
        List<String> guess = new ArrayList<>( SIZE );
        
        for ( GuessInputField input : inputs )
        {
            guess.add( input.getColor() );
        }
        
        GuessResult result = mastermind.guess( guess );
        
        historyPane.addComponent( new HistoryItem( guess, result ), 0 );
        
        boolean success = result.getDirectHits() == SIZE;
        
        if ( success )
        {
            solutionZone.showSolution( guess );
        }
        
        return success;
    }
    
    public void newGame()
    {
        mastermind = MastermindImpl.randomSolution( SIZE, colorOptions );
        historyPane.removeAllComponents();
        solutionZone.hideSolution();
        
        for ( GuessInputField input : inputs )
        {
            input.clear();
        }
    }
}
