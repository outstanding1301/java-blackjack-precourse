package domain.card;

import java.util.List;

public class Deck {
    private List<Card> cards;
    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public Card popCard() {
        return cards.remove(0);
    }
}
