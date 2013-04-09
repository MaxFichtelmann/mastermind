package de.fichtelmax.mastermind.vaadin;

import java.util.Arrays;
import java.util.List;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;

import de.fichtelmax.mastermind.vaadin.components.ColorDragField;
import de.fichtelmax.mastermind.vaadin.components.GuessInputField;

@Theme( "mastermind" )
@Title( "Mastermind" )
public class MastermindUI extends UI
{
    private static final long serialVersionUID = -8024776458773591101L;
    
    @Override
    protected void init( VaadinRequest request )
    {
        Layout main = new HorizontalLayout();
        main.setSizeFull();
        setContent( main );
        
        List<String> colors = Arrays.asList( "red", "green", "yellow", "blue", "purple", "orange" );
        
        HorizontalLayout colorSelection = new HorizontalLayout();
        for ( String color : colors )
        {
            ColorDragField colorDragField = new ColorDragField( color );
            colorSelection.addComponent( colorDragField );
        }
        
        HorizontalLayout guessPanel = new HorizontalLayout();
        GuessInputField input1 = new GuessInputField();
        GuessInputField input2 = new GuessInputField();
        GuessInputField input3 = new GuessInputField();
        GuessInputField input4 = new GuessInputField();
        
        guessPanel.addComponent( input1 );
        guessPanel.addComponent( input2 );
        guessPanel.addComponent( input3 );
        guessPanel.addComponent( input4 );
        
        main.addComponent( colorSelection );
        main.addComponent( guessPanel );
    }
}
