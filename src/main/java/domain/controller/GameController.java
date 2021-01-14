package domain.controller;

import domain.card.Card;
import domain.card.CardFactory;
import domain.card.Deck;
import domain.user.Dealer;
import domain.user.Player;

import java.util.List;

public class GameController {
    private List<Player> players;
    private Dealer dealer;
    private Deck deck;

    public GameController(List<Player> players) {
        this.players = players;
        this.dealer = new Dealer();
        this.deck = new Deck(CardFactory.getShuffled());
    }

    public void init() {
        dealCard();
    }

    // 카드 2장씩 지급
    public void dealCard() {
        dealer.addCard(deck.popCard());
        dealer.addCard(deck.popCard());
        for (Player p : players) {
            p.addCard(deck.popCard());
            p.addCard(deck.popCard());
        }
    }

    public void printStatus() {
        System.out.println(dealer.toString());
        for(Player p : players) {
            System.out.println(p.toString()+", score : "+p.getScore());
        }
    }
}
