package gesut.repository.dao;

import gesut.repository.generic.Przewod;

public class PrzewodTelekomunikacyjny extends Przewod {
    private boolean wiazka;
    private int liczbaPrzewodow;

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
