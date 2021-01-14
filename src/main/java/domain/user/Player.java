package domain.user;

import domain.card.Card;
import domain.card.Symbol;

import java.util.ArrayList;
import java.util.List;

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

    // TODO 추가 기능 구현

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", bettingMoney=" + bettingMoney +
                ", cards=" + cards +
                '}';
    }
}
