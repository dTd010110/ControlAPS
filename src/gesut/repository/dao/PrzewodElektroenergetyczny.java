package gesut.repository.dao;

import gesut.repository.dictionaries.*;
import gesut.repository.generic.CyklZyciaInfo;
import gesut.repository.generic.IdMaterialu;
import gesut.repository.generic.Identyfikator;
import gesut.repository.generic.Przewod;

import java.time.LocalDate;

public class PrzewodElektroenergetyczny extends Przewod {
    private boolean wiazka;
    private TypElektr typElektr;
    private boolean oswietleniowy;
    private int liczbaPrzewodow;

    public PrzewodElektroenergetyczny() {
    }

    public PrzewodElektroenergetyczny(Identyfikator idIIP, LocalDate startObiekt, CyklZyciaInfo cyklZyciaObiektu, LocalDate koniecObiekt, Zrodlo zrodlo, Istnienie istnienie, Eksploatacja eksploatacja, IdMaterialu idMaterialu, LocalDate dataPomiaru, DaneOsoby przedstawiciel, DaneOsoby wladajacy, String idBranzowy, String idUzgodnienia, String dokument, String informacja) {
        super(idIIP, startObiekt, cyklZyciaObiektu, koniecObiekt, zrodlo, istnienie, eksploatacja, idMaterialu, dataPomiaru, przedstawiciel, wladajacy, idBranzowy, idUzgodnienia, dokument, informacja);
    }

    public boolean isWiazka() {
        return wiazka;
    }

    public void setWiazka(boolean wiazka) {
        this.wiazka = wiazka;
    }

    public TypElektr getTypElektr() {
        return typElektr;
    }

    public void setTypElektr(TypElektr typElektr) {
        this.typElektr = typElektr;
    }

    public boolean isOswietleniowy() {
        return oswietleniowy;
    }

    public void setOswietleniowy(boolean oswietleniowy) {
        this.oswietleniowy = oswietleniowy;
    }

    public int getLiczbaPrzewodow() {
        return liczbaPrzewodow;
    }

    public void setLiczbaPrzewodow(int liczbaPrzewodow) {
        this.liczbaPrzewodow = liczbaPrzewodow;
    }
}
