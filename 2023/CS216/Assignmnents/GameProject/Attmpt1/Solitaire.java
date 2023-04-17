package Attmpt1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class Solitaire extends Application {

    // Declare global variables
    private final int CARD_WIDTH = 71;
    private final int CARD_HEIGHT = 96;
    private final int FOUNDATION_OFFSET = 50;
    private final int TABLEAU_OFFSET = 30;
    private final int STOCK_OFFSET = 100;
    private final int CARD_SPACING = 20;
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 600;

    private final ArrayList<Card> deck = new ArrayList<>();
    private final ArrayList<Card> stock = new ArrayList<>();
    private final ArrayList<Card> waste = new ArrayList<>();
    private final ArrayList<Card>[] tableau = new ArrayList[7];
    private final ArrayList<Card>[] foundation = new ArrayList[4];

    private ImageView[] stockImages = new ImageView[1];
    private ImageView[] wasteImages = new ImageView[1];
    private ImageView[][] tableauImages = new ImageView[7][];
    private ImageView[][] foundationImages = new ImageView[4][];
    private boolean isStockEmpty = true;
    private int selectedTableau = -1;
    private int selectedFoundation = -1;

    @Override
    public void start(Stage primaryStage) {


        // Shuffle the deck
       Deck.Deck();

        // Initialize the tableau and foundation
        for (int i = 0; i < 7; i++) {
            tableau[i] = new ArrayList<>();
                for (int j = 0; j < i + 1; j++) {
                    tableau[i].add(deck.remove(0));
                }
            tableau[i].get(i).setFaceUp(true);
        }
        for (int i = 0; i < 4; i++) {
            foundation[i] = new ArrayList<>();
        }

        // Create the layout for the game
        BorderPane root = new BorderPane();

        // Create the top area for the foundation piles
        HBox foundationBox = new HBox();
        foundationBox.setAlignment(Pos.CENTER);
        foundationBox.setSpacing(CARD_SPACING);
        foundationBox.setPadding(new Insets(10, 10, 10, 10));

        for (int i = 0; i < 4; i++) {
            foundationImages[i] = new ImageView[0];
            ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("cards/back.png")));
            imageView.setFitWidth(CARD_WIDTH);
            imageView.setFitHeight(CARD_HEIGHT);

            final int foundationIndex = i;

            imageView.setOnMouseClicked(event -> {
                if (selectedTableau != -1 && tableau[selectedTableau].size() > 0) {
                    Card card = tableau[selectedTableau].get(tableau[selectedTableau].size() - 1);
                    if (foundation[foundationIndex].size() > 0) {
                        Card topCard = foundation[foundationIndex].get(foundation[foundationIndex].size() - 1);
                        if (topCard.getSuit() == card.getSuit() && topCard.getRank() == card.getRank()) {
                            foundation[foundationIndex].add(card);
                            tableau[selectedTableau].remove(tableau[selectedTableau].size() - 1);
                            updateLayout();
                        }
                    } else {
                        if (card.getRank() == null) {
                            foundation[foundationIndex].add(card);
                            tableau[selectedTableau].remove(tableau[selectedTableau].size() - 1);
                            updateLayout();
                        }
                    }
                }
            });

            foundationImages[i] = new ImageView[]{imageView};
            foundationBox.getChildren().add(imageView);
        }
        root.setTop(foundationBox);
    }

    private void updateLayout() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < tableau[i].size(); j++) {
                ImageView imageView = tableauImages[i][j];
                imageView.setImage(CardImages.getCard());
                imageView.toFront();
                imageView.setTranslateX(CARD_SPACING * j);
                imageView.setTranslateY(CARD_SPACING * j);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < foundation[i].size(); j++) {
                ImageView imageView = foundationImages[i][j];
                imageView.setImage(getCard());
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}