package de.fichtelmax.mastermind.vaadin;

import java.util.Arrays;
import java.util.List;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.fichtelmax.mastermind.GuessResult;
import de.fichtelmax.mastermind.vaadin.components.ColorField;
import de.fichtelmax.mastermind.vaadin.components.ColorPickupField;
import de.fichtelmax.mastermind.vaadin.components.GuessInputField;
import de.fichtelmax.mastermind.vaadin.components.HistoryItem;

@Theme( "mastermind" )
@Title( "Mastermind" )
public class MastermindUI extends UI
{
    private static final long  serialVersionUID = -8024776458773591101L;
    
    private final List<String> colors           = Arrays.asList( "red", "green", "yellow", "blue", "purple", "orange" );
    
    @Override
    protected void init( VaadinRequest request )
    {
        Layout main = new VerticalLayout();
        setContent( main );
        
        main.setSizeFull();
        
        GridLayout game = new GridLayout( 2, 3 );
        game.setMargin( true );
        
        Component solutionZone = createSolutionZone();
        solutionZone.setHeight( "100px" );
        solutionZone.setWidth( "400px" );
        game.addComponent( solutionZone, 0, 0 );
        
        game.addComponent( createCenterZone(), 0, 1 );
        
        Component colorPickupZone = createColorPickupZone( "90px" );
        Panel colorPickup = new Panel();
        colorPickup.setWidth( "100px" );
        colorPickup.setHeight( "570px" );
        colorPickup.setContent( colorPickupZone );
        game.addComponent( colorPickup, 1, 1 );
        
        Panel guessButtonZone = new Panel();
        guessButtonZone.setWidth( "400px" );
        guessButtonZone.setHeight( "100px" );
        Button guessButton = new NativeButton( "Guess!" );
        guessButton.setSizeFull();
        guessButtonZone.setContent( guessButton );
        game.addComponent( guessButtonZone, 0, 2 );
        
        main.addComponent( game );
    }
    
    private Component createSolutionZone()
    {
        HorizontalLayout solution = new HorizontalLayout();
        
        for ( int i = 0; i < 4; i++ )
        {
            ColorField field = new ColorField( "rgb(192,192,192)" );
            field.addStyleName( "solution" );
            field.addStyleName( "circle" );
            field.setWidth( "90px" );
            field.setHeight( "90px" );
            solution.addComponent( field );
        }
        
        Panel panel = new Panel();
        panel.setContent( solution );
        return panel;
    }
    
    private Component createColorPickupZone( String size )
    {
        
        Layout colorPickup = new VerticalLayout();
        for ( String color : colors )
        {
            ColorPickupField colorPickupField = new ColorPickupField( color );
            colorPickupField.setWidth( size );
            colorPickupField.setHeight( size );
            colorPickup.addComponent( colorPickupField );
        }
        
        return colorPickup;
    }
    
    private Component createCenterZone()
    {
        VerticalLayout centerLayout = new VerticalLayout();
        centerLayout.setSizeFull();
        centerLayout.addComponent( createHistoryZone() );
        Component inputZone = createGuessInputZone();
        centerLayout.addComponent( inputZone );
        centerLayout.setComponentAlignment( inputZone, Alignment.BOTTOM_CENTER );
        
        Panel centerPanel = new Panel();
        centerPanel.setWidth( "400px" );
        centerPanel.setHeight( "570px" );
        centerPanel.setContent( centerLayout );
        return centerPanel;
    }
    
    private Component createHistoryZone()
    {
        List<String> guess1 = Arrays.asList( "red", "green", "red", "yellow" );
        GuessResult result1 = new GuessResult( 0, 1 );
        List<String> guess2 = Arrays.asList( "green", "red", "blue", "blue" );
        GuessResult result2 = new GuessResult( 2, 1 );
        
        VerticalLayout layout = new VerticalLayout();
        layout.addComponent( new HistoryItem( guess1, result1 ) );
        layout.addComponent( new HistoryItem( guess2, result2 ) );
        return layout;
    }
    
    private Component createGuessInputZone()
    {
        HorizontalLayout guessInput = new HorizontalLayout();
        GuessInputField input1 = new GuessInputField();
        GuessInputField input2 = new GuessInputField();
        GuessInputField input3 = new GuessInputField();
        GuessInputField input4 = new GuessInputField();
        
        guessInput.addComponent( input1 );
        guessInput.addComponent( input2 );
        guessInput.addComponent( input3 );
        guessInput.addComponent( input4 );
        
        return guessInput;
    }
}
