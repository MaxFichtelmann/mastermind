package de.fichtelmax.mastermind.vaadin.components;

import java.util.List;

import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;

import de.fichtelmax.mastermind.GuessResult;

public class HistoryItem extends HorizontalLayout
{
    private static final long serialVersionUID = -4625192233079713428L;
    
    public HistoryItem( List<String> inputs, GuessResult guessResult )
    {
        for ( String color : inputs )
        {
            addComponent( historyCircle( color, "50px" ) );
        }
        addComponent( createSolutionTile( guessResult ) );
    }
    
    private Component createSolutionTile( GuessResult guessResult )
    {
        GridLayout gridLayout = new GridLayout( 2, 2 );
        
        String solutionRadius = "25px";
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
}
