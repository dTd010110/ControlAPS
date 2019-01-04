package gesut.repository.dictionaries;

public enum TypElektr {
    najwyzszegoNapiecia("WW"),
    wysokiegoNapiecia("W"),
    sredniegoNapiecia("S"),
    niskiegoNapiecia("N");

    String literal;

    TypElektr(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
