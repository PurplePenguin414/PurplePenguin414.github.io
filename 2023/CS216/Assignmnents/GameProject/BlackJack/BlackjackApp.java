package BlackJack;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import BlackJack.Card.Rank;
import BlackJack.Card.Suit;

/**
 * Game's logic and UI
 *
 */
public class BlackjackApp extends Application {

    public int user = 0;
    public int comp = 0;
    public int numdecks = 1;

    private Deck deck = new Deck();
    private Hand dealer, player;
    private Text message = new Text();
    private Text money = new Text();
    private Text decks = new Text();

    private SimpleBooleanProperty playable = new SimpleBooleanProperty(false);

    private HBox dealerCards = new HBox(20);
    private HBox playerCards = new HBox(20);

    private Parent createContent() {

        dealer = new Hand(dealerCards.getChildren());
        player = new Hand(playerCards.getChildren());

        Pane root = new Pane();
        root.setPrefSize(800, 600);

        Region background = new Region();
        background.setPrefSize(800, 600);
        background.setStyle("-fx-background-color: rgba(0, 0, 0, 1)");

        HBox rootLayout = new HBox(5);
        rootLayout.setPadding(new Insets(5, 5, 5, 5));
        Rectangle leftBG = new Rectangle(550, 560);
        leftBG.setArcWidth(50);
        leftBG.setArcHeight(50);
        leftBG.setFill(Color.GREEN);
        Rectangle rightBG = new Rectangle(230, 560);
        rightBG.setArcWidth(50);
        rightBG.setArcHeight(50);
        rightBG.setFill(Color.ORANGE);

        // LEFT
        VBox leftVBox = new VBox(50);
        leftVBox.setAlignment(Pos.TOP_CENTER);

        Text dealerScore = new Text("Dealer: ");
        Text playerScore = new Text("Player: ");

        leftVBox.getChildren().addAll(dealerScore, dealerCards, message, playerCards, playerScore);

        // RIGHT

        VBox rightVBox = new VBox(20);
        rightVBox.setAlignment(Pos.CENTER);
        money.setText("Score: " + user + " Wins & " + comp + " Losses");

        decks.setText("Decks being used: " + numdecks);

        Button btnPlay = new Button("PLAY");
        Button btnHit = new Button("HIT");
        Button btnStand = new Button("STAND");
        
        Button btn1d = new Button("1 Deck");
        Button btn2d = new Button("2 Decks");
        Button btn3d = new Button("3 Decks");
        
        HBox buttonsDBox = new HBox(15, btn1d, btn2d, btn3d);
        buttonsDBox.setAlignment(Pos.CENTER);

        HBox buttonsHBox = new HBox(15, btnHit, btnStand);
        buttonsHBox.setAlignment(Pos.CENTER);

        rightVBox.getChildren().addAll(buttonsDBox, decks, btnPlay, money, buttonsHBox);

        // ADD BOTH STACKS TO ROOT LAYOUT

        rootLayout.getChildren().addAll(new StackPane(leftBG, leftVBox), new StackPane(rightBG, rightVBox));
        root.getChildren().addAll(background, rootLayout);

        // BIND PROPERTIES

        btnPlay.disableProperty().bind(playable);
        btnHit.disableProperty().bind(playable.not());
        btnStand.disableProperty().bind(playable.not());

        playerScore.textProperty().bind(new SimpleStringProperty("Player: ").concat(player.valueProperty().asString()));
        dealerScore.textProperty().bind(new SimpleStringProperty("Dealer: ").concat(dealer.valueProperty().asString()));

        player.valueProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() >= 21) {
                endGame();
            }
        });

        dealer.valueProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() >= 21) {
                endGame();
            }
        });

        // INIT BUTTONS

        btn1d.setOnAction(event -> {
            numdecks = 1;
        });
        
        btn2d.setOnAction(event -> {
            numdecks = 2;
        });
        
        btn3d.setOnAction(event -> {
            numdecks = 3;
        });

        btnPlay.setOnAction(event -> {
            startNewGame();
        });

        btnHit.setOnAction(event -> {
            player.takeCard(deck.drawCard());
        });

        btnStand.setOnAction(event -> {
            while (dealer.valueProperty().get() < 17) {
                dealer.takeCard(deck.drawCard());
            }

            endGame();
        });

        return root;
    }

    private void startNewGame() {
        playable.set(true);
        message.setText("");
        decks.setText("Decks being used: " + numdecks);
        
        deck.refill();
        deck.refill(numdecks);

        dealer.reset();
        player.reset();

        dealer.takeCard(deck.drawCard());
        dealer.takeCard(deck.drawCard());
        player.takeCard(deck.drawCard());
        player.takeCard(deck.drawCard());
    }

    private void endGame() {
        playable.set(false);

        int dealerValue = dealer.valueProperty().get();
        int playerValue = player.valueProperty().get();
        String winner = "Exceptional case: d: " + dealerValue + " p: " + playerValue;

        // the order of checking is important
        if (dealerValue == 21 || playerValue > 21 || dealerValue == playerValue
                || (dealerValue < 21 && dealerValue > playerValue)) {
            winner = "DEALER";
            comp++;
        }
        else if (playerValue == 21 || dealerValue > 21 || playerValue > dealerValue) {
            winner = "PLAYER";
            user++;
        }

        message.setText(winner + " WON");
        money.setText("Score: " + user + " Wins & " + comp + " Losses");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.setTitle("BlackJack");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}