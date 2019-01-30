package gesut.inspections;

import gesut.gml.GmlImport;
import gesut.repository.dao.*;
import gesut.repository.generic.Identyfikator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class InspactionsComponent {

    private GmlImport gmlImport = new GmlImport();
    private GeometryInspactions geometryInspactions = new GeometryInspactions();

    private List<BudowlaPodziemna> budowlaPodziemnaList;
    private List<KorytarzPrzesylowy> korytarzPrzesylowyList;
    private List<ObiektKarto> obiektKartoList;
    private List<ObudowaPrzewodu> obudowaPrzewoduList;
    private List<PrzewodBenzynowy> przewodBenzynowyList;
    private List<PrzewodCieplowniczy> przewodCieplowniczyList;
    private List<PrzewodElektroenergetyczny> przewodElektroenergetycznyList;
    private List<PrzewodGazowy> przewodGazowyList;
    private List<PrzewodInny> przewodInnyList;
    private List<PrzewodKanalizacyjny> przewodKanalizacyjnyList;
    private List<PrzewodNaftowy> przewodNaftowyList;
    private List<PrzewodNiezidentyfikowany> przewodNiezidentyfikowanyList;
    private List<PrzewodTelekomunikacyjny> przewodTelekomunikacyjnyList;
    private List<PrzewodWodociagowy> przewodWodociagowyList;
    private List<PunktOOkreslonejWysokosci> punktOOkreslonejWysokosciList;
    private List<SlupIMaszt> slupIMasztList;
    private List<UrzadzenieTechniczneZwiazaneZSiecia> urzadzenieTechniczneZwiazaneZSieciaList;

    private HashMap<Identyfikator, Identyfikator> identyfikatorHashSet;

    public void importGml(File file){
        try {
            gmlImport.importGmlFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void duplicateControl(double tolerance){
        geometryInspactions.duplicatePointObcjets_PunktOOkreslonejWysokosci(gmlImport.getPunktOOkreslonejWysokosciList(), tolerance);
        geometryInspactions.duplicatePointObcjetsOnLines_PunktOOkreslonejWysokosci(gmlImport.getPunktOOkreslonejWysokosciList(), gmlImport.getMapOfLinesCoordinates(),tolerance);
        geometryInspactions.duplicatePointObcjets_SLUPIMASZT(gmlImport.getSlupIMasztList(),tolerance);
        geometryInspactions.duplicateLineObcjets(gmlImport.getPrzewodBenzynowyList(),tolerance);
        geometryInspactions.duplicateLineObcjets(gmlImport.getPrzewodCieplowniczyList(),tolerance);
        geometryInspactions.duplicateLineObcjets(gmlImport.getPrzewodElektroenergetycznyList(),tolerance);
        geometryInspactions.duplicateLineObcjets(gmlImport.getPrzewodGazowyList(),tolerance);
        geometryInspactions.duplicateLineObcjets(gmlImport.getPrzewodInnyList(),tolerance);
        geometryInspactions.duplicateLineObcjets(gmlImport.getPrzewodKanalizacyjnyList(),tolerance);
        geometryInspactions.duplicateLineObcjets(gmlImport.getPrzewodNaftowyList(),tolerance);
        geometryInspactions.duplicateLineObcjets(gmlImport.getPrzewodNiezidentyfikowanyList(),tolerance);
        geometryInspactions.duplicateLineObcjets(gmlImport.getPrzewodTelekomunikacyjnyList(),tolerance);
        geometryInspactions.duplicateLineObcjets(gmlImport.getPrzewodWodociagowyList(),tolerance);

        geometryInspactions.duplicateLineVertex(gmlImport.getPrzewodBenzynowyList());
        geometryInspactions.duplicateLineVertex(gmlImport.getPrzewodCieplowniczyList());
        geometryInspactions.duplicateLineVertex(gmlImport.getPrzewodElektroenergetycznyList());
        geometryInspactions.duplicateLineVertex(gmlImport.getPrzewodGazowyList());
        geometryInspactions.duplicateLineVertex(gmlImport.getPrzewodInnyList());
        geometryInspactions.duplicateLineVertex(gmlImport.getPrzewodKanalizacyjnyList());
        geometryInspactions.duplicateLineVertex(gmlImport.getPrzewodNaftowyList());
        geometryInspactions.duplicateLineVertex(gmlImport.getPrzewodNiezidentyfikowanyList());
        geometryInspactions.duplicateLineVertex(gmlImport.getPrzewodTelekomunikacyjnyList());
        geometryInspactions.duplicateLineVertex(gmlImport.getPrzewodWodociagowyList());

        geometryInspactions.duplicateAreaVertex(gmlImport.getBudowlaPodziemnaList());
        geometryInspactions.duplicateAreaVertex(gmlImport.getKorytarzPrzesylowyList());
        geometryInspactions.duplicateAreaVertex(gmlImport.getUrzadzenieTechniczneZwiazaneZSieciaList());
    }

    public void threePointDeviation(){
        geometryInspactions.checkThreePointDeviationOnLine(gmlImport.getPrzewodBenzynowyList());
        geometryInspactions.checkThreePointDeviationOnLine(gmlImport.getPrzewodCieplowniczyList());
        geometryInspactions.checkThreePointDeviationOnLine(gmlImport.getPrzewodElektroenergetycznyList());
        geometryInspactions.checkThreePointDeviationOnLine(gmlImport.getPrzewodGazowyList());
        geometryInspactions.checkThreePointDeviationOnLine(gmlImport.getPrzewodInnyList());
        geometryInspactions.checkThreePointDeviationOnLine(gmlImport.getPrzewodKanalizacyjnyList());
        geometryInspactions.checkThreePointDeviationOnLine(gmlImport.getPrzewodNaftowyList());
        geometryInspactions.checkThreePointDeviationOnLine(gmlImport.getPrzewodNiezidentyfikowanyList());
        geometryInspactions.checkThreePointDeviationOnLine(gmlImport.getPrzewodTelekomunikacyjnyList());
        geometryInspactions.checkThreePointDeviationOnLine(gmlImport.getPrzewodWodociagowyList());

        geometryInspactions.checkThreePointDeviationOnArea(gmlImport.getBudowlaPodziemnaList());
        geometryInspactions.checkThreePointDeviationOnArea(gmlImport.getUrzadzenieTechniczneZwiazaneZSieciaList());
        geometryInspactions.checkThreePointDeviationOnArea(gmlImport.getKorytarzPrzesylowyList());
    }

//    Odległość między dwoma sąsiednimi werteksami jest mniejsza niż 10 cm
    public void shortSpaceBetweenCoordinates(double tolerance){
        geometryInspactions.shortSpaceBetweenLineVertex(gmlImport.getPrzewodBenzynowyList(),tolerance);
        geometryInspactions.shortSpaceBetweenLineVertex(gmlImport.getPrzewodCieplowniczyList(),tolerance);
        geometryInspactions.shortSpaceBetweenLineVertex(gmlImport.getPrzewodElektroenergetycznyList(),tolerance);
        geometryInspactions.shortSpaceBetweenLineVertex(gmlImport.getPrzewodGazowyList(),tolerance);
        geometryInspactions.shortSpaceBetweenLineVertex(gmlImport.getPrzewodInnyList(),tolerance);
        geometryInspactions.shortSpaceBetweenLineVertex(gmlImport.getPrzewodKanalizacyjnyList(),tolerance);
        geometryInspactions.shortSpaceBetweenLineVertex(gmlImport.getPrzewodNaftowyList(),tolerance);
        geometryInspactions.shortSpaceBetweenLineVertex(gmlImport.getPrzewodNiezidentyfikowanyList(),tolerance);
        geometryInspactions.shortSpaceBetweenLineVertex(gmlImport.getPrzewodTelekomunikacyjnyList(),tolerance);
        geometryInspactions.shortSpaceBetweenLineVertex(gmlImport.getPrzewodWodociagowyList(),tolerance);

        geometryInspactions.shortSpaceBetweenAreaVertex(gmlImport.getBudowlaPodziemnaList(), tolerance);
        geometryInspactions.shortSpaceBetweenAreaVertex(gmlImport.getUrzadzenieTechniczneZwiazaneZSieciaList(), tolerance);
        geometryInspactions.shortSpaceBetweenAreaVertex(gmlImport.getKorytarzPrzesylowyList(), tolerance);
    }

    //Samoprzeciecia
    public void autoCrosses(){
        geometryInspactions.autoCrossesLine(gmlImport.getPrzewodBenzynowyList());
        geometryInspactions.autoCrossesLine(gmlImport.getPrzewodCieplowniczyList());
        geometryInspactions.autoCrossesLine(gmlImport.getPrzewodElektroenergetycznyList());
        geometryInspactions.autoCrossesLine(gmlImport.getPrzewodGazowyList());
        geometryInspactions.autoCrossesLine(gmlImport.getPrzewodInnyList());
        geometryInspactions.autoCrossesLine(gmlImport.getPrzewodKanalizacyjnyList());
        geometryInspactions.autoCrossesLine(gmlImport.getPrzewodNaftowyList());
        geometryInspactions.autoCrossesLine(gmlImport.getPrzewodNiezidentyfikowanyList());
        geometryInspactions.autoCrossesLine(gmlImport.getPrzewodTelekomunikacyjnyList());
        geometryInspactions.autoCrossesLine(gmlImport.getPrzewodWodociagowyList());
    }

//    Nakładanie się segmentów tej samej linii
    public void autoOverlapping(){
        geometryInspactions.overlappingSegmentsLine(gmlImport.getPrzewodBenzynowyList());
        geometryInspactions.overlappingSegmentsLine(gmlImport.getPrzewodCieplowniczyList());
        geometryInspactions.overlappingSegmentsLine(gmlImport.getPrzewodElektroenergetycznyList());
        geometryInspactions.overlappingSegmentsLine(gmlImport.getPrzewodGazowyList());
        geometryInspactions.overlappingSegmentsLine(gmlImport.getPrzewodInnyList());
        geometryInspactions.overlappingSegmentsLine(gmlImport.getPrzewodKanalizacyjnyList());
        geometryInspactions.overlappingSegmentsLine(gmlImport.getPrzewodNaftowyList());
        geometryInspactions.overlappingSegmentsLine(gmlImport.getPrzewodNiezidentyfikowanyList());
        geometryInspactions.overlappingSegmentsLine(gmlImport.getPrzewodTelekomunikacyjnyList());
        geometryInspactions.overlappingSegmentsLine(gmlImport.getPrzewodWodociagowyList());
    }

    //    Niedociągnięcie połączenia linii
    public void undershotControl(double tolerance) {
        geometryInspactions.undershot(gmlImport.getPrzewodBenzynowyList(), tolerance);
        geometryInspactions.undershot(gmlImport.getPrzewodCieplowniczyList(), tolerance);
        geometryInspactions.undershot(gmlImport.getPrzewodElektroenergetycznyList(), tolerance);
        geometryInspactions.undershot(gmlImport.getPrzewodGazowyList(), tolerance);
        geometryInspactions.undershot(gmlImport.getPrzewodInnyList(), tolerance);
        geometryInspactions.undershot(gmlImport.getPrzewodKanalizacyjnyList(), tolerance);
        geometryInspactions.undershot(gmlImport.getPrzewodNaftowyList(), tolerance);
        geometryInspactions.undershot(gmlImport.getPrzewodNiezidentyfikowanyList(), tolerance);
        geometryInspactions.undershot(gmlImport.getPrzewodTelekomunikacyjnyList(), tolerance);
        geometryInspactions.undershot(gmlImport.getPrzewodWodociagowyList(), tolerance);
    }

    //Uskok linii tolerancja 0.1 m
    public void lineFault(double tolerance) {
        geometryInspactions.lineFault(gmlImport.getPrzewodBenzynowyList(), tolerance);
        geometryInspactions.lineFault(gmlImport.getPrzewodCieplowniczyList(), tolerance);
        geometryInspactions.lineFault(gmlImport.getPrzewodElektroenergetycznyList(), tolerance);
        geometryInspactions.lineFault(gmlImport.getPrzewodGazowyList(), tolerance);
        geometryInspactions.lineFault(gmlImport.getPrzewodInnyList(), tolerance);
        geometryInspactions.lineFault(gmlImport.getPrzewodKanalizacyjnyList(), tolerance);
        geometryInspactions.lineFault(gmlImport.getPrzewodNaftowyList(), tolerance);
        geometryInspactions.lineFault(gmlImport.getPrzewodNiezidentyfikowanyList(), tolerance);
        geometryInspactions.lineFault(gmlImport.getPrzewodTelekomunikacyjnyList(), tolerance);
        geometryInspactions.lineFault(gmlImport.getPrzewodWodociagowyList(), tolerance);
    }

    //    Nakładanie się segmentów tej samej linii
    public void excessiveSegmentation(){
        geometryInspactions.excessiveSegmentation(gmlImport.getPrzewodBenzynowyList());
        geometryInspactions.excessiveSegmentation(gmlImport.getPrzewodCieplowniczyList());
        geometryInspactions.excessiveSegmentation(gmlImport.getPrzewodElektroenergetycznyList());
        geometryInspactions.excessiveSegmentation(gmlImport.getPrzewodGazowyList());
        geometryInspactions.excessiveSegmentation(gmlImport.getPrzewodInnyList());
        geometryInspactions.excessiveSegmentation(gmlImport.getPrzewodKanalizacyjnyList());
        geometryInspactions.excessiveSegmentation(gmlImport.getPrzewodNaftowyList());
        geometryInspactions.excessiveSegmentation(gmlImport.getPrzewodNiezidentyfikowanyList());
        geometryInspactions.excessiveSegmentation(gmlImport.getPrzewodTelekomunikacyjnyList());
        geometryInspactions.excessiveSegmentation(gmlImport.getPrzewodWodociagowyList());
    }

}


