package de.fichtelmax.mastermind.vaadin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.vaadin.addon.extendedlabel.ExtendedContentMode;
import org.vaadin.addon.extendedlabel.ExtendedLabel;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.fichtelmax.mastermind.vaadin.components.ColorPickupField;
import de.fichtelmax.mastermind.vaadin.components.GuessButton;
import de.fichtelmax.mastermind.vaadin.components.GuessInputField;
import de.fichtelmax.mastermind.vaadin.components.SolutionZone;
import de.fichtelmax.mastermind.vaadin.control.MastermindController;

@Theme( "mastermind" )
@Title( "Mastermind" )
public class MastermindUI extends UI
{
    
    private static final long         serialVersionUID         = -8024776458773591101L;
    
    private static final String       HISTORY_ZONE_HEIGHT      = "470px";
    private static final String       SOLUTION_ZONE_WIDTH      = "400px";
    private static final String       SOLUTION_ZONE_HEIGHT     = "100px";
    private static final String       CENTER_ZONE_WIDTH        = "400px";
    private static final String       CENTER_ZONE_HEIGHT       = "570px";
    private static final String       GUESS_BUTTON_ZONE_WIDTH  = "400px";
    private static final String       GUESS_BUTTON_ZONE_HEIGHT = "100px";
    private static final String       COLOR_PICKUP_ZONE_HEIGHT = "570px";
    private static final String       COLOR_PICKUP_ZONE_WIDTH  = "100px";
    private static final String       COLOR_PICKUP_FIELD_SIZE  = "90px";
    private static final String       GUESS_INPUT_FIELD_RADIUS = "90px";
    
    private static final List<String> COLORS                   = Arrays.asList( "#ff4500", // red
                                                                       "green", // green
                                                                       "#ffd700", // yellow
                                                                       "#000080", // blue
                                                                       "#7b68ee", // purple
                                                                       "#9acd32" // yellow green
                                                               );
    
    private List<GuessInputField>     inputs                   = new ArrayList<>();
    
    private VerticalLayout            historyContainer;
    
    /*
     * (non-Javadoc)
     * 
     * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
     */
    @Override
    protected void init( VaadinRequest request )
    {
        HorizontalLayout main = new HorizontalLayout();
        main.setSizeFull();
        
        setContent( main );
        
        // setup panels
        SolutionZone solutionZone = createSolutionZone();
        Component centerZone = createCenterZone();
        Component colorPickupZone = createColorPickupZone();
        
        MastermindController controller = new MastermindController( historyContainer, inputs, COLORS, solutionZone );
        Panel guessButtonZone = createGuessButtonZone( controller );
        
        GridLayout game = new GridLayout( 2, 3 );
        game.setMargin( true );
        game.addComponent( solutionZone, 0, 0 );
        game.addComponent( centerZone, 0, 1 );
        game.addComponent( colorPickupZone, 1, 1 );
        game.addComponent( guessButtonZone, 0, 2 );
        
        main.addComponent( game );
        main.setComponentAlignment( game, Alignment.TOP_CENTER );
        
        Label readme = createReadme();
        main.addComponent( readme );
    }
    
    private Label createReadme()
    {
        Label readmeLabel;
        InputStream readmeStream = MastermindUI.class.getResourceAsStream( "/README.md" );
        try
        {
            String readme = IOUtils.toString( readmeStream );
            
            readmeLabel = new ExtendedLabel( readme, ExtendedContentMode.MARKDOWN );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }
        return readmeLabel;
    }
    
    private Panel createGuessButtonZone( MastermindController controller )
    {
        Panel guessButtonZone = new Panel();
        guessButtonZone.setWidth( GUESS_BUTTON_ZONE_WIDTH );
        guessButtonZone.setHeight( GUESS_BUTTON_ZONE_HEIGHT );
        Button guessButton = new GuessButton( controller );
        guessButton.setSizeFull();
        guessButton.addStyleName( "guess" );
        guessButtonZone.setContent( guessButton );
        return guessButtonZone;
    }
    
    private SolutionZone createSolutionZone()
    {
        SolutionZone solutionZone = new SolutionZone();
        solutionZone.setHeight( SOLUTION_ZONE_HEIGHT );
        solutionZone.setWidth( SOLUTION_ZONE_WIDTH );
        return solutionZone;
    }
    
    private Component createColorPickupZone()
    {
        
        Layout layout = new VerticalLayout();
        for ( String color : COLORS )
        {
            ColorPickupField colorPickupField = new ColorPickupField( color );
            colorPickupField.setWidth( COLOR_PICKUP_FIELD_SIZE );
            colorPickupField.setHeight( COLOR_PICKUP_FIELD_SIZE );
            layout.addComponent( colorPickupField );
        }
        
        Panel panel = new Panel();
        panel.setWidth( COLOR_PICKUP_ZONE_WIDTH );
        panel.setHeight( COLOR_PICKUP_ZONE_HEIGHT );
        panel.setContent( layout );
        
        return panel;
    }
    
    private Component createCenterZone()
    {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.addComponent( createHistoryZone() );
        Component guessInputZone = createGuessInputZone();
        layout.addComponent( guessInputZone );
        layout.setComponentAlignment( guessInputZone, Alignment.BOTTOM_CENTER );
        
        Panel panel = new Panel();
        panel.setWidth( CENTER_ZONE_WIDTH );
        panel.setHeight( CENTER_ZONE_HEIGHT );
        panel.setContent( layout );
        return panel;
    }
    
    private Component createHistoryZone()
    {
        historyContainer = new VerticalLayout();
        
        // needed for scroll support
        Panel panel = new Panel();
        panel.setContent( historyContainer );
        panel.setHeight( HISTORY_ZONE_HEIGHT );
        return panel;
    }
    
    private Component createGuessInputZone()
    {
        HorizontalLayout layout = new HorizontalLayout();
        
        for ( int i = 0; i < 4; i++ )
        {
            inputs.add( new GuessInputField( GUESS_INPUT_FIELD_RADIUS ) );
        }
        
        layout.addComponents( inputs.toArray( new GuessInputField[] {} ) );
        
        return layout;
    }
}
