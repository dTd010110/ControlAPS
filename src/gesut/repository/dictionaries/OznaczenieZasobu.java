package gesut.repository.dictionaries;

public enum OznaczenieZasobu {

    centralny('C'),
    wojewodzki('W'),
    powiatowy('P');

    Character oznaczenie;

    OznaczenieZasobu(Character oznaczenie) {
        this.oznaczenie = oznaczenie;
    }

    public Character getOznaczenie() {
        return oznaczenie;
    }
}
