package Attempt2;


/**
 * Represents one possible action in the game.
 */
public interface Move
{
	/**
	 * Performs the move. 
	 * @pre The move is legal
	 */
	void perform();
	
	/**
	 * Undoes the move by reversing
	 * its effect.
	 */
	void undo();
	
	/**
	 * @return True if the move is not a move that
	 *     advances the game. False by default.
	 */
	default boolean isNull()
	{ return false; }
}