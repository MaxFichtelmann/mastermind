package de.fichtelmax.mastermind.vaadin.components;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;

/**
 * A Panel of a stylized solution template, which can show the actual solution in color.
 * 
 * @author Max Fichtelmann
 * 
 */
public class SolutionZone extends Panel
{
    private static final String DEFAULT_GREY     = "rgb(192,192,192)";
    
    private static final long   serialVersionUID = -775714200838033580L;
    
    private List<ColorField>    fields           = new ArrayList<>();
    
    /**
     * create a new Solution in state hidden.
     */
    public SolutionZone()
    {
        HorizontalLayout solution = new HorizontalLayout();
        
        for ( int i = 0; i < 4; i++ )
        {
            fields.add( createField() );
        }
        
        solution.addComponents( fields.toArray( new ColorField[] {} ) );
        
        setContent( solution );
    }
    
    /**
     * display the given solution
     * 
     * @param colors
     *            the solutions colors.
     */
    public void showSolution( List<String> colors )
    {
        for ( int i = 0; i < colors.size(); i++ )
        {
            fields.get( i ).setColor( colors.get( i ) );
        }
    }
    
    /**
     * hide the solution.
     */
    public void hideSolution()
    {
        for ( ColorField field : fields )
        {
            field.setColor( DEFAULT_GREY );
        }
    }
    
    private static ColorField createField()
    {
        ColorField field = new ColorField( DEFAULT_GREY );
        field.addStyleName( "solution" );
        field.addStyleName( "circle" );
        field.setWidth( "90px" );
        field.setHeight( "90px" );
        return field;
    }
}
