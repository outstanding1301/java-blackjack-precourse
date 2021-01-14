package domain.card;

public enum Type {
    SPADE("♠"),
    DIAMOND("◇"),
    HEART("♡"),
    CLUB("♣");

    private String symbol;

    Type(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
