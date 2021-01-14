package domain;

import domain.card.*;
import domain.controller.GameController;
import domain.controller.InputManager;
import domain.controller.InputManagerImpl;
import domain.repository.PlayerRepository;
import domain.repository.PlayerRepositoryImpl;
import domain.user.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackjackTest {
    PlayerRepository repository;
    List<Card> cards;
    GameController controller;

    @BeforeEach
    void init() {
        repository = new PlayerRepositoryImpl();
        repository.addPlayer(new Player("Ingeol", 100));
//        repository.addPlayer(new Player("Cat", 10000));
//        repository.addPlayer(new Player("Dog", 100));
//        repository.addPlayer(new Player("Pizza", 50));

        cards = CardFactory.create();

        controller = new GameController(repository.getPlayers(), new InputManager() {
            @Override
            public boolean choiceState(Player player) {
                player.printHand();
                player.hit();
                return true;
            }
        });
        controller.init();
        controller.printStatus();
    }

    @Test
    void shuffleTest() {
        List<Card> shuffled = CardFactory.getShuffled();
        System.out.println(shuffled);
    }

    @Test
    void deckTest() {
        Deck deck = new Deck(CardFactory.getShuffled());
        assertEquals(deck.size(), 52);
        System.out.println(deck.popCard());
        assertEquals(deck.size(), 51);
    }

    @Test
    void aceTest() {
        Player p = new Player("test", 100);
        p.addCard(new Card(Symbol.ACE, Type.SPADE));
        p.addCard(new Card(Symbol.NINE, Type.HEART));
        p.addCard(new Card(Symbol.ACE, Type.DIAMOND));
        assertEquals(p.getScore(), 21);
    }

    @Test
    void choiceTest() {
        controller.turn();
        controller.turn();
        controller.turn();
        controller.turn();
        controller.turn();
    }
}
