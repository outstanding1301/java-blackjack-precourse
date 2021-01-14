package domain.controller;

import domain.card.CardFactory;
import domain.card.Deck;
import domain.user.Dealer;
import domain.user.Player;
import domain.user.State;

import java.util.List;

public class GameController {
    private List<Player> players;
    private Dealer dealer;
    private Deck deck;
    private InputManager input;

    public GameController(List<Player> players, InputManager input) {
        this.players = players;
        this.dealer = new Dealer();
        this.deck = new Deck(CardFactory.getShuffled());
        this.input = input;
    }

    public void init() {
        // 카드 2장 지급
        dealer.addCard(deck.popCard());
        dealCard();
        dealCard();
    }

    // 카드 지급
    public void dealCard() {
        for (Player p : players) {
            dealCard(p);
        }
    }
    public void dealCard(Player p) {
        p.addCard(deck.popCard());
        p.checkScore();
    }

    public void turn() {
        players.stream().filter(p -> p.getState() == State.HIT).forEach(player -> {
            choice(player);
            dealCard(player);
        });
    }

    public void choice(Player player) {
        while (!input.choiceState(player));
    }

    public void printStatus() {
        System.out.println(dealer.toString());
        for(Player p : players) {
            System.out.println(p.toString()+", score : "+p.getScore());
        }
    }
}
