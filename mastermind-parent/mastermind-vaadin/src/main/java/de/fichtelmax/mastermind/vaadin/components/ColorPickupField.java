package de.fichtelmax.mastermind.vaadin.components;

import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * A wrapper component for a draggable {@link ColorField}.
 * 
 * @author Max Fichtelmann
 * 
 */
public class ColorPickupField extends VerticalLayout
{
    private static final long serialVersionUID = -3826351615919771871L;
    private Label             main;
    
    /**
     * Create a draggable {@link ColorField} wrapper with the specified color.
     * 
     * @param color
     *            the color of this field.
     */
    public ColorPickupField( String color )
    {
        main = new ColorField( color );
        main.setWidth( getWidth(), getWidthUnits() );
        main.setHeight( getHeight(), getHeightUnits() );
        
        DragAndDropWrapper dragWrapper = new DragAndDropWrapper( main );
        dragWrapper.setDragStartMode( DragStartMode.COMPONENT );
        dragWrapper.setSizeUndefined();
        
        addComponent( dragWrapper );
        addStyleName( "pickup" );
    }
    
    /*
     * (non-Javadoc)
     * 
     * width/height are propagated to the wrapped colorfield.
     * 
     * @see com.vaadin.ui.AbstractComponentContainer#setWidth(float, com.vaadin.server.Sizeable.Unit)
     */
    @Override
    public void setWidth( float width, Unit unit )
    {
        super.setWidth( width, unit );
        if ( main != null )
            main.setWidth( width, unit );
    }
    
    /*
     * (non-Javadoc)
     * 
     * width/height are propagated to the wrapped colorfield.
     * 
     * @see com.vaadin.ui.AbstractComponentContainer#setHeight(float, com.vaadin.server.Sizeable.Unit)
     */
    @Override
    public void setHeight( float height, Unit unit )
    {
        super.setHeight( height, unit );
        if ( main != null )
            main.setHeight( height, unit );
    }
}
