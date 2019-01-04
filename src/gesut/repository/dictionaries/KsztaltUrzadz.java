package gesut.repository.dictionaries;

public enum KsztaltUrzadz {
    kwadratowy("k"),
    okragly("o"),
    prostokatny("p"),
    owalny("o"),
    inny("i");

    String literal;

    KsztaltUrzadz(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
