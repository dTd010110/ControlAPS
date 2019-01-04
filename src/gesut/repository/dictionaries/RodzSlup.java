package gesut.repository.dictionaries;

public enum RodzSlup {
    latarnia("l"),
    masztOswietleniowy("o"),
    masztTelekomunikacyjny("t"),
    slup("s"),
    slupLaczony("sp"),
    slupKratowy("sk"),
    slupTrakcjiKolejowej("tk"),
    slupTrakcjiTramwajowej("tt"),
    slupTrakcjiTrolejbusowej("tb"),
    turbinaWiatrowa("tw"),
    wierzaTelekomunikacyjna("w"),
    inny("i");

    String literal;

    RodzSlup(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
