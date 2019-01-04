package gesut.repository.dao;

import gesut.repository.dictionaries.*;
import gesut.repository.generic.GM_Primitive;
import gesut.repository.generic.GM_Surface;
import gesut.repository.generic.ObiektGESUT;

public class BudowlaPodziemna extends ObiektGESUT {
   private GM_Surface geometria;
   private RodzBud rodzBudowli;
   private RodzSieci rodzSieci;

    public GM_Surface getGeometria() {
        return geometria;
    }

    public void setGeometria(GM_Surface geometria) {
        this.geometria = geometria;
    }

    public RodzBud getRodzBudowli() {
        return rodzBudowli;
    }

    public void setRodzBudowli(RodzBud rodzBudowli) {
        this.rodzBudowli = rodzBudowli;
    }

    public RodzSieci getRodzSieci() {
        return rodzSieci;
    }

    public void setRodzSieci(RodzSieci rodzSieci) {
        this.rodzSieci = rodzSieci;
    }
}
