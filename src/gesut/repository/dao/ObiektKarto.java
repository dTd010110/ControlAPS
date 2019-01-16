package gesut.repository.dao;

import gesut.repository.generic.GM_Object;
import gesut.repository.generic.Identyfikator;
import gesut.repository.generic.KR_Etykieta;
import gesut.repository.generic.ReferencjaDoObiektu;

import java.util.List;

public class ObiektKarto {
    private int mianownikSkali;
    private String kodKarto;
    private String uwagi;
    private KR_Etykieta etykieta;
    private double parametr;
    private String warstwa;
    private double katObrotu;
    private Identyfikator obiektPrzedstawiany;

    public int getMianownikSkali() {
        return mianownikSkali;
    }

    public void setMianownikSkali(int mianownikSkali) {
        this.mianownikSkali = mianownikSkali;
    }

    public String getKodKarto() {
        return kodKarto;
    }

    public void setKodKarto(String kodKarto) {
        this.kodKarto = kodKarto;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    public KR_Etykieta getEtykieta() {
        return etykieta;
    }

    public void setEtykieta(KR_Etykieta etykieta) {
        this.etykieta = etykieta;
    }

    public double getParametr() {
        return parametr;
    }

    public void setParametr(double parametr) {
        this.parametr = parametr;
    }

    public String getWarstwa() {
        return warstwa;
    }

    public void setWarstwa(String warstwa) {
        this.warstwa = warstwa;
    }

    public double getKatObrotu() {
        return katObrotu;
    }

    public void setKatObrotu(double katObrotu) {
        this.katObrotu = katObrotu;
    }

    public Identyfikator getObiektPrzedstawiany() {
        return obiektPrzedstawiany;
    }

    public void setObiektPrzedstawiany(Identyfikator obiektPrzedstawiany) {
        this.obiektPrzedstawiany = obiektPrzedstawiany;
    }
}
