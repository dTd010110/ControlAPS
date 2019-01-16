package gesut.repository.dao;

import gesut.repository.dictionaries.*;
import gesut.repository.generic.*;

import java.time.LocalDate;

public class ObudowaPrzewodu extends ObiektGESUT {
   private GM_Curve geometria;
   private Obudowa obudowa;
   private RodzSieci rodzSieci;
   private int srednica;
   private int wymiarPionowy;
   private int wymiarPoziomy;
   private int liczbaRur;

    public ObudowaPrzewodu() {
    }

    public ObudowaPrzewodu(Identyfikator idIIP, LocalDate startObiekt, CyklZyciaInfo cyklZyciaObiektu, LocalDate koniecObiekt, Zrodlo zrodlo, Istnienie istnienie, Eksploatacja eksploatacja, IdMaterialu idMaterialu, LocalDate dataPomiaru, DaneOsoby przedstawiciel, DaneOsoby wladajacy, String idBranzowy, String idUzgodnienia, String dokument, String informacja) {
        super(idIIP, startObiekt, cyklZyciaObiektu, koniecObiekt, zrodlo, istnienie, eksploatacja, idMaterialu, dataPomiaru, przedstawiciel, wladajacy, idBranzowy, idUzgodnienia, dokument, informacja);
    }

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
