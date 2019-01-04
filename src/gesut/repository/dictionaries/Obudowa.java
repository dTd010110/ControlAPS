package gesut.repository.dictionaries;

public enum Obudowa {
    kanalizacjaKablowa("k"),
    kanalCieplowniczy("c"),
    ruraOchronna("r"),
    inna("i"),
    kanalTechnologiczny("kt"),
    rurociagTelekomunikacyjny("rt");

    String literal;

    Obudowa(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
