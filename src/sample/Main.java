package sample;

import com.vividsolutions.jts.geom.Coordinate;
import gesut.gml.GmlImport;
import gesut.inspections.GeometryInspactions;
import gesut.repository.dao.*;
import gesut.repository.generic.Identyfikator;
import gesut.repository.generic.ObiektGESUT;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {

//        launch(args);
//        File file = new File("C:\\Users\\Asiasin\\Downloads\\GMLe_ZBYSZEK\\duplikaty.xml");
        File file = new File("C:\\Users\\Asiasin\\Downloads\\GMLe_ZBYSZEK\\export_testy\\brakCiaglosciSieciPrzyPrzejsciuPrzez");
        GmlImport gmlImport = new GmlImport();
        try {
            double startTime, endTime, duration;
            startTime = System.nanoTime();
            System.out.println(startTime);
            gmlImport.importGmlFile(file);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println(endTime);

            long nano = 1000000000;
            System.out.println(duration);
            System.out.println(duration/nano);

            List<BudowlaPodziemna> budowlaPodziemnaList = gmlImport.getBudowlaPodziemnaList();
            System.out.println("budowlaPodziemnaList : " + budowlaPodziemnaList.size());

            List<KorytarzPrzesylowy> korytarzPrzesylowyList = gmlImport.getKorytarzPrzesylowyList();
            System.out.println("korytarzPrzesylowyList : " + korytarzPrzesylowyList.size());

            List<ObiektKarto> obiektKartoList = gmlImport.getObiektKartoList();
            System.out.println("obiektKartoList : " + obiektKartoList.size());

            List<ObudowaPrzewodu> obudowaPrzewoduList = gmlImport.getObudowaPrzewoduList();
            System.out.println("obudowaPrzewoduList : " + obudowaPrzewoduList.size());

            List<PrzewodBenzynowy> przewodBenzynowyList = gmlImport.getPrzewodBenzynowyList();
            System.out.println("przewodBenzynowyList : " + przewodBenzynowyList.size());

            List<PrzewodCieplowniczy> przewodCieplowniczyList = gmlImport.getPrzewodCieplowniczyList();
            System.out.println("przewodCieplowniczyList : " + przewodCieplowniczyList.size());

            List<PrzewodElektroenergetyczny> przewodElektroenergetycznyList = gmlImport.getPrzewodElektroenergetycznyList();
            System.out.println("przewodElektroenergetycznyList : " + przewodElektroenergetycznyList.size());

            List<PrzewodGazowy> przewodGazowyList = gmlImport.getPrzewodGazowyList();
            System.out.println("przewodGazowyList : " + przewodGazowyList.size());

            List<PrzewodInny> przewodInnyList = gmlImport.getPrzewodInnyList();
            System.out.println("przewodInnyList : " + przewodInnyList.size());

            List<PrzewodKanalizacyjny> przewodKanalizacyjnyList = gmlImport.getPrzewodKanalizacyjnyList();
            System.out.println("przewodKanalizacyjnyList : " + przewodKanalizacyjnyList.size());

            List<PrzewodNaftowy> przewodNaftowyList = gmlImport.getPrzewodNaftowyList();
            System.out.println("przewodNaftowyList : " + przewodNaftowyList.size());

            List<PrzewodNiezidentyfikowany> przewodNiezidentyfikowanyList = gmlImport.getPrzewodNiezidentyfikowanyList();
            System.out.println("przewodNiezidentyfikowanyList : " + przewodNiezidentyfikowanyList.size());

            List<PrzewodTelekomunikacyjny> przewodTelekomunikacyjnyList = gmlImport.getPrzewodTelekomunikacyjnyList();
            System.out.println("przewodTelekomunikacyjnyList : " + przewodTelekomunikacyjnyList.size());

            List<PrzewodWodociagowy> przewodWodociagowyList = gmlImport.getPrzewodWodociagowyList();
            System.out.println("przewodWodociagowyList : " + przewodWodociagowyList.size());

            List<PunktOOkreslonejWysokosci> punktOOkreslonejWysokosciList = gmlImport.getPunktOOkreslonejWysokosciList();
            System.out.println("punktOOkreslonejWysokosciList : " + punktOOkreslonejWysokosciList.size());

            List<SlupIMaszt> slupIMasztList = gmlImport.getSlupIMasztList();
            System.out.println("slupIMasztList : " + slupIMasztList.size());

            List<UrzadzenieTechniczneZwiazaneZSiecia> urzadzenieTechniczneZwiazaneZSieciaList = gmlImport.getUrzadzenieTechniczneZwiazaneZSieciaList();
            System.out.println("urzadzenieTechniczneZwiazaneZSieciaList : " + urzadzenieTechniczneZwiazaneZSieciaList.size());

            HashMap<Identyfikator, Identyfikator> identyfikatorHashSet = gmlImport.getIdentyfikatorHashSet();
            System.out.println("identyfikatorHashSet : " + identyfikatorHashSet.size());

            System.out.println(gmlImport.policz);

            GeometryInspactions geometryInspactions = new GeometryInspactions();
            List<PrzewodWodociagowy> duplicateLineObcjets = geometryInspactions.duplicateLineObcjets(przewodWodociagowyList, 0.00);
            List<PunktOOkreslonejWysokosci> duplicatePointObcjetsPunktOOkreslonejWysokosci = geometryInspactions.duplicatePointObcjets_PunktOOkreslonejWysokosci(punktOOkreslonejWysokosciList, 0.00);
            System.out.println("duplikaty pkt wys: " + duplicatePointObcjetsPunktOOkreslonejWysokosci.size());

            List<SlupIMaszt> duplicatePointObcjets_slupimaszt = geometryInspactions.duplicatePointObcjets_SLUPIMASZT(slupIMasztList, 0.00);
            System.out.println("duplikaty slupMaszt: " +duplicatePointObcjets_slupimaszt.size());


            HashMap<Coordinate, Integer> mapOfStartEndPoints = gmlImport.getMapOfLinesCoordinates();
//            for (Map.Entry<Coordinate, Integer> entry : mapOfLinesCoordinates.entrySet()) {
//                System.out.println(entry.getKey()+" : "+entry.getValue());
//            }

            List<PunktOOkreslonejWysokosci> punktOOkreslonejWysokosciDuplikatyNaLiniach = geometryInspactions.duplicatePointObcjetsOnLines_PunktOOkreslonejWysokosci(punktOOkreslonejWysokosciList, gmlImport.getMapOfLinesCoordinates(), 0);

            geometryInspactions.checkThreePointDeviationOnLine(przewodElektroenergetycznyList);
            geometryInspactions.checkThreePointDeviationOnLine(przewodWodociagowyList);

            geometryInspactions.duplicateLineVertex(przewodElektroenergetycznyList);
            geometryInspactions.duplicateAreaVertex(urzadzenieTechniczneZwiazaneZSieciaList);

            geometryInspactions.shortSpaceBetweenAreaVertex(urzadzenieTechniczneZwiazaneZSieciaList, 0.1);
            geometryInspactions.shortSpaceBetweenLineVertex(przewodElektroenergetycznyList, 0.1);

            geometryInspactions.autoCrossesLine(przewodElektroenergetycznyList);
            geometryInspactions.overlappingSegmentsLine(przewodElektroenergetycznyList);
            geometryInspactions.undershot(przewodElektroenergetycznyList, 0.01);

            geometryInspactions.excessiveSegmentation(przewodKanalizacyjnyList);

            geometryInspactions.continuityOfGeometryAndArea(przewodKanalizacyjnyList, urzadzenieTechniczneZwiazaneZSieciaList);
//            for (SlupIMaszt x: duplicatePointObcjets_slupimaszt) {
//                System.out.println("____________SlupIMaszt____________");
//                System.out.println(x.getIdIIP().getLokalnyId());
//                System.out.println(x.getIdIIP().getPrzestrzenNazw());
//                System.out.println(x.getGeometyType());
//                System.out.println(x.getGeometria().getPoint().getPoint().getCoordinate().toString());
//                System.out.println("zLatarnia: " + x.iszLatarnia());
//                System.out.println("Rodzaj: " + x.getRodzSlup().toString());
//            }
//
//            for (PunktOOkreslonejWysokosci x: punktOOkreslonejWysokosciDuplikatyNaLiniach) {
//                System.out.println("____________PunktOOkreslonejWysokosci____________");
//                System.out.println(x.getIdIIP().getLokalnyId());
//                System.out.println(x.getIdIIP().getPrzestrzenNazw());
//                System.out.println(x.getGeometyType());
//                System.out.println(x.getGeometria().getPoint().getCoordinate().toString());
//                System.out.println(x.getRzednaGory() + " : " + x.getRzednaDolu());
//            }
//
//            for (PunktOOkreslonejWysokosci x: duplicatePointObcjetsPunktOOkreslonejWysokosci) {
//                System.out.println("____________PunktOOkreslonejWysokosci____________");
//                System.out.println(x.getIdIIP().getLokalnyId());
//                System.out.println(x.getIdIIP().getPrzestrzenNazw());
//                System.out.println(x.getGeometyType());
//                System.out.println(x.getGeometria().getPoint().getCoordinate().toString());
//                System.out.println(x.getRzednaGory() + " : " + x.getRzednaDolu());
//            }
//
//            for (PrzewodWodociagowy x: duplicateLineObcjets) {
//                System.out.println("____________PRZEWOD_DUPLIKOWANY____________");
//                System.out.println(x.getIdIIP().getLokalnyId());
//                System.out.println(x.getIdIIP().getPrzestrzenNazw());
//                System.out.println(x.getGeometyType());
//                System.out.println(Arrays.stream(x.getGeometria().getLineString().getCoordinates()));
//                System.out.println(x.getGeometria().getLineString().getLength());
//            }



//            for (BudowlaPodziemna x: budowlaPodziemnaList) {
//                System.out.println("____________BUDOWALA_PODZIEMNA____________");
//                System.out.println(x.getIdIIP().getLokalnyId());
//                System.out.println(x.toString());
//            }
//
//            for (PrzewodTelekomunikacyjny x: przewodTelekomunikacyjnyList) {
//                System.out.println("____________PRZEWOD_TELE____________");
//                System.out.println(x.getIdIIP().getLokalnyId());
//                System.out.println(x.getIdIIP().getPrzestrzenNazw());
//                System.out.println(x.getGeometyType());
//                System.out.println(x.isWiazka());
//                System.out.println(Arrays.stream(x.getGeometria().getLineString().getCoordinates()));
//                System.out.println(x.getGeometria().getLineString().getLength());
//            }

//            for (ObiektKarto x: obiektKartoList) {
//                System.out.println("____________Obiekt Karto____________");
//                System.out.println(x.getObiektPrzedstawiany().getLokalnyId());
//                System.out.println(x.getEtykieta().getJustyfikacja());
//                System.out.println(x.getEtykieta().getKatObrotu());
//                System.out.println(x.getEtykieta().getGeometriaKarto().getPoint().getCoordinate().toString());
////                System.out.println(x.getEtykieta().getOdnosnik().getLineString().getLength());
//            }

            for (int i = 0; i < budowlaPodziemnaList.size(); i++) {
//                System.out.println(budowlaPodziemnaList.get(i));
                BudowlaPodziemna aa = budowlaPodziemnaList.get(i);
//                System.out.println("typp: "  + aa.getIdIIP().getLokalnyId() + " : " + aa.getIdIIP().getPrzestrzenNazw() + " : " + aa.getIdIIP().getWersjaId());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("koniec");
    }

    public <T extends ObiektGESUT> void printGenericList(List<T> objectList){
        for (T x: objectList) {
            System.out.println("LokalnyId: " +x.getIdIIP().getLokalnyId());
            System.out.println("PrzestrzenNazw: " + x.getIdIIP().getPrzestrzenNazw());
            System.out.println("GeometyType: " +x.getGeometyType());
            System.out.println("elelmenty towarzyszace: " + x.getElementyTowarzyszace().size());
        }
    }
}
