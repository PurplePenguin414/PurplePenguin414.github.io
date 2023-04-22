package BlackJack;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;

/**
 * Game card
 *
 * Can be one of the 4 suits with value
 * ranging from 'Ace' to '2'
 *
 */

public class Card extends Parent {

    private static final int CARD_WIDTH = 100;
    private static final int CARD_HEIGHT = 140;

    enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES;

        final Image image;

        Suit() {
            this.image = new Image(Card.class.getResourceAsStream("cardIMGS/".concat(name().toLowerCase()).concat(".png")),
                    32, 32, true, true);
        }
    }

    enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(10), QUEEN(10), KING(10), ACE(11);

        final int value;
        Rank(int value) {
            this.value = value;
        }

        String displayName() {
            return ordinal() < 9 ? String.valueOf(value) : name().substring(0, 1);
        }
    }

    @Override
    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }
}