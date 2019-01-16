package gesut.repository.dao;

import gesut.repository.dictionaries.*;
import gesut.repository.generic.*;

import java.time.LocalDate;

public class PrzewodBenzynowy extends Przewod {
    private Integer srednica;

    public PrzewodBenzynowy() {
    }

    public PrzewodBenzynowy(Integer srednica) {
        this.srednica = srednica;
    }

    public PrzewodBenzynowy(Identyfikator idIIP, LocalDate startObiekt, CyklZyciaInfo cyklZyciaObiektu, LocalDate koniecObiekt, Zrodlo zrodlo, Istnienie istnienie, Eksploatacja eksploatacja, IdMaterialu idMaterialu, LocalDate dataPomiaru, DaneOsoby przedstawiciel, DaneOsoby wladajacy, String idBranzowy, String idUzgodnienia, String dokument, String informacja) {
        super(idIIP, startObiekt, cyklZyciaObiektu, koniecObiekt, zrodlo, istnienie, eksploatacja, idMaterialu, dataPomiaru, przedstawiciel, wladajacy, idBranzowy, idUzgodnienia, dokument, informacja);
    }

    public PrzewodBenzynowy(Identyfikator idIIP, LocalDate startObiekt, CyklZyciaInfo cyklZyciaObiektu, LocalDate koniecObiekt, Zrodlo zrodlo, Istnienie istnienie, Eksploatacja eksploatacja, IdMaterialu idMaterialu, LocalDate dataPomiaru, DaneOsoby przedstawiciel, DaneOsoby wladajacy, String idBranzowy, String idUzgodnienia, String dokument, String informacja, GM_Curve geometria, Funkcja funkcja, Przebieg przebieg, RodzPrzewodu rodzPrzewodu) {
        super(idIIP, startObiekt, cyklZyciaObiektu, koniecObiekt, zrodlo, istnienie, eksploatacja, idMaterialu, dataPomiaru, przedstawiciel, wladajacy, idBranzowy, idUzgodnienia, dokument, informacja, geometria, funkcja, przebieg, rodzPrzewodu);
    }

    public Integer getSrednica() {
        return srednica;
    }

    public void setSrednica(Integer srednica) {
        this.srednica = srednica;
    }
}
