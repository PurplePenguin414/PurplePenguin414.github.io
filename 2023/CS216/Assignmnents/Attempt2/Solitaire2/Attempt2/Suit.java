package Attempt2;

/**
 * Represents the suit of a playing card.
 */
public enum Suit 
{ 
	CLUBS, DIAMONDS, HEARTS, SPADES; 
	
	/**
	 * @param pSuit The suit to test against.
	 * @return True if this suit and pSuit are of the same color.
	 * @pre pSuit != null;
	 */
	public boolean sameColorAs(Suit pSuit)
	{
		assert pSuit != null;
		if( this == CLUBS || this == SPADES )
		{
			return pSuit == CLUBS || pSuit == SPADES;
		}
		else
		{
			return pSuit == DIAMONDS || pSuit == HEARTS;
		}
	}
}




