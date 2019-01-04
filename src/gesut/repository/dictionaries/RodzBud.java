package gesut.repository.dictionaries;

public enum RodzBud {
    komoraPodziemna("k"),
    osadnik("o"),
    przejsciePodziemne("pp"),
    tunelDrogowy("td"),
    tunelKolejowy("tk"),
    tunelMetra("tm"),
    tunelTramwajowy("tt"),
    inna("i");

    String literal;

    RodzBud(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
