package de.fichtelmax.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

// @formatter:off
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
// @formatter:on
public class Mastermind<T>
{
    private List<T> solution = new ArrayList<>();
    
    /**
     * Create a new Mastermind instance with a given solution.
     * 
     * @param solution
     *            The Solution for this Mastermind game.
     */
    public Mastermind( List<T> solution )
    {
        this.solution = solution;
    }
    
    /**
     * Create a new Mastermind instance with a given solution.
     * 
     * @param solution
     *            The Solution for this Mastermind game.
     */
    @SafeVarargs
    public Mastermind( T... solution )
    {
        this( Arrays.asList( solution ) );
    }
    
    /**
     * Create a new Mastermind instance with a random solution out of the given pool with the defined size.
     * 
     * @param size
     *            The size of the solution - How many elements may a solution have (this would be 4 in the original game)?
     * @param options
     *            The pool of options from which the solution should be created. (This would be 6 colors in the original game)
     * @return A new Mastermind instance with a random solution based on the given parameters.
     */
    @SafeVarargs
    public static <T> Mastermind<T> randomSolution( int size, T... options )
    {
        return randomSolution( size, Arrays.asList( options ) );
    }
    
    /**
     * Create a new Mastermind instance with a random solution out of the given pool with the defined size.
     * 
     * @param size
     *            The size of the solution - How many elements may a solution have (this would be 4 in the original game)?
     * @param options
     *            The pool of options from which the solution should be created. (This would be 6 colors in the original game)
     * @return A new Mastermind instance with a random solution based on the given parameters.
     */
    public static <T> Mastermind<T> randomSolution( int size, List<T> options )
    {
        Random random = new Random();
        ArrayList<T> solution = new ArrayList<>();
        
        for ( int i = 0; i < size; i++ )
        {
            int randomIndex = random.nextInt( options.size() );
            solution.add( options.get( randomIndex ) );
        }
        
        return new Mastermind<T>( solution );
    }
    
    /**
     * Submit a guess for this game instances solution.
     * 
     * @param guess
     *            a guess for this game instances solution.
     * @return A result containing the correct hits (color at the correct position) and the "color" hits (right color at the wrong position)
     */
    public GuessResult guess( @SuppressWarnings( "unchecked" ) T... guess )
    {
        return guess( Arrays.asList( guess ) );
    }
    
    /**
     * Submit a guess for this game instances solution.
     * 
     * @param guess
     *            a guess for this game instances solution.
     * @return A result containing the correct hits (color at the correct position) and the "color" hits (right color at the wrong position)
     */
    public GuessResult guess( List<T> guess )
    {
        GuessResult result = new GuessResult();
        List<T> solutionCopy = new ArrayList<>( solution );
        List<T> guessCopy = new ArrayList<>( guess );
        
        if ( guess == null || guess.size() != solutionCopy.size() )
        {
            throw new IllegalArgumentException( "Illegal input: " + guess );
        }
        
        result.setDirectHits( checkForDirectHits( guessCopy, solutionCopy ) );
        result.setColorHits( checkForColorHits( guessCopy, solutionCopy ) );
        
        return result;
    }
    
    /**
     * Checks the solution for any occurences of correct colors in the guess.
     * <p>
     * Any hit will be removed from both lists.
     * </p>
     * 
     * @param guessCopy
     *            a copy of a guess with direct hits removed.
     * @param solutionCopy
     *            a copy of the solution with direct hits removed.
     * @return the number of color hits (correct color, wrong position)
     */
    private static <T> int checkForColorHits( List<T> guessCopy, List<T> solutionCopy )
    {
        int hits = 0;
        for ( T guessItem : new ArrayList<>( guessCopy ) )
        {
            if ( solutionCopy.contains( guessItem ) )
            {
                hits++;
                guessCopy.remove( guessItem );
                solutionCopy.remove( guessItem );
            }
        }
        
        return hits;
    }
    
    /**
     * Traverses the given List copies for guess and solution from last to first.
     * <p>
     * if a pair matches, the element is removed from both lists
     * <p>
     * <b>Attention:</b> Both lists will be manipulated if a hit is detected!
     * 
     * @param guessCopy
     *            a copy of a guess with direct hits removed.
     * @param solutionCopy
     *            a copy of the solution with direct hits removed.
     * @return the number of direct hits (correct color, correct position)
     */
    private static <T> int checkForDirectHits( List<T> guessCopy, List<T> solutionCopy )
    {
        int hits = 0;
        
        for ( int i = solutionCopy.size() - 1; i >= 0; i-- )
        {
            if ( solutionCopy.get( i ).equals( guessCopy.get( i ) ) )
            {
                hits++;
                solutionCopy.remove( i );
                guessCopy.remove( i );
            }
        }
        return hits;
    }
}
