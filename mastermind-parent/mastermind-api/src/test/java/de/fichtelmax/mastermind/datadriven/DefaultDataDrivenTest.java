package de.fichtelmax.mastermind.datadriven;

import java.util.List;

import de.fichtelmax.mastermind.Mastermind;
import de.fichtelmax.mastermind.MastermindImpl;

public class DefaultDataDrivenTest extends DataDrivenTest
{
    public DefaultDataDrivenTest( TestDataItem testData )
    {
        super( testData );
    }
    
    @Override
    protected Mastermind<String> newMastermind( List<String> solution )
    {
        return new MastermindImpl<>( solution );
    }
    
}
