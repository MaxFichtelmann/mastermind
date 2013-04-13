package de.fichtelmax.mastermind.vaadin.components;

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.event.dd.acceptcriteria.ServerSideCriterion;
import com.vaadin.shared.ui.dd.HorizontalDropLocation;
import com.vaadin.shared.ui.dd.VerticalDropLocation;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.WrapperTargetDetails;
import com.vaadin.ui.DragAndDropWrapper.WrapperTransferable;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * A Dropzone for ColorFields wrapped by a {@link DragAndDropWrapper}.
 * <p>
 * When a {@link ColorField} is dropped on this component, it takes on its color.
 * </p>
 * 
 * @author Max Fichtelmann
 * 
 */
public class GuessInputField extends VerticalLayout implements DropHandler
{
    
    private static final long serialVersionUID = 4299381421651671922L;
    private Label             main;
    
    private String            color            = null;
    
    /**
     * creates a new {@link GuessInputField} with the specified radius.
     * 
     * @param radius
     *            the radius of the visible component. 4px in height/width are added for the DDWrapper.
     */
    public GuessInputField( String radius )
    {
        main = new Label();
        main.setContentMode( ContentMode.HTML );
        main.addStyleName( "circle" );
        main.addStyleName( "dropzone" );
        main.setWidth( radius );
        main.setHeight( radius );
        
        DragAndDropWrapper dropWrapper = new DragAndDropWrapper( main );
        dropWrapper.setDropHandler( this );
        dropWrapper.setSizeUndefined();
        
        addComponent( dropWrapper );
    }
    
    @Override
    public void drop( DragAndDropEvent event )
    {
        Component sourceComponent = ((DragAndDropWrapper) event.getTransferable().getSourceComponent()).iterator().next();
        ColorField colorField = (ColorField) sourceComponent;
        
        main.setValue( colorField.getValue() );
        color = colorField.getColor();
    }
    
    public String getColor()
    {
        return color;
    }
    
    public void clear()
    {
        color = null;
        main.setValue( "" );
    }
    
    @Override
    public AcceptCriterion getAcceptCriterion()
    {
        return new ServerSideCriterion()
        {
            private static final long serialVersionUID = -1809596495394436550L;
            
            @Override
            public boolean accept( DragAndDropEvent dragEvent )
            {
                WrapperTargetDetails targetDetails = (WrapperTargetDetails) dragEvent.getTargetDetails();
                WrapperTransferable transferable = (WrapperTransferable) dragEvent.getTransferable();
                
                if ( targetDetails.getHorizontalDropLocation() == HorizontalDropLocation.CENTER
                        && targetDetails.getVerticalDropLocation() == VerticalDropLocation.MIDDLE
                        && transferable.getDraggedComponent() instanceof ColorField )
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        };
    }
}
