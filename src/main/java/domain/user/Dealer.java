package domain.user;

import domain.card.Card;
import domain.card.Symbol;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {
    private final List<Card> cards = new ArrayList<>();

    private State state = State.HIT;

    public Dealer() {}

    public void addCard(Card card) {
        cards.add(card);
    }

    // TODO 추가 기능 구현
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

    @Override
    public String toString() {
        return "Dealer{" +
                "cards=" + cards +
                '}';
    }
}
