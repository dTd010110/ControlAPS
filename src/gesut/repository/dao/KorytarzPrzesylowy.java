package gesut.repository.dao;

import gesut.repository.dictionaries.RodzSieci;
import gesut.repository.generic.GM_Surface;
import gesut.repository.generic.ObiektGESUT;

import java.util.List;

public class KorytarzPrzesylowy extends ObiektGESUT {
    private GM_Surface geometria;
    private List<RodzSieci> rodzSieci;

    public KorytarzPrzesylowy(GM_Surface geometria, List<RodzSieci> rodzSieci) {
        this.geometria = geometria;
        this.rodzSieci = rodzSieci;
    }

    public GM_Surface getGeometria() {
        return geometria;
    }

    public void setGeometria(GM_Surface geometria) {
        this.geometria = geometria;
    }

    public List<RodzSieci> getRodzSieci() {
        return rodzSieci;
    }

    public void setRodzSieci(List<RodzSieci> rodzSieci) {
        this.rodzSieci = rodzSieci;
    }
}
