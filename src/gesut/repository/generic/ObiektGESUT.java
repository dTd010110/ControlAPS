package gesut.repository.generic;

import gesut.repository.dao.DaneOsoby;

import java.util.Date;

public abstract class ObiektGESUT {
 private String idIIP;
 private Date startObiekt;
 private CyklZyciaInfo cyklZyciaObiektu; //sprawdzić typDaty
 private Date koniecObiekt;
 private String zrodlo;
 private String istnienie;
 private String eksploatacja;
 private String idMaterialu;
 private Date dataPomiaru;
 private DaneOsoby przedstawiciel;
 private DaneOsoby wladajacy;
 private String idBranzowy;
 private String idUzgodnienia;
 private String dokument;
 private String informacja;
}
