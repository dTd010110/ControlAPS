package gesut.repository.generic;

import java.time.LocalDateTime;
import java.util.Objects;

public class Identyfikator {

    private String lokalnyId;
    private String przestrzenNazw;
    private LocalDateTime wersjaId;

    public String getLokalnyId() {
        return lokalnyId;
    }

    public void setLokalnyId(String lokalnyId) {
        this.lokalnyId = lokalnyId;
    }

    public String getPrzestrzenNazw() {
        return przestrzenNazw;
    }

    public void setPrzestrzenNazw(String przestrzenNazw) {
        this.przestrzenNazw = przestrzenNazw;
    }

    public LocalDateTime getWersjaId() {
        return wersjaId;
    }

    public void setWersjaId(LocalDateTime wersjaId) {
        this.wersjaId = wersjaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identyfikator that = (Identyfikator) o;
        return Objects.equals(lokalnyId, that.lokalnyId) &&
                Objects.equals(przestrzenNazw, that.przestrzenNazw) &&
                Objects.equals(wersjaId, that.wersjaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lokalnyId, przestrzenNazw, wersjaId);
    }
}
