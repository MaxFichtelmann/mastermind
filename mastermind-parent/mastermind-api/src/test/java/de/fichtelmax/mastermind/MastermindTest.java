package de.fichtelmax.mastermind;

import static de.fichtelmax.mastermind.test.Item.A;
import static de.fichtelmax.mastermind.test.Item.D;
import static de.fichtelmax.mastermind.test.Item.F;
import static de.fichtelmax.mastermind.test.Item.S;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import de.fichtelmax.mastermind.test.Item;

public class MastermindTest
{
    
    @Before
    public void setup()
    {
        new MastermindImpl<>( A, D, F, S );
    }
    
    @Test
    public void successAllSame()
    {
        Mastermind<Item> mastermind = new MastermindImpl<>( A, A, A, A );
        GuessResult result = mastermind.guess( A, A, A, A );
        
        assertThat( result.getDirectHits(), is( 4 ) );
        assertThat( result.getColorHits(), is( 0 ) );
    }
    
    @Test
    public void successAllOther()
    {
        Mastermind<Item> mastermind = new MastermindImpl<>( A, D, F, S );
        GuessResult result = mastermind.guess( A, D, F, S );
        
        assertThat( result.getDirectHits(), is( 4 ) );
        assertThat( result.getColorHits(), is( 0 ) );
    }
    
    @Test
    public void successFewOther()
    {
        Mastermind<Item> mastermind = new MastermindImpl<>( A, D, D, S );
        GuessResult result = mastermind.guess( A, D, D, S );
        
        assertThat( result.getDirectHits(), is( 4 ) );
        assertThat( result.getColorHits(), is( 0 ) );
    }
    
    @Test
    public void noSuccessAllSame()
    {
        Mastermind<Item> mastermind = new MastermindImpl<>( A, A, A, A );
        GuessResult result = mastermind.guess( S, S, S, S );
        
        assertThat( result.getDirectHits(), is( 0 ) );
        assertThat( result.getColorHits(), is( 0 ) );
    }
    
    @Test
    public void noSuccessAllOther()
    {
        Mastermind<Item> mastermind = new MastermindImpl<>( A, D, F, S );
        GuessResult result = mastermind.guess( S, A, D, F );
        
        assertThat( result.getDirectHits(), is( 0 ) );
        assertThat( result.getColorHits(), is( 4 ) );
    }
}
