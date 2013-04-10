package de.fichtelmax.mastermind.vaadin.components;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

public class ColorField extends Label
{
    
    private static final long serialVersionUID = -4092501704893941118L;
    private String            color;
    
    public ColorField( String color )
    {
        super( buildValue( color ), ContentMode.HTML );
        this.color = color;
    }
    
    public void setColor( String color )
    {
        this.color = color;
        setValue( buildValue( color ) );
    }
    
    public String getColor()
    {
        return color;
    }
    
    private static String buildValue( String color )
    {
        return "<div style=\"width:100%;height:100%;background-color:" + color + ";\"/>";
    }
}
