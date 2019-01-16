package gesut.repository.generic;

import gesut.repository.dictionaries.OznaczenieZasobu;

import java.util.Objects;

public class IdMaterialu {

    private OznaczenieZasobu pierwszyCzlon;
    private String drugiCzlon;
    private int trzeciCzlon;
    private int czwartyCzlon;

    public IdMaterialu() {
    }

    public IdMaterialu(OznaczenieZasobu pierwszyCzlon, String drugiCzlon, int trzeciCzlon, int czwartyCzlon) {
        this.pierwszyCzlon = pierwszyCzlon;
        this.drugiCzlon = drugiCzlon;
        this.trzeciCzlon = trzeciCzlon;
        this.czwartyCzlon = czwartyCzlon;
    }

    public OznaczenieZasobu getPierwszyCzlon() {
        return pierwszyCzlon;
    }

    public void setPierwszyCzlon(OznaczenieZasobu pierwszyCzlon) {
        this.pierwszyCzlon = pierwszyCzlon;
    }

    public String getDrugiCzlon() {
        return drugiCzlon;
    }

    public void setDrugiCzlon(String drugiCzlon) {
        this.drugiCzlon = drugiCzlon;
    }

    public int getTrzeciCzlon() {
        return trzeciCzlon;
    }

    public void setTrzeciCzlon(int trzeciCzlon) {
        this.trzeciCzlon = trzeciCzlon;
    }

    public int getCzwartyCzlon() {
        return czwartyCzlon;
    }

    public void setCzwartyCzlon(int czwartyCzlon) {
        this.czwartyCzlon = czwartyCzlon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdMaterialu that = (IdMaterialu) o;
        return trzeciCzlon == that.trzeciCzlon &&
                czwartyCzlon == that.czwartyCzlon &&
                pierwszyCzlon == that.pierwszyCzlon &&
                Objects.equals(drugiCzlon, that.drugiCzlon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pierwszyCzlon, drugiCzlon, trzeciCzlon, czwartyCzlon);
    }

    @Override
    public String toString() {
        return "IdMaterialu{" +
                "pierwszyCzlon=" + pierwszyCzlon +
                ", drugiCzlon='" + drugiCzlon + '\'' +
                ", trzeciCzlon=" + trzeciCzlon +
                ", czwartyCzlon=" + czwartyCzlon +
                '}';
    }
}
