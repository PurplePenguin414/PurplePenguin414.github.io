package Attempt2;

/**
 * An immutable utility object to facilitate the transfer of card 
 * through the drag board (drag and drop space).
 */
public class CardTransfer
{
	private static final String SEPARATOR = ";";
	
	private Card[] aCards;
	
	/**
	 * Creates a card transfer from a serialized
	 * version of the cards.
	 * @param pString The serialized version
	 */
	public CardTransfer(String pString)
	{
		assert pString != null && pString.length() > 0;
		String[] tokens = pString.split(SEPARATOR);
		aCards = new Card[tokens.length];
		for( int i = 0; i < tokens.length; i++ )
		{
			aCards[i] = Card.get(tokens[i]);
		}
		assert aCards.length > 0;
	}
	
	/**
	 * Converts an array of cards into an id string
	 * that can be deserialized by the constructor.
	 * @param pCards The array of cards with high-ranking cards first.
	 * @return The id string.
	 */
	public static String serialize(DeckStack pCards)
	{
		String result = "";
		for(Card card : pCards)
		{
			result += card.getIDString() + SEPARATOR;
		}
		if( result.length() > 0)
		{
			result = result.substring(0, result.length()-1);
		}
		return result;
	}
	
	/**
	 * @return The top card in the transfer (the one with the highest rank)
	 */
	public Card getTop()
	{
		return aCards[0];
	}
	
	/**
	 * @return The number of cards in the transfer.
	 */
	public int size()
	{
		return aCards.length;
	}
}