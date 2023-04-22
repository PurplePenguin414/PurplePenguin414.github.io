package Attempt2;

import java.util.*;

public final class Card
{
	// Indexed by suit, then rank
	private static final Card[][] CARDS = new Card[Suit.values().length][];
	
	// Create the flyweight objects
	static
	{
		for( Suit suit : Suit.values() )
		{
			CARDS[suit.ordinal()] = new Card[Rank.values().length];
			for( Rank rank : Rank.values() )
			{
				CARDS[suit.ordinal()][rank.ordinal()] = new Card(rank, suit);
			}
		}
	}
	
	private final Rank aRank;
	private final Suit aSuit;
	
	private Card(Rank pRank, Suit pSuit )
	{
		aRank = pRank;
		aSuit = pSuit;
	}
	
	/**
	 * Get a flyweight Card object.
	 * 
	 * @param pRank The rank of the card (from ace to kind)
	 * @param pSuit The suit of the card (clubs, diamond, spades, hearts)
	 * @return The card object representing the card with pRank and pSuit
	 */
	public static Card get(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		return CARDS[pSuit.ordinal()][pRank.ordinal()];
	}
	
	/**
	 * Get a flyweight card object based on its serialized form.
	 * 
	 * @param pId The id string for the card. This is needs to have
	 *     been produced by Card.getIDString to be considered a
	 *     valid input to this method.
	 * @return The card object with id string pId
	 */
	public static Card get( String pId )
	{
		assert pId != null;
		int id = Integer.parseInt(pId);
		return get(Rank.values()[id % Rank.values().length],
				Suit.values()[id / Rank.values().length]);
	}
	
	/**
	 * Obtain the rank of the card.
	 * @return An object representing the rank of the card.
	 */
	public Rank getRank()
	{
		return aRank;
	}
	
	/**
	 * Return the id string for this card.
	 * 
	 * @return A string uniquely representing this card. The string
	 *     format is not specified except that it is fully compatible
	 *     with the format expected by Card.get(String).
	 */
	public String getIDString()
	{
		return Integer.toString(getSuit().ordinal() * Rank.values().length + getRank().ordinal());
	}
	
	/**
	 * Obtain the suit of the card.
	 * @return An object representing the suit of the card 
	 */
	public Suit getSuit()
	{
		return aSuit;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return aRank + " of " + aSuit;
	}
}

