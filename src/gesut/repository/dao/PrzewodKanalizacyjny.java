package gesut.repository.dao;

import gesut.repository.dictionaries.TypGaz;
import gesut.repository.dictionaries.TypKanal;
import gesut.repository.generic.Przewod;

public class PrzewodKanalizacyjny extends Przewod {
    private Integer srednica;
    private TypKanal typKanal;
    private int wymiarPionowy;
    private int wymiarPoziomy;
    private boolean tloczny;

    public Integer getSrednica() {
        return srednica;
    }

    public void setSrednica(Integer srednica) {
        this.srednica = srednica;
    }

    public TypKanal getTypKanal() {
        return typKanal;
    }

    public void setTypKanal(TypKanal typKanal) {
        this.typKanal = typKanal;
    }

    public int getWymiarPionowy() {
        return wymiarPionowy;
    }

    public void setWymiarPionowy(int wymiarPionowy) {
        this.wymiarPionowy = wymiarPionowy;
    }

    public int getWymiarPoziomy() {
        return wymiarPoziomy;
    }

    public void setWymiarPoziomy(int wymiarPoziomy) {
        this.wymiarPoziomy = wymiarPoziomy;
    }

    public boolean isTloczny() {
        return tloczny;
    }

    public void setTloczny(boolean tloczny) {
        this.tloczny = tloczny;
    }
}
