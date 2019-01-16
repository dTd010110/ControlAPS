package gesut.repository.dao;

import gesut.repository.dictionaries.*;
import gesut.repository.generic.CyklZyciaInfo;
import gesut.repository.generic.IdMaterialu;
import gesut.repository.generic.Identyfikator;
import gesut.repository.generic.Przewod;

import java.time.LocalDate;

public class PrzewodCieplowniczy extends Przewod {
    private Integer srednica;
    private TypCiep typCiep;
    private RodzCiep rodzCiep;

    public PrzewodCieplowniczy() {
    }

    public PrzewodCieplowniczy(Identyfikator idIIP, LocalDate startObiekt, CyklZyciaInfo cyklZyciaObiektu, LocalDate koniecObiekt, Zrodlo zrodlo, Istnienie istnienie, Eksploatacja eksploatacja, IdMaterialu idMaterialu, LocalDate dataPomiaru, DaneOsoby przedstawiciel, DaneOsoby wladajacy, String idBranzowy, String idUzgodnienia, String dokument, String informacja) {
        super(idIIP, startObiekt, cyklZyciaObiektu, koniecObiekt, zrodlo, istnienie, eksploatacja, idMaterialu, dataPomiaru, przedstawiciel, wladajacy, idBranzowy, idUzgodnienia, dokument, informacja);
    }

    public Integer getSrednica() {
        return srednica;
    }

    public void setSrednica(Integer srednica) {
        this.srednica = srednica;
    }

    public TypCiep getTypCiep() {
        return typCiep;
    }

    public void setTypCiep(TypCiep typCiep) {
        this.typCiep = typCiep;
    }

    public RodzCiep getRodzCiep() {
        return rodzCiep;
    }

    public void setRodzCiep(RodzCiep rodzCiep) {
        this.rodzCiep = rodzCiep;
    }
}
