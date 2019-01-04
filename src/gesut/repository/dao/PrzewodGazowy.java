package gesut.repository.dao;

import gesut.repository.dictionaries.TypGaz;
import gesut.repository.generic.Przewod;

public class PrzewodGazowy extends Przewod {
    private Integer srednica;
    private TypGaz typGaz;

    public Integer getSrednica() {
        return srednica;
    }

    public void setSrednica(Integer srednica) {
        this.srednica = srednica;
    }

    public TypGaz getTypGaz() {
        return typGaz;
    }

    public void setTypGaz(TypGaz typGaz) {
        this.typGaz = typGaz;
    }
}
