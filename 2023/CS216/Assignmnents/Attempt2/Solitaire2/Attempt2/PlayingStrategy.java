package Attempt2;

/**
 * Game-playing behavior. Implementations of this interface
 * are responsible for ensuring that the sequence of Move 
 * instances returned does not put the game in and endless
 * cycle.
 */
public interface PlayingStrategy
{
	/**
	 * Returns a legal move for the game, or the 
	 * Null move if that is not possible.
	 * 
	 * @param pModel A game model to query.
	 * @return The move computed.
	 */
	Move getLegalMove(GameModelView pModel);
}