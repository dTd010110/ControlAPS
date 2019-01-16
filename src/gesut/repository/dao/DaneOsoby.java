package gesut.repository.dao;

import java.util.Objects;

public class DaneOsoby {
    private String nazwaPelna;
    private String nazwaSkrocona;
    private String imieNazwisko;
    private String email;
    private String telefon;
    private String adres;
    private PunktAdresowy adresPRG;
    private String informacja;

    public String getNazwaPelna() {
        return nazwaPelna;
    }

    public void setNazwaPelna(String nazwaPelna) {
        this.nazwaPelna = nazwaPelna;
    }

    public String getNazwaSkrocona() {
        return nazwaSkrocona;
    }

    public void setNazwaSkrocona(String nazwaSkrocona) {
        this.nazwaSkrocona = nazwaSkrocona;
    }

    public String getImieNazwisko() {
        return imieNazwisko;
    }

    public void setImieNazwisko(String imieNazwisko) {
        this.imieNazwisko = imieNazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public PunktAdresowy getAdresPRG() {
        return adresPRG;
    }

    public void setAdresPRG(PunktAdresowy adresPRG) {
        this.adresPRG = adresPRG;
    }

    public String getInformacja() {
        return informacja;
    }

    public void setInformacja(String informacja) {
        this.informacja = informacja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DaneOsoby daneOsoby = (DaneOsoby) o;
        return Objects.equals(nazwaPelna, daneOsoby.nazwaPelna) &&
                Objects.equals(nazwaSkrocona, daneOsoby.nazwaSkrocona) &&
                Objects.equals(imieNazwisko, daneOsoby.imieNazwisko) &&
                Objects.equals(email, daneOsoby.email) &&
                Objects.equals(telefon, daneOsoby.telefon) &&
                Objects.equals(adres, daneOsoby.adres) &&
                Objects.equals(adresPRG, daneOsoby.adresPRG) &&
                Objects.equals(informacja, daneOsoby.informacja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwaPelna, nazwaSkrocona, imieNazwisko, email, telefon, adres, adresPRG, informacja);
    }
}
