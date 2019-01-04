package gesut.repository.dictionaries;

public enum OznaczenieZasobu {

    centralny("C"),
    wojewodzki("W"),
    powiatowy("P");

    String oznaczenie;

    OznaczenieZasobu(String oznaczenie) {
        this.oznaczenie = oznaczenie;
    }

    public String getOznaczenie() {
        return oznaczenie;
    }
}
