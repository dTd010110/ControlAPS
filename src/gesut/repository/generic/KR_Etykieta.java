package gesut.repository.generic;

public class KR_Etykieta {
    private String tekst;
    private KR_KrojPisma czcionka;
    private GM_Primitive geometriaKarto;
    private GM_Curve odnosnik;
    private float katObrotu;
    private int justyfikacja;
    private String kodKarto;

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public KR_KrojPisma getCzcionka() {
        return czcionka;
    }

    public void setCzcionka(KR_KrojPisma czcionka) {
        this.czcionka = czcionka;
    }

    public GM_Primitive getGeometriaKarto() {
        return geometriaKarto;
    }

    public void setGeometriaKarto(GM_Primitive geometriaKarto) {
        this.geometriaKarto = geometriaKarto;
    }

    public GM_Curve getOdnosnik() {
        return odnosnik;
    }

    public void setOdnosnik(GM_Curve odnosnik) {
        this.odnosnik = odnosnik;
    }

    public float getKatObrotu() {
        return katObrotu;
    }

    public void setKatObrotu(float katObrotu) {
        this.katObrotu = katObrotu;
    }

    public int getJustyfikacja() {
        return justyfikacja;
    }

    public void setJustyfikacja(int justyfikacja) {
        this.justyfikacja = justyfikacja;
    }

    public String getKodKarto() {
        return kodKarto;
    }

    public void setKodKarto(String kodKarto) {
        this.kodKarto = kodKarto;
    }
}
