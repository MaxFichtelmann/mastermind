package de.fichtelmax.mastermind.datadriven;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType( XmlAccessType.FIELD )
public class TestDataItem
{
    @XmlList
    private List<String> solution = new ArrayList<>();
    
    @XmlList
    private List<String> guess    = new ArrayList<>();
    
    private int          expectedDirect;
    private int          expectedColor;
    
    private String       expectedException;
    
    public List<String> getSolution()
    {
        return solution;
    }
    
    public void setSolution( List<String> solution )
    {
        this.solution = solution;
    }
    
    public List<String> getGuess()
    {
        return guess;
    }
    
    public void setGuess( List<String> guess )
    {
        this.guess = guess;
    }
    
    public int getExpectedDirect()
    {
        return expectedDirect;
    }
    
    public void setExpectedDirect( int expectedDirect )
    {
        this.expectedDirect = expectedDirect;
    }
    
    public int getExpectedColor()
    {
        return expectedColor;
    }
    
    public void setExpectedColor( int expectedColor )
    {
        this.expectedColor = expectedColor;
    }

    public String getExpectedException()
    {
        return expectedException;
    }

    public void setExpectedException( String expectedException )
    {
        this.expectedException = expectedException;
    }
}
