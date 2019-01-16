package gesut.repository.generic;

import gesut.repository.dao.DaneOsoby;
import gesut.repository.dictionaries.Eksploatacja;
import gesut.repository.dictionaries.Istnienie;
import gesut.repository.dictionaries.Zrodlo;

import java.time.LocalDate;

public abstract class ObiektGESUT  extends GeometryFromGml {
 private Identyfikator idIIP;
 private LocalDate startObiekt;
 private CyklZyciaInfo cyklZyciaObiektu;
 private LocalDate koniecObiekt;
 private Zrodlo zrodlo;
 private Istnienie istnienie;
 private Eksploatacja eksploatacja;
 private IdMaterialu idMaterialu;
 private LocalDate dataPomiaru;
 private DaneOsoby przedstawiciel;
 private DaneOsoby wladajacy;
 private String idBranzowy;
 private String idUzgodnienia;
 private String dokument;
 private String informacja;

 public ObiektGESUT() {
 }

 public ObiektGESUT(Identyfikator idIIP, LocalDate startObiekt, CyklZyciaInfo cyklZyciaObiektu, LocalDate koniecObiekt, Zrodlo zrodlo, Istnienie istnienie, Eksploatacja eksploatacja, IdMaterialu idMaterialu, LocalDate dataPomiaru, DaneOsoby przedstawiciel, DaneOsoby wladajacy, String idBranzowy, String idUzgodnienia, String dokument, String informacja) {
  this.idIIP = idIIP;
  this.startObiekt = startObiekt;
  this.cyklZyciaObiektu = cyklZyciaObiektu;
  this.koniecObiekt = koniecObiekt;
  this.zrodlo = zrodlo;
  this.istnienie = istnienie;
  this.eksploatacja = eksploatacja;
  this.idMaterialu = idMaterialu;
  this.dataPomiaru = dataPomiaru;
  this.przedstawiciel = przedstawiciel;
  this.wladajacy = wladajacy;
  this.idBranzowy = idBranzowy;
  this.idUzgodnienia = idUzgodnienia;
  this.dokument = dokument;
  this.informacja = informacja;
 }

 public Identyfikator getIdIIP() {
  return idIIP;
 }

 public void setIdIIP(Identyfikator idIIP) {
  this.idIIP = idIIP;
 }

 public CyklZyciaInfo getCyklZyciaObiektu() {
  return cyklZyciaObiektu;
 }

 public void setCyklZyciaObiektu(CyklZyciaInfo cyklZyciaObiektu) {
  this.cyklZyciaObiektu = cyklZyciaObiektu;
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

 public LocalDate getStartObiekt() {
  return startObiekt;
 }

 public void setStartObiekt(LocalDate startObiekt) {
  this.startObiekt = startObiekt;
 }

 public LocalDate getKoniecObiekt() {
  return koniecObiekt;
 }

 public void setKoniecObiekt(LocalDate koniecObiekt) {
  this.koniecObiekt = koniecObiekt;
 }

 public LocalDate getDataPomiaru() {
  return dataPomiaru;
 }

 public void setDataPomiaru(LocalDate dataPomiaru) {
  this.dataPomiaru = dataPomiaru;
 }
}
