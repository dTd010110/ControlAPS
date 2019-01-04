package gesut.repository.dictionaries;

public enum RodzSieci {
    benzynowy("b"),
    cieplowniczy("c"),
    elektroenergetyczny("e"),
    gazowy("g"),
    kanalizacyjny("k"),
    naftowy("n"),
    telekomunikacyjny("t"),
    wodociagowy("w"),
    niezidentyfikowany("z"),
    inna("i");

    String literal;

    RodzSieci(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
