package Attempt2;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Composite object in the composite 
 * design pattern.
 */
public class CompositeMove implements Move
{
	private final List<Move> aMoves = new ArrayList<>();
	
	/**
	 * @param pMoves Any move to be added to this composite
	 */
	public CompositeMove( Move ... pMoves)
	{
		for( Move move : pMoves )
		{
			aMoves.add(move);
		}
	}
	
	@Override
	public void perform()
	{
		for( Move move : aMoves )
		{
			move.perform();
		}
	}

	@Override
	public void undo()
	{
		for( int i = aMoves.size()-1; i >=0; i-- )
		{
			aMoves.get(i).undo();
		}
	}
}