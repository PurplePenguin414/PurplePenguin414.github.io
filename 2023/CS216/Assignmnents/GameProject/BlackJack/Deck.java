package BlackJack;

import BlackJack.Card.Rank;
import BlackJack.Card.Suit;

/**
 * Standard 52 card deck
 * added for each deck specified
 */
public class Deck {

    private Card[] cards = new Card[52];

    public Deck() {
        refill();
    }

    public final void refill() {
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards[i++] = new Card(suit, rank);
            }
        }
    }
    
    public final void refill(int d) {
        int i = 0;
        while(d!=1){
           for (Suit suit : Suit.values()) {
               for (Rank rank : Rank.values()) {
                   cards[i++] = new Card(suit, rank);
               }
           }
           d--;
        }
    }

    public Card drawCard() {
        Card card = null;
        while (card == null) {
            int index = (int)(Math.random()*cards.length);
            card = cards[index];
            cards[index] = null;
        }
        return card;
    }
}