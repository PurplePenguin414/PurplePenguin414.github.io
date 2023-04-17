package Attempt2;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Keeps track of the current state of the game and provides
 * a facade to it. 
 * 
 * The game state can logically be separated into four distinct 
 * conceptual elements: the deck, the discard pile, the foundations
 * where completed suits are accumulated, and the tableau, which consists of
 * seven piles where cards fan down in sequences of alternating suit colors.
 */
public final class GameModel implements GameModelView
{
	private static final Move NULL_MOVE = new Move()
	{
		@Override
		public void perform()
		{} // Does nothing on purpose

		@Override
		public boolean isNull()
		{ return true; }

		@Override
		public void undo()
		{} // Does nothing on purpose
	};
	
	private final Move aDiscardMove = new Move()
	{
		@Override
		public void perform()
		{
			assert !isDeckEmpty();	
			aDiscard.push(aDeck.draw());
			aMoves.push(this);
			notifyListeners();
		}

		@Override
		public void undo()
		{
			assert !isDiscardPileEmpty();
			aDeck.push(aDiscard.pop());
			notifyListeners();
		}
	};
	
	private final Deck aDeck = new Deck();
	private final Stack<Move> aMoves = new Stack<>();
	private final DeckStack aDiscard = new DeckStack();
	private final Foundations aFoundations = new Foundations();
	private final Tableau aTableau = new Tableau();
	private final List<GameModelListener> aListeners = new ArrayList<>();
	private final PlayingStrategy aPlayingStrategy;
	
	/**
	 * Creates a new game model initialized to a new game.
	 * @param pPlayingStrategy The strategy to use for auto-play. 
	 * @pre pPlayingStrategy != null
	 */
	public GameModel(PlayingStrategy pPlayingStrategy)
	{
		assert pPlayingStrategy != null;
		aPlayingStrategy = pPlayingStrategy;
		reset();
	}
	
	/**
	 * @return The number of cards in the foundations.
	 */
	public int getScore()
	{
		return aFoundations.getTotalSize();
	}
	
	/**
	 * Try to automatically make a move. This may result in nothing happening
	 * if the auto-play strategy cannot make a decision.
	 * @return Whether a move was performed or not.
	 */
	public boolean tryToAutoPlay()
	{
		Move move = aPlayingStrategy.getLegalMove(this);
		move.perform();
		return !move.isNull();
	}
	
	/**
	 * Registers an observer for the state of the game model.
	 * @param pListener A listener to register.
	 * @pre pListener != null
	 */
	public void addListener(GameModelListener pListener)
	{
		assert pListener != null;
		aListeners.add(pListener);
	}
	
	private void notifyListeners()
	{
		for( GameModelListener listener : aListeners )
		{
			listener.gameStateChanged();
		}
	}
	
	/**
	 * Restores the model to the state corresponding to the start of a new game.
	 */
	public void reset()
	{
		aMoves.clear();
		aDeck.shuffle();
		aDiscard.clear();
		aFoundations.initialize();
		aTableau.initialize(aDeck);
		notifyListeners();
	}
	
	/**
	 * @return True if the game is completed.
	 */
	public boolean isCompleted()
	{
		return aFoundations.getTotalSize() == Rank.values().length * Suit.values().length;
	}
	
	@Override
	public boolean isDeckEmpty()
	{
		return aDeck.isEmpty();
	}
	
	@Override
	public boolean isDiscardPileEmpty()
	{
		return aDiscard.isEmpty();
	}
	
	@Override
	public boolean isFoundationPileEmpty(FoundationPile pPile)
	{
		return aFoundations.isEmpty(pPile);
	}
	
	/**
	 * Obtain the card on top of the foundation pile pPile
	 * without removing it.
	 * @param pPile The pile to check.
	 * @return The card on top of the pile.
	 * @pre pPile != null && !isFoundationPileEmpty(pIndex)
	 */
	public Card peekSuitStack(FoundationPile pPile)
	{
		assert pPile != null && !isFoundationPileEmpty(pPile);
		return aFoundations.peek(pPile);
	}
	
	@Override
	public Card peekDiscardPile()
	{
		assert aDiscard.size() != 0;
		return aDiscard.peek();
	}
	
	/**
	 * @param pCard A card to locate
	 * @return The game location where this card currently is.
	 * @pre the card is in a location where it can be found and moved.
	 */
	private Location find(Card pCard)
	{
		if( !aDiscard.isEmpty() && aDiscard.peek() == pCard )
		{
			return OtherLocation.DISCARD_PILE;
		}
		for( FoundationPile index : FoundationPile.values() )
		{
			if( !aFoundations.isEmpty(index) && aFoundations.peek(index) == pCard )
			{
				return index;
			}
		}
		for( Pile index : Pile.values() )
		{
			if( aTableau.contains(pCard, index))
			{
				return index;
			}
		}
		assert false; // We did not find the card: the precondition was not met.
		return null;
	}
	
