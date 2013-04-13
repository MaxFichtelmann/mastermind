package de.fichtelmax.mastermind.vaadin.components;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

/**
 * A simple Vaadin label for displaying a colored component.
 * <p>
 * Usage of {@link Label#setCaption(String)} is discouraged.
 * </p>
 * 
 * @author Max Fichtelmann
 * 
 */
public class ColorField extends Label
{
    
    private static final long serialVersionUID = -4092501704893941118L;
    private String            color;
    
    /**
     * Creates a new {@link ColorField} with the given color.
     * <p>
     * Any CSS color String is allowed such as:
     * <ul>
     * <li>white</li>
     * <li>#FFFFFF</li>
     * <li>rgb(255,255,255)</li>
     * </ul>
     * </p>
     * 
     * @param color
     *            the desired color of this field.
     */
    public ColorField( String color )
    {
        super( buildValue( color ), ContentMode.HTML );
        this.color = color;
    }
    
    /**
     * change the color of this field.
     * 
     * @param color
     *            the desired color of this field.
     */
    public void setColor( String color )
    {
        this.color = color;
        setValue( buildValue( color ) );
    }
    
    /**
     * Get the current color of this field.
     * 
     * @return the current color of this field.
     */
    public String getColor()
    {
        return color;
    }
    
    /**
     * Create the underlying div with the specified background color and 100% width/height.
     * 
     * @param color
     *            the specified background color
     * @return the html div String - intended for {@link #setValue(String)}
     */
    private static String buildValue( String color )
    {
        return "<div style=\"width:100%;height:100%;background-color:" + color + ";\"/>";
    }
}
