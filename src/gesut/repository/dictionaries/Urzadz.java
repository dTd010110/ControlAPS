package gesut.repository.dictionaries;

public enum Urzadz {
    dystrybutorPaliw("d"),
    hydrant("h"),
    hydrofornia("hd"),
    kontenerTelekomunikacyjny("kt"),
    kratkaSciekowa("ks"),
    odwodnienieLiniowe("ol"),
    osatnikKanalizacjiLokalnej("sz"),
    przepompownia("p"),
    slupekTelekomunikacyjny("sl"),
    slupowaStacjaTransformatorowa("ts"),
    stacjaGazowa("gk"),
    stacjaTransformatorowa("tk"),
    studnia("st"),
    studniaGlebinowa("gs"),
    studzienka("s"),
    sygnalizatorSwietlny("ss"),
    szafaTelekomunikacyjna("tj"),
    szafaElektroenergetyczna("se"),
    szafaGazowa("sg"),
    trojnik("t"),
    wlaz("w"),
    wylotKanalu("wk"),
    wywietrznik("ww"),
    zasuwaLubZawor("zs"),
    zbiornik("zb"),
    zdrojUliczny("zu"),
    zlaczeKablowe("zk"),
    niezidentyfikowane("z"),
    zespolDystrybutorowPaliwa("zdp"),
    inne("i");

    String literal;

    Urzadz(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