	/**
	 * Undoes the last move.
	 */
	public void undoLast()
	{
		if( !aMoves.isEmpty() )
		{
			aMoves.pop().undo();
		}
	}
	
	/**
	 * @return If there is a move to undo.
	 */
	public boolean canUndo()
	{
		return !aMoves.isEmpty();
	}
	
	/*
	 * Removes the moveable card from pLocation.
	 */
	private void absorbCard(Location pLocation)
	{
		if( pLocation == OtherLocation.DISCARD_PILE )
		{
			assert !aDiscard.isEmpty();
			aDiscard.pop();
		}
		else if( pLocation instanceof FoundationPile )
		{
			assert !aFoundations.isEmpty((FoundationPile)pLocation);
			aFoundations.pop((FoundationPile)pLocation);
		}
		else
		{
			assert pLocation instanceof Pile;
			aTableau.pop((Pile)pLocation);
		}
	}
	
	private void move(Card pCard, Location pDestination)
	{
		Location source = find(pCard);
		if( source instanceof Pile && pDestination instanceof Pile )
		{
			aTableau.moveWithin(pCard, (Pile)source, (Pile) pDestination);
		}
		else
		{
			absorbCard(source);
			if( pDestination instanceof FoundationPile )
			{
				aFoundations.push(pCard, (FoundationPile)pDestination);
			}
			else if( pDestination == OtherLocation.DISCARD_PILE )
			{
				aDiscard.push(pCard);
			}
			else
			{
				assert pDestination instanceof Pile;
				aTableau.push(pCard, (Pile)pDestination);
			}
		}
		notifyListeners();
	}
	
	@Override
	public DeckStack getPile(Pile pIndex)
	{
		return aTableau.getPile(pIndex); 
	}
	
	@Override
	public boolean isVisibleInTableau(Card pCard)
	{
		return aTableau.contains(pCard) && aTableau.isVisible(pCard);
	}
	
	@Override
	public boolean isLowestVisibleInTableau(Card pCard)
	{
		return aTableau.contains(pCard) && aTableau.isLowestVisible(pCard);
	}
	
	/**
	 * Get the sequence consisting of pCard and all 
	 * the other cards below it, from the tableau.
	 * @param pCard The top card of the sequence
	 * @param pPile The requested pile
	 * @return A non-empty sequence of cards.
	 * @pre pCard != null and is in pile pPile
	 */
	public DeckStack getSubStack(Card pCard, Pile pPile)
	{
		assert pCard != null && pPile != null && find(pCard) == pPile;
		return aTableau.getSequence(pCard, pPile);
	}

	@Override
	public boolean isLegalMove(Card pCard, Location pDestination )
	{ 
		if( pDestination instanceof FoundationPile )
		{
			return aFoundations.canMoveTo(pCard, (FoundationPile) pDestination);
		}
		else if( pDestination instanceof Pile )
		{
			return aTableau.canMoveTo(pCard, (Pile) pDestination);
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public Move getNullMove()
	{
		return NULL_MOVE;
	}
	
	@Override
	public Move getDiscardMove()
	{
		return aDiscardMove;
	}
	
	@Override
	public Move getCardMove(Card pCard, Location pDestination)
	{
		Location source = find( pCard );
		if( source instanceof Pile  && aTableau.revealsTop(pCard))
		{
			return new CompositeMove(new CardMove(pCard, pDestination), new RevealTopMove((Pile)source) );
		}
		return new CardMove(pCard, pDestination);
	} 
	
	@Override
	public boolean isBottomKing(Card pCard)
	{
		assert pCard != null && aTableau.contains(pCard);
		return aTableau.isBottomKing(pCard);
	}

	
	/**
	 * A move that represents the intention to move pCard
	 * to pDestination, possibly including all cards stacked
	 * on top of pCard if pCard is in a working stack.
	 */
	private class CardMove implements Move
	{
		private Card aCard;
		private Location aOrigin; 
		private Location aDestination; 
		
		CardMove(Card pCard, Location pDestination)
		{
			aCard = pCard;
			aDestination = pDestination;
			aOrigin = find(pCard);
		}

		@Override
		public void perform()
		{
			assert isLegalMove(aCard, aDestination);
			move(aCard, aDestination);
			aMoves.push(this);
		}

		@Override
		public void undo()
		{
			move(aCard, aOrigin);
		}
	}
	
	/**
	 * reveals the top of the stack.
	 *
	 */
	private class RevealTopMove implements Move
	{
		private final Pile aIndex;
		
		RevealTopMove(Pile pIndex)
		{
			aIndex = pIndex;
		}
		
		@Override
		public void perform()
		{
			aTableau.showTop(aIndex);
			aMoves.push(this);
			notifyListeners();
		}

		@Override
		public void undo()
		{
			aTableau.hideTop(aIndex);
			aMoves.pop().undo();
			notifyListeners();
		}
	}
}