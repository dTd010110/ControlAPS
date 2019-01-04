package gesut.repository.generic;

import gesut.repository.dictionaries.Funkcja;
import gesut.repository.dictionaries.Przebieg;
import gesut.repository.dictionaries.RodzPrzewodu;

public class Przewod extends ObiektGESUT{
    private GM_Curve geometria;
    private Funkcja funkcja;
    private Przebieg przebieg;
    private RodzPrzewodu rodzPrzewodu;

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
