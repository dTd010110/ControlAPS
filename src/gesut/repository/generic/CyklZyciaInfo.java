package gesut.repository.generic;

import java.time.LocalDateTime;
import java.util.Objects;

public class CyklZyciaInfo {
    private LocalDateTime koniecWersjiObiektu;
    private LocalDateTime poczatekWersjiObiektu;

    public CyklZyciaInfo() {
    }

    public CyklZyciaInfo(LocalDateTime koniecWersjiObiektu) {
        this.koniecWersjiObiektu = koniecWersjiObiektu;
    }

    public CyklZyciaInfo(LocalDateTime koniecWersjiObiektu, LocalDateTime poczatekWersjiObiektu) {
        this.koniecWersjiObiektu = koniecWersjiObiektu;
        this.poczatekWersjiObiektu = poczatekWersjiObiektu;
    }

    public LocalDateTime getKoniecWersjiObiektu() {
        return koniecWersjiObiektu;
    }

    public void setKoniecWersjiObiektu(LocalDateTime koniecWersjiObiektu) {
        this.koniecWersjiObiektu = koniecWersjiObiektu;
    }

    public LocalDateTime getPoczatekWersjiObiektu() {
        return poczatekWersjiObiektu;
    }

    public void setPoczatekWersjiObiektu(LocalDateTime poczatekWersjiObiektu) {
        this.poczatekWersjiObiektu = poczatekWersjiObiektu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CyklZyciaInfo that = (CyklZyciaInfo) o;
        return Objects.equals(koniecWersjiObiektu, that.koniecWersjiObiektu) &&
                Objects.equals(poczatekWersjiObiektu, that.poczatekWersjiObiektu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(koniecWersjiObiektu, poczatekWersjiObiektu);
    }
}
