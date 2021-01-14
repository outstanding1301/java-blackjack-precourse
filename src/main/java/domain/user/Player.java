package domain.user;

import domain.card.Card;
import domain.card.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private final String name;
    private final double bettingMoney;
    private final List<Card> cards = new ArrayList<>();

    private State state = State.HIT;

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        int sum = cards.stream().map(c -> c.getSymbol().getScore()).reduce(0, Integer::sum);
        int aceCount = (int) cards.stream().filter(c -> c.getSymbol() == Symbol.ACE).count();

        while (aceCount > 0 && sum + 10 <= 21) {
            sum += 10;
            aceCount--;
        }

        return sum;
    }

    public void hit() {
        this.state = State.HIT;
    }

    public void stand() {
        this.state = State.STAND;
    }

    public State getState() {
        return state;
    }

    public void checkScore() {
        if (getScore() == 21) {
            printHand();
            System.out.println("BLACKJACK!!");
            stand();
            return;
        }
        if (getScore() > 21) {
            printHand();
            System.out.println("BURST!!");
            stand();
        }
    }

    public void printHand() {
        String hand = cards.stream().map(c -> c.getCardString()).collect(Collectors.joining(" | "));
        System.out.println(name+"님의 손패(합:"+getScore()+") : "+hand);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", bettingMoney=" + bettingMoney +
                ", cards=" + cards +
                '}';
    }
}
