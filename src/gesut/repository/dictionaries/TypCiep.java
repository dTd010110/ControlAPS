package gesut.repository.dictionaries;

public enum TypCiep {
    wysokiParametr("w"),
    niskiParametr("n");

    String literal;

    TypCiep(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
