package gesut.repository.dao;

import gesut.repository.dictionaries.*;
import gesut.repository.generic.*;

import java.time.LocalDate;

public class UrzadzenieTechniczneZwiazaneZSiecia extends ObiektGESUT {
    private GM_Primitive geometria;
    private RodzSieci rodzSieci;
    private RodzajUrzadz rodzajUrzadz;
    private KsztaltUrzadz ksztaltUrzadz;
    private Przebieg przebieg;
    private boolean zasobnik;
    private int srednica = 0;

    public UrzadzenieTechniczneZwiazaneZSiecia() {
    }

    public UrzadzenieTechniczneZwiazaneZSiecia(Identyfikator idIIP, LocalDate startObiekt, CyklZyciaInfo cyklZyciaObiektu, LocalDate koniecObiekt, Zrodlo zrodlo, Istnienie istnienie, Eksploatacja eksploatacja, IdMaterialu idMaterialu, LocalDate dataPomiaru, DaneOsoby przedstawiciel, DaneOsoby wladajacy, String idBranzowy, String idUzgodnienia, String dokument, String informacja) {
        super(idIIP, startObiekt, cyklZyciaObiektu, koniecObiekt, zrodlo, istnienie, eksploatacja, idMaterialu, dataPomiaru, przedstawiciel, wladajacy, idBranzowy, idUzgodnienia, dokument, informacja);
    }

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

    public RodzajUrzadz getRodzajUrzadz() {
        return rodzajUrzadz;
    }

    public void setRodzajUrzadz(RodzajUrzadz rodzajUrzadz) {
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
