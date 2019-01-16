package gesut.repository.dictionaries;

public enum TypGaz {
    wysokiegoCisnienia("w"),
    podwyzszonegoSredniegoCisnienia("p"),
    sredniegoCisnienia("s"),
    niskiegoCisnienia("n");

    String literal;

    TypGaz(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
