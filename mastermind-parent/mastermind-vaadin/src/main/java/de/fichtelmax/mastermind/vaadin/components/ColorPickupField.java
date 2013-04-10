package de.fichtelmax.mastermind.vaadin.components;

import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ColorPickupField extends VerticalLayout
{
    private static final long serialVersionUID = -3826351615919771871L;
    private Label             main;
    
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
    
    @Override
    public void setWidth( float width, Unit unit )
    {
        super.setWidth( width, unit );
        if ( main != null )
            main.setWidth( width, unit );
    }
    
    @Override
    public void setHeight( float height, Unit unit )
    {
        super.setHeight( height, unit );
        if ( main != null )
            main.setHeight( height, unit );
    }
}
