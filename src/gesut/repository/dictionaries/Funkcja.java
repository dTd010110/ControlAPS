package gesut.repository.dictionaries;

public enum Funkcja {
    przesylowy("g"),
    rozdzielczy("r"),
    przylacze("p"),
    inny("i");

    String literal;

    Funkcja(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
