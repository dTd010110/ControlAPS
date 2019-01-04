package gesut.repository.dictionaries;

public enum TypWodoc {
    ogolny("o"),
    lokalny("l");

    String literal;

    TypWodoc(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
