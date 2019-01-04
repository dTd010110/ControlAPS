package gesut.repository.dictionaries;

public enum TypKanal {
    deszczowy("d"),
    lokalny("l"),
    ogolnosplawny("o"),
    przemyslowy("p"),
    sanitarny("s");

    String literal;

    TypKanal(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
