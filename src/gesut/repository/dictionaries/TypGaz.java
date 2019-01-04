package gesut.repository.dictionaries;

public enum TypGaz {
    wysokiegoCisnienia("w"),
    podwyzszonegoSredniegoCisnienia("p"),
    SredniegoCisnienia("s"),
    niskiegoCisinienia("n");

    String literal;

    TypGaz(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
