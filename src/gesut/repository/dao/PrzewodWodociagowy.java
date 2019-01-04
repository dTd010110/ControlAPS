package gesut.repository.dao;

import gesut.repository.dictionaries.TypWodoc;
import gesut.repository.generic.Przewod;

public class PrzewodWodociagowy extends Przewod {
    private Integer srednica;
    private TypWodoc typWodoc;

    public TypWodoc getTypWodoc() {
        return typWodoc;
    }

    public void setTypWodoc(TypWodoc typWodoc) {
        this.typWodoc = typWodoc;
    }

    public Integer getSrednica() {
        return srednica;
    }

    public void setSrednica(Integer srednica) {
        this.srednica = srednica;
    }
}
