package de.fichtelmax.mastermind.vaadin.components;

import java.util.List;

import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

import de.fichtelmax.mastermind.GuessResult;
import de.fichtelmax.mastermind.Mastermind;

/**
 * A Component representing a previous guess along with the resulting hints.
 * 
 * @author Max Fichtelmann
 * 
 */
public class HistoryItem extends HorizontalLayout
{
    private static final long serialVersionUID = -4625192233079713428L;
    
    /**
     * creates a new {@link HistoryItem} with the given input and the given result.
     * 
     * @param inputs
     *            the input guess
     * @param guessResult
     *            the hints delivered by {@link Mastermind}.
     */
    public HistoryItem( List<String> inputs, GuessResult guessResult )
    {
        setMargin( true );
        for ( String color : inputs )
        {
            addComponent( historyCircle( color, "60px" ) );
        }
        
        addComponent( spacer( "10px" ) );
        addComponent( createSolutionTile( guessResult ) );
    }
    
    private Component createSolutionTile( GuessResult guessResult )
    {
        GridLayout gridLayout = new GridLayout( 2, 2 );
        
        String solutionRadius = "28px";
        for ( int i = 0; i < guessResult.getDirectHits(); i++ )
        {
            gridLayout.addComponent( historyCircle( "black", solutionRadius ) );
        }
        for ( int i = 0; i < guessResult.getColorHits(); i++ )
        {
            gridLayout.addComponent( historyCircle( "white", solutionRadius ) );
        }
        
        return gridLayout;
    }
    
    private static Component historyCircle( String color, String radius )
    {
        ColorField colorField = new ColorField( color );
        colorField.addStyleName( "circle" );
        colorField.addStyleName( "history" );
        colorField.setWidth( radius );
        colorField.setHeight( radius );
        
        return colorField;
    }
    
    private static Component spacer( String width )
    {
        Label spacer = new Label();
        spacer.setWidth( width );
        return spacer;
    }
}
