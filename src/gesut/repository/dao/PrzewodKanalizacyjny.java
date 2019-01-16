package gesut.repository.dao;

import gesut.repository.dictionaries.*;
import gesut.repository.generic.CyklZyciaInfo;
import gesut.repository.generic.IdMaterialu;
import gesut.repository.generic.Identyfikator;
import gesut.repository.generic.Przewod;

import java.time.LocalDate;

public class PrzewodKanalizacyjny extends Przewod {
    private Integer srednica;
    private TypKanal typKanal;
    private int wymiarPionowy;
    private int wymiarPoziomy;
    private boolean tloczny;

    public PrzewodKanalizacyjny() {
    }

    public PrzewodKanalizacyjny(Identyfikator idIIP, LocalDate startObiekt, CyklZyciaInfo cyklZyciaObiektu, LocalDate koniecObiekt, Zrodlo zrodlo, Istnienie istnienie, Eksploatacja eksploatacja, IdMaterialu idMaterialu, LocalDate dataPomiaru, DaneOsoby przedstawiciel, DaneOsoby wladajacy, String idBranzowy, String idUzgodnienia, String dokument, String informacja) {
        super(idIIP, startObiekt, cyklZyciaObiektu, koniecObiekt, zrodlo, istnienie, eksploatacja, idMaterialu, dataPomiaru, przedstawiciel, wladajacy, idBranzowy, idUzgodnienia, dokument, informacja);
    }

    public Integer getSrednica() {
        return srednica;
    }

    public void setSrednica(Integer srednica) {
        this.srednica = srednica;
    }

    public TypKanal getTypKanal() {
        return typKanal;
    }

    public void setTypKanal(TypKanal typKanal) {
        this.typKanal = typKanal;
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

    public boolean isTloczny() {
        return tloczny;
    }

    public void setTloczny(boolean tloczny) {
        this.tloczny = tloczny;
    }
}
