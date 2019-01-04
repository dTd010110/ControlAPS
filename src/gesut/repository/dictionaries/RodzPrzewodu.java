package gesut.repository.dictionaries;

public enum RodzPrzewodu {
    rurowy("r"),
    kabel("k"),
    swiatlowod("s"),
    inny("i");

    String literal;

    RodzPrzewodu(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
