package gesut.repository.generic;

import gesut.repository.dao.DaneOsoby;
import gesut.repository.dictionaries.Eksploatacja;
import gesut.repository.dictionaries.Istnienie;
import gesut.repository.dictionaries.Zrodlo;

import java.util.Date;

public abstract class ObiektGESUT {
 private Identyfikator idIIP;
 private Date startObiekt;
 private CyklZyciaInfo cyklZyciaObiektu;
 private Date koniecObiekt;
 private Zrodlo zrodlo;
 private Istnienie istnienie;
 private Eksploatacja eksploatacja;
 private IdMaterialu idMaterialu;
 private Date dataPomiaru;
 private DaneOsoby przedstawiciel;
 private DaneOsoby wladajacy;
 private String idBranzowy;
 private String idUzgodnienia;
 private String dokument;
 private String informacja;

 public Identyfikator getIdIIP() {
  return idIIP;
 }

 public void setIdIIP(Identyfikator idIIP) {
  this.idIIP = idIIP;
 }

 public Date getStartObiekt() {
  return startObiekt;
 }

 public void setStartObiekt(Date startObiekt) {
  this.startObiekt = startObiekt;
 }

 public CyklZyciaInfo getCyklZyciaObiektu() {
  return cyklZyciaObiektu;
 }

 public void setCyklZyciaObiektu(CyklZyciaInfo cyklZyciaObiektu) {
  this.cyklZyciaObiektu = cyklZyciaObiektu;
 }

 public Date getKoniecObiekt() {
  return koniecObiekt;
 }

 public void setKoniecObiekt(Date koniecObiekt) {
  this.koniecObiekt = koniecObiekt;
 }

 public Zrodlo getZrodlo() {
  return zrodlo;
 }

 public void setZrodlo(Zrodlo zrodlo) {
  this.zrodlo = zrodlo;
 }

 public Istnienie getIstnienie() {
  return istnienie;
 }

 public void setIstnienie(Istnienie istnienie) {
  this.istnienie = istnienie;
 }

 public Eksploatacja getEksploatacja() {
  return eksploatacja;
 }

 public void setEksploatacja(Eksploatacja eksploatacja) {
  this.eksploatacja = eksploatacja;
 }

 public IdMaterialu getIdMaterialu() {
  return idMaterialu;
 }

 public void setIdMaterialu(IdMaterialu idMaterialu) {
  this.idMaterialu = idMaterialu;
 }

 public Date getDataPomiaru() {
  return dataPomiaru;
 }

 public void setDataPomiaru(Date dataPomiaru) {
  this.dataPomiaru = dataPomiaru;
 }

 public DaneOsoby getPrzedstawiciel() {
  return przedstawiciel;
 }

 public void setPrzedstawiciel(DaneOsoby przedstawiciel) {
  this.przedstawiciel = przedstawiciel;
 }

 public DaneOsoby getWladajacy() {
  return wladajacy;
 }

 public void setWladajacy(DaneOsoby wladajacy) {
  this.wladajacy = wladajacy;
 }

 public String getIdBranzowy() {
  return idBranzowy;
 }

 public void setIdBranzowy(String idBranzowy) {
  this.idBranzowy = idBranzowy;
 }

 public String getIdUzgodnienia() {
  return idUzgodnienia;
 }

 public void setIdUzgodnienia(String idUzgodnienia) {
  this.idUzgodnienia = idUzgodnienia;
 }

 public String getDokument() {
  return dokument;
 }

 public void setDokument(String dokument) {
  this.dokument = dokument;
 }

 public String getInformacja() {
  return informacja;
 }

 public void setInformacja(String informacja) {
  this.informacja = informacja;
 }
}
