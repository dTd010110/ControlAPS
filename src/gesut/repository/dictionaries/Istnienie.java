package gesut.repository.dictionaries;

public enum Istnienie {
    istniejacy("i"),
    projektowany("p"),
    wBudowie("b");

    String literal;

    Istnienie(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
