package gesut.repository.dictionaries;

public enum Eksploatacja {
    czynny("c"),
    nieczynny("n");

    String literal;

    Eksploatacja(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
