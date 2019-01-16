package gesut.repository.dao;

import gesut.repository.dictionaries.Eksploatacja;
import gesut.repository.dictionaries.Istnienie;
import gesut.repository.dictionaries.Zrodlo;
import gesut.repository.generic.CyklZyciaInfo;
import gesut.repository.generic.IdMaterialu;
import gesut.repository.generic.Identyfikator;
import gesut.repository.generic.Przewod;

import java.time.LocalDate;

public class PrzewodTelekomunikacyjny extends Przewod {
    private boolean wiazka;
    private int liczbaPrzewodow;

    public PrzewodTelekomunikacyjny() {
    }

    public PrzewodTelekomunikacyjny(Identyfikator idIIP, LocalDate startObiekt, CyklZyciaInfo cyklZyciaObiektu, LocalDate koniecObiekt, Zrodlo zrodlo, Istnienie istnienie, Eksploatacja eksploatacja, IdMaterialu idMaterialu, LocalDate dataPomiaru, DaneOsoby przedstawiciel, DaneOsoby wladajacy, String idBranzowy, String idUzgodnienia, String dokument, String informacja) {
        super(idIIP, startObiekt, cyklZyciaObiektu, koniecObiekt, zrodlo, istnienie, eksploatacja, idMaterialu, dataPomiaru, przedstawiciel, wladajacy, idBranzowy, idUzgodnienia, dokument, informacja);
    }

    public boolean isWiazka() {
        return wiazka;
    }

    public void setWiazka(boolean wiazka) {
        this.wiazka = wiazka;
    }

    public int getLiczbaPrzewodow() {
        return liczbaPrzewodow;
    }

    public void setLiczbaPrzewodow(int liczbaPrzewodow) {
        this.liczbaPrzewodow = liczbaPrzewodow;
    }
}
