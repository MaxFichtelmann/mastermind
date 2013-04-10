package de.fichtelmax.mastermind.vaadin.components;

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.event.dd.acceptcriteria.ServerSideCriterion;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class GuessInputField extends VerticalLayout implements DropHandler
{
    
    private static final long serialVersionUID = 4299381421651671922L;
    private Label             main;
    
    public GuessInputField()
    {
        main = new Label();
        main.setContentMode( ContentMode.HTML );
        main.addStyleName( "circle" );
        main.addStyleName( "dropzone" );
        main.setWidth( "90px" );
        main.setHeight( "90px" );
        
        DragAndDropWrapper dropWrapper = new DragAndDropWrapper( main );
        dropWrapper.setDropHandler( this );
        dropWrapper.setSizeUndefined();
        
        addComponent( dropWrapper );
    }
    
    @Override
    public void drop( DragAndDropEvent event )
    {
        System.out.println( event );
        System.out.println( event.getTransferable() );
        System.out.println( event.getTransferable().getSourceComponent() );
        Component sourceComponent = ((DragAndDropWrapper) event.getTransferable().getSourceComponent()).iterator().next();
        ColorField colorField = (ColorField) sourceComponent;
        System.out.println( colorField.getColor() );
        System.out.println( colorField.getValue() );
        System.out.println( event.getTargetDetails() );
        
        main.setValue( colorField.getValue() );
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
                // TODO NYI
                return true;
            }
        };
    }
}
