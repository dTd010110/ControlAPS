package gesut.repository.dictionaries;

public enum Przebieg {
    nadziemny("n"),
    naziemny("z"),
    podziemny("p");

    String literal;

    Przebieg(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
