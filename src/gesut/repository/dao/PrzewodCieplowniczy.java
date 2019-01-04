package gesut.repository.dao;

import gesut.repository.dictionaries.RodzCiep;
import gesut.repository.dictionaries.TypCiep;
import gesut.repository.generic.Przewod;

public class PrzewodCieplowniczy extends Przewod {
    private Integer srednica;
    private TypCiep typCiep;
    private RodzCiep rodzCiep;

    public Integer getSrednica() {
        return srednica;
    }

    public void setSrednica(Integer srednica) {
        this.srednica = srednica;
    }

    public TypCiep getTypCiep() {
        return typCiep;
    }

    public void setTypCiep(TypCiep typCiep) {
        this.typCiep = typCiep;
    }

    public RodzCiep getRodzCiep() {
        return rodzCiep;
    }

    public void setRodzCiep(RodzCiep rodzCiep) {
        this.rodzCiep = rodzCiep;
    }
}
