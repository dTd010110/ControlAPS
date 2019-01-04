package gesut.repository.dao;

import gesut.repository.dictionaries.Obudowa;
import gesut.repository.dictionaries.RodzSieci;
import gesut.repository.dictionaries.RodzSlup;
import gesut.repository.generic.GM_Curve;
import gesut.repository.generic.GM_Primitive;
import gesut.repository.generic.ObiektGESUT;

public class SlupMaszt extends ObiektGESUT {
   private GM_Primitive geometria;
   private RodzSieci rodzSieci;
   private RodzSlup rodzSlup;
   private boolean zLatarnia;

    public GM_Primitive getGeometria() {
        return geometria;
    }

    public void setGeometria(GM_Primitive geometria) {
        this.geometria = geometria;
    }

    public RodzSieci getRodzSieci() {
        return rodzSieci;
    }

    public void setRodzSieci(RodzSieci rodzSieci) {
        this.rodzSieci = rodzSieci;
    }

    public RodzSlup getRodzSlup() {
        return rodzSlup;
    }

    public void setRodzSlup(RodzSlup rodzSlup) {
        this.rodzSlup = rodzSlup;
    }

    public boolean iszLatarnia() {
        return zLatarnia;
    }

    public void setzLatarnia(boolean zLatarnia) {
        this.zLatarnia = zLatarnia;
    }
}
