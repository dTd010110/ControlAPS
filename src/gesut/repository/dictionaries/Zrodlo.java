package gesut.repository.dictionaries;

public enum Zrodlo {
    pomiarNaOsnowe("O"),
    pomiarWykrywaczemPrzewodow("A"),
    digitalizacjaWektoryzacja("D"),
    fotogrametria("F"),
    pomiarWOparciuOElementyMapy("M"),
    daneBranzowe("B"),
    inne("I"),
    nieokreslone("X"),
    niepoprawne("N"),
    dokumentacjaZNarady("K"),
    pozwolenieNaBudowe("P"),
    zgloszenieBudowy("Z"),
    dokumentacjaZWytyczenia("T");

    String literal;

    Zrodlo(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
