package gesut.repository.dictionaries;

public enum OznaczenieZasobu {
    centralny('C'),
    wojewodzki('W'),
    powiatowy('P');

    Character oznaczenie;

    OznaczenieZasobu(Character c) {
        oznaczenie = c;
    }
}
