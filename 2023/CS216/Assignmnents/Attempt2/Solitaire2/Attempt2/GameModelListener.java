package Attempt2;

/**
 * Observer interface to be implemented by classes whose
 * objects are interested in being notified of a change
 * in the state of the game model.
 */
public interface GameModelListener
{
	/**
	 * Called whenever the state of the 
	 * game model changes.
	 */
	void gameStateChanged();
}
