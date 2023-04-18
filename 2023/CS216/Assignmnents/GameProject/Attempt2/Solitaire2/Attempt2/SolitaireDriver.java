package Attempt2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Application class for Solitaire. The responsibility
 * of this class is limited to assembling the major UI components 
 * and launching the application. All gesture handling logic is 
 * handled by its composed elements, which act as observers
 * of the game model.
 */
public class SolitaireDriver extends Application
{
	private static final int WIDTH = 680;
	private static final int HEIGHT = 500;
	private static final int MARGIN_OUTER = 10;
	private static final String TITLE = "Solitaire";
	private static final String VERSION = "1.0";

	/**
	 * Application head.
	 */
	public SolitaireDriver() {}
    
	/**
	 * Launches the application.
	 */
	public static void main(String[] pArgs) 
	{
        launch(pArgs);
    }
	    
    @Override
    public void start(Stage pPrimaryStage) 
    {
		pPrimaryStage.setTitle(TITLE + " " + VERSION); 
           
        GridPane root = new GridPane();
        root.setStyle("-fx-background-color: green;");
        root.setHgap(MARGIN_OUTER);
        root.setVgap(MARGIN_OUTER);
        root.setPadding(new Insets(MARGIN_OUTER));
        
    	final GameModel model = new GameModel(null);
    	DeckView deckView = new DeckView(model);
        DiscardPileView discardPileView = new DiscardPileView(model);

        root.add(deckView, 0, 0);
        root.add(discardPileView, 1, 0);
                
        for( FoundationPile index : FoundationPile.values() )
        {
        	root.add(new SuitStack(model, index), 3+index.ordinal(), 0);
        }
      
        for( Pile index : Pile.values() )
        {
        	root.add(new CardPileView(model, index), index.ordinal(), 1);
        }
        
        pPrimaryStage.setResizable(false);
        pPrimaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        pPrimaryStage.show();
    }
}