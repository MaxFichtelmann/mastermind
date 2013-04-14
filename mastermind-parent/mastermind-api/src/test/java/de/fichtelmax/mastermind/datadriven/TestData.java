package de.fichtelmax.mastermind.datadriven;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType( XmlAccessType.FIELD )
public class TestData
{
    @XmlElement( name = "item" )
    private List<TestDataItem> items = new ArrayList<>();
    
    public List<TestDataItem> getItems()
    {
        return items;
    }
    
    public void setItems( List<TestDataItem> items )
    {
        this.items = items;
    }
}
