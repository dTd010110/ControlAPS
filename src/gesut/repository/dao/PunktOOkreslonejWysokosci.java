package gesut.repository.dao;

import gesut.repository.dictionaries.Eksploatacja;
import gesut.repository.dictionaries.Istnienie;
import gesut.repository.dictionaries.Zrodlo;
import gesut.repository.generic.*;

import java.time.LocalDate;

public class PunktOOkreslonejWysokosci extends ObiektGESUT {
    private GM_Point geometria;
    private double rzednaGory;
    private double rzednaDolu;

    public PunktOOkreslonejWysokosci() {
    }

    public PunktOOkreslonejWysokosci(Identyfikator idIIP, LocalDate startObiekt, CyklZyciaInfo cyklZyciaObiektu, LocalDate koniecObiekt, Zrodlo zrodlo, Istnienie istnienie, Eksploatacja eksploatacja, IdMaterialu idMaterialu, LocalDate dataPomiaru, DaneOsoby przedstawiciel, DaneOsoby wladajacy, String idBranzowy, String idUzgodnienia, String dokument, String informacja) {
        super(idIIP, startObiekt, cyklZyciaObiektu, koniecObiekt, zrodlo, istnienie, eksploatacja, idMaterialu, dataPomiaru, przedstawiciel, wladajacy, idBranzowy, idUzgodnienia, dokument, informacja);
    }

    public GM_Point getGeometria() {
        return geometria;
    }

    public void setGeometria(GM_Point geometria) {
        this.geometria = geometria;
    }

    public double getRzednaGory() {
        return rzednaGory;
    }

    public void setRzednaGory(double rzednaGory) {
        this.rzednaGory = rzednaGory;
    }

    public double getRzednaDolu() {
        return rzednaDolu;
    }

    public void setRzednaDolu(double rzednaDolu) {
        this.rzednaDolu = rzednaDolu;
    }
}
