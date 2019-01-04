package gesut.repository.dictionaries;

public enum RodzCiep {
    jednoprzewodowy("j"),
    dwuprzewodowy("d"),
    trojprzewodowy("t"),
    czteroprzewodowy("c"),
    wieloprzewodowy("w");

    String literal;

    RodzCiep(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
