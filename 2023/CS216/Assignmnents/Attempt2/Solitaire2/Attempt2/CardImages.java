package Attempt2;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

/**
 * A class to store and manage images of the 52 cards.
 */
public final class CardImages 
{
	private static final String IMAGE_LOCATION = "../cardIMGS";
	private static final String IMAGE_SUFFIX = ".png";
	private static final String[] RANK_CODES = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
	private static final String[] SUIT_CODES = {"clubs", "diamonds", "hearts", "spades"};	
	
	private static Map<String, Image> aCards = new HashMap<String, Image>();
	
	private CardImages()
	{}
	
	/**
	 * Return the image of a card.
	 * @param pCard the target card
	 * @return An icon representing the chosen card.
	 */
	public static Image getCard( Card pCard )
	{
		assert pCard != null;
		return getCard( getCode( pCard ) );
	}
	
	private static Image getCard( String pCode )
	{
		Image image = (Image) aCards.get( pCode );
		if( image == null )
		{
			image = new Image(CardImages.class.getClassLoader().getResourceAsStream( IMAGE_LOCATION + pCode + IMAGE_SUFFIX ));
			aCards.put( pCode, image );
		}
		return image;
	}
	
	/**
	 * Return an image of the back of a card.
	 * @return An icon representing the back of a card.
	 */
	public static Image getBack()
	{
		return getCard( "b" );
	}
	
	private static String getCode( Card pCard )
	{
		return RANK_CODES[ pCard.getRank().ordinal() ] + SUIT_CODES[ pCard.getSuit().ordinal() ];		
	}
}