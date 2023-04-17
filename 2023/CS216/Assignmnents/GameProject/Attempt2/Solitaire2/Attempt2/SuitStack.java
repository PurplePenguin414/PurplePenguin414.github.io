package Attempt2;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;

/**
 * Component that shows a stack of cards in 
 * which a completed suit is accumulated.
 */
public class SuitStack extends StackPane implements GameModelListener
{
	private static final int PADDING = 5;
	// CSOFF:
	private static final String BORDER_STYLE = "-fx-border-color: lightgray;"
			+ "-fx-border-width: 3;" + " -fx-border-radius: 10.0";
	private static final String BORDER_STYLE_DRAGGED = "-fx-border-color: darkgray;"
			+ "-fx-border-width: 3;" + " -fx-border-radius: 10.0";
	private static final String BORDER_STYLE_NORMAL = "-fx-border-color: lightgray;"
			+ "-fx-border-width: 3;" + " -fx-border-radius: 10.0";
	// CSON:
	
	private Drag aDragHandler;
	private FoundationPile aIndex;
	private final GameModel aModel;
	
	SuitStack(GameModel pModel, FoundationPile pIndex)
	{
		aModel = pModel;
		aIndex = pIndex;
		setPadding(new Insets(PADDING));
		setStyle(BORDER_STYLE);
		final ImageView image = new ImageView(CardImages.getBack());
    	image.setVisible(false);
       	getChildren().add(image);
    	aDragHandler = new Drag(image);
    	image.setOnDragDetected(aDragHandler);
    	setOnDragOver(createOnDragOverHandler(image));
    	setOnDragEntered(createOnDragEnteredHandler());
    	setOnDragExited(createOnDragExitedHandler());
    	setOnDragDropped(createOnDragDroppedHandler());
    	aModel.addListener(this);
	}
	
	@Override
	public void gameStateChanged()
	{
		if( aModel.isFoundationPileEmpty(aIndex))
		{
			getChildren().get(0).setVisible(false);
		}
		else
		{
			getChildren().get(0).setVisible(true);
			Card topCard = aModel.peekSuitStack(aIndex);
			ImageView image = (ImageView)getChildren().get(0);
			image.setImage(CardImages.getCard(topCard));
			aDragHandler.setCard(topCard);
		}
	}
	
	private EventHandler<DragEvent> createOnDragOverHandler(final ImageView pView)
	{
		return new EventHandler<DragEvent>()
    	{
    	    public void handle(DragEvent pEvent) 
    	    {
    	    	if(pEvent.getGestureSource() != pView && pEvent.getDragboard().hasString())
    	    	{
    	    		CardTransfer transfer = new CardTransfer(pEvent.getDragboard().getString());
    	    		if( transfer.size() == 1 && aModel.isLegalMove(transfer.getTop(), aIndex) )
    	    		{
    	    			pEvent.acceptTransferModes(TransferMode.MOVE);
    	    		}
    	    	}

    	    	pEvent.consume();
    	    }
    	};
	}
	
	private EventHandler<DragEvent> createOnDragEnteredHandler()
	{
		return new EventHandler<DragEvent>()
    	{
    		public void handle(DragEvent pEvent) 
    		{
    			CardTransfer transfer = new CardTransfer(pEvent.getDragboard().getString());
	    		if( transfer.size() == 1 && aModel.isLegalMove(transfer.getTop(), aIndex) )
    			{
    				setStyle(BORDER_STYLE_DRAGGED);
    			}
    			pEvent.consume();
    		}
    	};
	}
	
	private EventHandler<DragEvent> createOnDragExitedHandler()
	{
		return new EventHandler<DragEvent>()
    	{
    		public void handle(DragEvent pEvent)
    		{
    			setStyle(BORDER_STYLE_NORMAL);
    			pEvent.consume();
    		}
    	};
	}
	
	private EventHandler<DragEvent> createOnDragDroppedHandler()
	{
		return new EventHandler<DragEvent>() 
    	{
    		public void handle(DragEvent pEvent)
    		{
    			Dragboard db = pEvent.getDragboard();
    			boolean success = false;
    			if(db.hasString()) 
    			{
    				CardTransfer transfer = new CardTransfer(pEvent.getDragboard().getString());
    				aModel.getCardMove(transfer.getTop(), aIndex).perform();
    				success = true;
    			}
    			pEvent.setDropCompleted(success);
    			pEvent.consume();
    		}
    	};
	}
}