package gesut.repository.dao;

import gesut.repository.dictionaries.*;
import gesut.repository.generic.*;

import java.time.LocalDate;

public class SlupIMaszt extends ObiektGESUT {
   private GM_Primitive geometria;
   private RodzSieci rodzSieci;
   private RodzSlup rodzSlup;
   private boolean zLatarnia;

    public SlupIMaszt() {
    }

    public SlupIMaszt(Identyfikator idIIP, LocalDate startObiekt, CyklZyciaInfo cyklZyciaObiektu, LocalDate koniecObiekt, Zrodlo zrodlo, Istnienie istnienie, Eksploatacja eksploatacja, IdMaterialu idMaterialu, LocalDate dataPomiaru, DaneOsoby przedstawiciel, DaneOsoby wladajacy, String idBranzowy, String idUzgodnienia, String dokument, String informacja) {
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
