package gesut.repository.generic;

import gesut.repository.dao.DaneOsoby;
import gesut.repository.dictionaries.*;

import java.time.LocalDate;

public class Przewod extends ObiektGESUT{
    private GM_Curve geometria;
    private Funkcja funkcja;
    private Przebieg przebieg;
    private RodzPrzewodu rodzPrzewodu;

    public Przewod() {
    }

    public Przewod(GM_Curve geometria, Funkcja funkcja, Przebieg przebieg, RodzPrzewodu rodzPrzewodu) {
        this.geometria = geometria;
        this.funkcja = funkcja;
        this.przebieg = przebieg;
        this.rodzPrzewodu = rodzPrzewodu;
    }

    public Przewod(Identyfikator idIIP, LocalDate startObiekt, CyklZyciaInfo cyklZyciaObiektu, LocalDate koniecObiekt, Zrodlo zrodlo, Istnienie istnienie, Eksploatacja eksploatacja, IdMaterialu idMaterialu, LocalDate dataPomiaru, DaneOsoby przedstawiciel, DaneOsoby wladajacy, String idBranzowy, String idUzgodnienia, String dokument, String informacja) {
        super(idIIP, startObiekt, cyklZyciaObiektu, koniecObiekt, zrodlo, istnienie, eksploatacja, idMaterialu, dataPomiaru, przedstawiciel, wladajacy, idBranzowy, idUzgodnienia, dokument, informacja);
    }

    public Przewod(Identyfikator idIIP, LocalDate startObiekt, CyklZyciaInfo cyklZyciaObiektu, LocalDate koniecObiekt, Zrodlo zrodlo, Istnienie istnienie, Eksploatacja eksploatacja, IdMaterialu idMaterialu, LocalDate dataPomiaru, DaneOsoby przedstawiciel, DaneOsoby wladajacy, String idBranzowy, String idUzgodnienia, String dokument, String informacja, GM_Curve geometria, Funkcja funkcja, Przebieg przebieg, RodzPrzewodu rodzPrzewodu) {
        super(idIIP, startObiekt, cyklZyciaObiektu, koniecObiekt, zrodlo, istnienie, eksploatacja, idMaterialu, dataPomiaru, przedstawiciel, wladajacy, idBranzowy, idUzgodnienia, dokument, informacja);
        this.geometria = geometria;
        this.funkcja = funkcja;
        this.przebieg = przebieg;
        this.rodzPrzewodu = rodzPrzewodu;
    }

    public GM_Curve getGeometria() {
        return geometria;
    }

    public void setGeometria(GM_Curve geometria) {
        this.geometria = geometria;
    }

    public Funkcja getFunkcja() {
        return funkcja;
    }

    public void setFunkcja(Funkcja funkcja) {
        this.funkcja = funkcja;
    }

    public Przebieg getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(Przebieg przebieg) {
        this.przebieg = przebieg;
    }

    public RodzPrzewodu getRodzPrzewodu() {
        return rodzPrzewodu;
    }

    public void setRodzPrzewodu(RodzPrzewodu rodzPrzewodu) {
        this.rodzPrzewodu = rodzPrzewodu;
    }
}
