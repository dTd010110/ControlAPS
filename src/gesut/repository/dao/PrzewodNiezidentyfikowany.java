package gesut.repository.dao;

import gesut.repository.dictionaries.Eksploatacja;
import gesut.repository.dictionaries.Istnienie;
import gesut.repository.dictionaries.Zrodlo;
import gesut.repository.generic.CyklZyciaInfo;
import gesut.repository.generic.IdMaterialu;
import gesut.repository.generic.Identyfikator;
import gesut.repository.generic.Przewod;

import java.time.LocalDate;

public class PrzewodNiezidentyfikowany extends Przewod {
    private Integer srednica;

    public PrzewodNiezidentyfikowany() {
    }

    public PrzewodNiezidentyfikowany(Identyfikator idIIP, LocalDate startObiekt, CyklZyciaInfo cyklZyciaObiektu, LocalDate koniecObiekt, Zrodlo zrodlo, Istnienie istnienie, Eksploatacja eksploatacja, IdMaterialu idMaterialu, LocalDate dataPomiaru, DaneOsoby przedstawiciel, DaneOsoby wladajacy, String idBranzowy, String idUzgodnienia, String dokument, String informacja) {
        super(idIIP, startObiekt, cyklZyciaObiektu, koniecObiekt, zrodlo, istnienie, eksploatacja, idMaterialu, dataPomiaru, przedstawiciel, wladajacy, idBranzowy, idUzgodnienia, dokument, informacja);
    }

    public Integer getSrednica() {
        return srednica;
    }

    public void setSrednica(Integer srednica) {
        this.srednica = srednica;
    }
}
