package gesut.repository.dictionaries;

public enum RodzajDokumentu {
    umowaAktNotarialny (1),
    aktWlasnosciZiemi (2),
    decyzjaAdminInnaNizAWZ (3),
    orzeczenieSaduPostanowienieWyrok (4),
    wyciagOdpisZKsiegiWieczystej (5),
    wyciagOdpisZKsiegiHipotecznej (6),
    odpisAktKWLubZbioruDokumentu (7),
    zawiadomienieZWydzialuKW (8),
    wniosekWSprawieZmiany (9),
    wyciagZDokumentacjiBudowyBudynku (10),
    protokol (11),
    ustawa (12),
    rozporzadzenie (13),
    uchwala (14),
    zarzadzenie (15),
    odpisWyciagZInnegoRejestruPublicznego (16),
    pelnomocnictwo (17),
    wyciagZOperatuSzacunkowego (18),
    innyDokument (19),
    dokArchitektoniczoBud (20),
    dokPlanistyczny (21),
    protokolNaradyKoordynacyjnej (22),
    umowaDzierzawy (23);

    int id;

    RodzajDokumentu(int literal) {
        this.id = literal;
    }

    public int getId() {
        return id;
    }
}
