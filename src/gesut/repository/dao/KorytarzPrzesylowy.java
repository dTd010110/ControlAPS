package gesut.repository.dao;

import gesut.repository.dictionaries.Eksploatacja;
import gesut.repository.dictionaries.Istnienie;
import gesut.repository.dictionaries.RodzSieci;
import gesut.repository.dictionaries.Zrodlo;
import gesut.repository.generic.*;

import java.time.LocalDate;
import java.util.List;

public class KorytarzPrzesylowy extends ObiektGESUT {
    private GM_Surface geometria;
    private List<RodzSieci> rodzSieci;

    public KorytarzPrzesylowy() {
    }

    public KorytarzPrzesylowy(Identyfikator idIIP, LocalDate startObiekt, CyklZyciaInfo cyklZyciaObiektu, LocalDate koniecObiekt, Zrodlo zrodlo, Istnienie istnienie, Eksploatacja eksploatacja, IdMaterialu idMaterialu, LocalDate dataPomiaru, DaneOsoby przedstawiciel, DaneOsoby wladajacy, String idBranzowy, String idUzgodnienia, String dokument, String informacja) {
        super(idIIP, startObiekt, cyklZyciaObiektu, koniecObiekt, zrodlo, istnienie, eksploatacja, idMaterialu, dataPomiaru, przedstawiciel, wladajacy, idBranzowy, idUzgodnienia, dokument, informacja);
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
