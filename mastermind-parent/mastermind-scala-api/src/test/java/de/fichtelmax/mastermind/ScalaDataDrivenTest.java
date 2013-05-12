package de.fichtelmax.mastermind;

import java.util.List;

import de.fichtelmax.mastermind.Mastermind;
import de.fichtelmax.mastermind.ScalaMastermindWrapper;
import de.fichtelmax.mastermind.datadriven.DataDrivenTest;
import de.fichtelmax.mastermind.datadriven.TestDataItem;

public class ScalaDataDrivenTest extends DataDrivenTest
{
    
    public ScalaDataDrivenTest( TestDataItem testData )
    {
        super( testData );
    }
    
    protected Mastermind<String> newMastermind( List<String> solution )
    {
        return new ScalaMastermindWrapper<String>( solution );
    }
    
}
