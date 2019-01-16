package gesut.repository.dao;

import gesut.gml.GestuTransferedObject;
import gesut.repository.dictionaries.*;
import gesut.repository.generic.*;

import java.time.LocalDate;

public class BudowlaPodziemna extends ObiektGESUT {
   private GM_Surface geometria;
   private RodzBud rodzBudowli;
   private RodzSieci rodzSieci;

    public BudowlaPodziemna() {
    }

    public BudowlaPodziemna(GM_Surface geometria, RodzBud rodzBudowli, RodzSieci rodzSieci) {
        this.geometria = geometria;
        this.rodzBudowli = rodzBudowli;
        this.rodzSieci = rodzSieci;
    }

    public BudowlaPodziemna(Identyfikator idIIP, LocalDate startObiekt, CyklZyciaInfo cyklZyciaObiektu, LocalDate koniecObiekt, Zrodlo zrodlo, Istnienie istnienie, Eksploatacja eksploatacja, IdMaterialu idMaterialu, LocalDate dataPomiaru, DaneOsoby przedstawiciel, DaneOsoby wladajacy, String idBranzowy, String idUzgodnienia, String dokument, String informacja) {
        super(idIIP, startObiekt, cyklZyciaObiektu, koniecObiekt, zrodlo, istnienie, eksploatacja, idMaterialu, dataPomiaru, przedstawiciel, wladajacy, idBranzowy, idUzgodnienia, dokument, informacja);
    }

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
