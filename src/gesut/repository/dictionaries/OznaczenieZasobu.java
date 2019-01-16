package gesut.repository.dictionaries;

public enum OznaczenieZasobu {

    C("centralny"),
    W("wojewodzki"),
    P("powiatowy");

    String oznaczenie;

    OznaczenieZasobu(String oznaczenie) {
        this.oznaczenie = oznaczenie;
    }

    public String getOznaczenie() {
        return oznaczenie;
    }
}
