package Attempt2;

/**
 * A read-only version of a game model.
 */
public interface GameModelView
{
	/**
	 * @return True if the discard pile has no card in it.
	 */
	boolean isDiscardPileEmpty();
	
	/**
	 * @return True if the deck has no card left in it.
	 */
	boolean isDeckEmpty();
	
	/**
	 * @param pIndex The suit stack to check
	 * @return True if the suit stack for pSuit is empty
	 */
	boolean isFoundationPileEmpty(FoundationPile pIndex);
	
	/**
	 * @return The card on top of the discard pile.
	 * @pre !emptyDiscardPile()
	 */
	Card peekDiscardPile();
	
	/**
	 * @param pIndex The position of the stack to return.
	 * @return A copy of the stack at position pIndex
	 */
	DeckStack getPile(Pile pIndex);
	
	/**
	 * @param pCard A card to test for visibility.
	 * @return True if the card's value is visible in
	 *     the tableau;
	 */
	boolean isVisibleInTableau(Card pCard);
	
	/**
	 * @param pCard The card to test
	 * @return True if pCard is in the tableau and is 
	 *     the lowest card visible in its pile, including 
	 *     the case where it's the only card in the pile.
	 */
	boolean isLowestVisibleInTableau(Card pCard);
	
	/**
	 * @param pCard The card to check.
	 * @return True if pCard is a visible king located at the bottom of the pile.
	 * @pre pCard != null && contains(pCard);
	 */
	boolean isBottomKing(Card pCard);
	
	/**
	 * Determines if pCard can be moved to pLocation
	 * according to the rules of the game and given the current
	 * game state. 
	 * @param pCard The card to move. 
	 * @param pDestination The destination of the move.
	 * @return True if the move is a legal move.
	 */
	boolean isLegalMove(Card pCard, Location pDestination );
	
	/**
	 * @return An instance of the Move interface
	 *     that represents no move at all.
	 */
	Move getNullMove();
	
	/**
	 * @return An instance of the Move interface
	 *     that represents discarding a card from the deck.
	 */
	Move getDiscardMove();
	
	/**
	 * that represents moving a card (and possibly
	 * all cards below it if applicable) to pDestination.
	 * @param pCard The card to move, assumed to be in a 
	 *     legal position.
	 * @param pDestination The required destination of the card.
 	 * @return An instance of the Move interface
	 */
	Move getCardMove(Card pCard, Location pDestination);
}