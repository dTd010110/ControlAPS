package gesut.repository.dao;

import gesut.repository.dictionaries.Obudowa;
import gesut.repository.dictionaries.RodzBud;
import gesut.repository.dictionaries.RodzSieci;
import gesut.repository.generic.GM_Curve;
import gesut.repository.generic.GM_Surface;
import gesut.repository.generic.ObiektGESUT;

public class ObudowaPrzewodu extends ObiektGESUT {
   private GM_Curve geometria;
   private Obudowa obudowa;
   private RodzSieci rodzSieci;
   private int srednica;
   private int wymiarPionowy;
   private int wymiarPoziomy;
   private int liczbaRur;

    public GM_Curve getGeometria() {
        return geometria;
    }

    public void setGeometria(GM_Curve geometria) {
        this.geometria = geometria;
    }

    public Obudowa getObudowa() {
        return obudowa;
    }

    public void setObudowa(Obudowa obudowa) {
        this.obudowa = obudowa;
    }

    public RodzSieci getRodzSieci() {
        return rodzSieci;
    }

    public void setRodzSieci(RodzSieci rodzSieci) {
        this.rodzSieci = rodzSieci;
    }

    public int getSrednica() {
        return srednica;
    }

    public void setSrednica(int srednica) {
        this.srednica = srednica;
    }

    public int getWymiarPionowy() {
        return wymiarPionowy;
    }

    public void setWymiarPionowy(int wymiarPionowy) {
        this.wymiarPionowy = wymiarPionowy;
    }

    public int getWymiarPoziomy() {
        return wymiarPoziomy;
    }

    public void setWymiarPoziomy(int wymiarPoziomy) {
        this.wymiarPoziomy = wymiarPoziomy;
    }

    public int getLiczbaRur() {
        return liczbaRur;
    }

    public void setLiczbaRur(int liczbaRur) {
        this.liczbaRur = liczbaRur;
    }
}
