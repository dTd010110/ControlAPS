package gesut.repository.dao;

import gesut.repository.dictionaries.KsztaltUrzadz;
import gesut.repository.dictionaries.Przebieg;
import gesut.repository.dictionaries.RodzSieci;
import gesut.repository.dictionaries.Urzadz;
import gesut.repository.generic.GM_Primitive;
import gesut.repository.generic.ObiektGESUT;

public class UrzadzenieTechniczneZwiazaneZSiecia extends ObiektGESUT {
    private GM_Primitive geometria;
    private RodzSieci rodzSieci;
    private Urzadz rodzajUrzadz;
    private KsztaltUrzadz ksztaltUrzadz;
    private Przebieg przebieg;
    private boolean zasobnik;
    private int srednica;

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

    public Urzadz getRodzajUrzadz() {
        return rodzajUrzadz;
    }

    public void setRodzajUrzadz(Urzadz rodzajUrzadz) {
        this.rodzajUrzadz = rodzajUrzadz;
    }

    public KsztaltUrzadz getKsztaltUrzadz() {
        return ksztaltUrzadz;
    }

    public void setKsztaltUrzadz(KsztaltUrzadz ksztaltUrzadz) {
        this.ksztaltUrzadz = ksztaltUrzadz;
    }

    public Przebieg getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(Przebieg przebieg) {
        this.przebieg = przebieg;
    }

    public boolean isZasobnik() {
        return zasobnik;
    }

    public void setZasobnik(boolean zasobnik) {
        this.zasobnik = zasobnik;
    }

    public int getSrednica() {
        return srednica;
    }

    public void setSrednica(int srednica) {
        this.srednica = srednica;
    }
}
