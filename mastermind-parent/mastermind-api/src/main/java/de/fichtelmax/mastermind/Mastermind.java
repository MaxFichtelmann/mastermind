package de.fichtelmax.mastermind;

import java.util.List;

//@formatter:off
/**
* An API for creating Mastermind like games.
* <p>
* <a href="http://en.wikipedia.org/wiki/Mastermind_(board_game)" >
* Wikipedia: Mastermind (board game)</a>
* </p>
* 
* @author Max Fichtelmann
* 
* @param <T>
*            The type of the possible solutions. <b>MUST</b> implement a proper equals method!
*/
//@formatter:on
public interface Mastermind<T>
{
    /**
     * Submit a guess for this game instances solution.
     * 
     * @param guess
     *            a guess for this game instances solution.
     * @return A result containing the correct hits (color at the correct position) and the "color" hits (right color at the wrong position)
     */
    GuessResult guess( @SuppressWarnings( "unchecked" ) T... guess );
    
    /**
     * Submit a guess for this game instances solution.
     * 
     * @param guess
     *            a guess for this game instances solution.
     * @return A result containing the correct hits (color at the correct position) and the "color" hits (right color at the wrong position)
     */
    GuessResult guess( List<T> guess );
}