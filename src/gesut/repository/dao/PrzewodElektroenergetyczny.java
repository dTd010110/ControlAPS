package gesut.repository.dao;

import gesut.repository.dictionaries.RodzCiep;
import gesut.repository.dictionaries.TypCiep;
import gesut.repository.dictionaries.TypElektr;
import gesut.repository.generic.Przewod;

public class PrzewodElektroenergetyczny extends Przewod {
    private boolean wiazka;
    private TypElektr typElektr;
    private boolean oswietleniowy;
    private int liczbaPrzewodow;

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
