package sample;

import gesut.gml.GmlImport;
import gesut.repository.dao.*;
import gesut.repository.dictionaries.OznaczenieZasobu;
import gesut.repository.generic.Identyfikator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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
        File file = new File("C:\\Users\\Asiasin\\Downloads\\GMLe_ZBYSZEK\\ObiektyGtestDuzy.gml");
        GmlImport gmlImport = new GmlImport();
        try {
            double startTime, endTime, duration1, duration2, duration3;

//            startTime = System.nanoTime();
//            System.out.println(startTime);
//            gmlImport.importGmlFile(file);
//            endTime = System.nanoTime();
//            duration1 = (endTime - startTime);
//            System.out.println(endTime);
//
//
//
//            startTime = System.nanoTime();
//            System.out.println(startTime);
//            gmlImport.importGmlFile(file,2);
//            endTime = System.nanoTime();
//            duration2 = (endTime - startTime);
//            System.out.println(endTime);


            startTime = System.nanoTime();
            System.out.println(startTime);
            gmlImport.importGmlFile(file,3,1);
            endTime = System.nanoTime();
            duration3 = (endTime - startTime);
            System.out.println(endTime);


            long nano = 1000000000;
//            System.out.println(duration1);
//            System.out.println(duration2);
            System.out.println(duration3);
            System.out.println(duration3/nano);

            List<BudowlaPodziemna> budowlaPodziemnaList = gmlImport.budowlaPodziemnaList;
            System.out.println("budowlaPodziemnaList : " + budowlaPodziemnaList.size());

            List<KorytarzPrzesylowy> korytarzPrzesylowyList = gmlImport.korytarzPrzesylowyList;
            System.out.println("korytarzPrzesylowyList : " + korytarzPrzesylowyList.size());

            List<ObiektKarto> obiektKartoList = gmlImport.obiektKartoList;
            System.out.println("obiektKartoList : " + obiektKartoList.size());

            List<ObudowaPrzewodu> obudowaPrzewoduList = gmlImport.obudowaPrzewoduList;
            System.out.println("obudowaPrzewoduList : " + obudowaPrzewoduList.size());

            List<PrzewodBenzynowy> przewodBenzynowyList = gmlImport.przewodBenzynowyList;
            System.out.println("przewodBenzynowyList : " + przewodBenzynowyList.size());

            List<PrzewodCieplowniczy> przewodCieplowniczyList = gmlImport.przewodCieplowniczyList;
            System.out.println("przewodCieplowniczyList : " + przewodCieplowniczyList.size());

            List<PrzewodElektroenergetyczny> przewodElektroenergetycznyList = gmlImport.przewodElektroenergetycznyList;
            System.out.println("przewodElektroenergetycznyList : " + przewodElektroenergetycznyList.size());

            List<PrzewodGazowy> przewodGazowyList = gmlImport.przewodGazowyList;
            System.out.println("przewodGazowyList : " + przewodGazowyList.size());

            List<PrzewodInny> przewodInnyList = gmlImport.przewodInnyList;
            System.out.println("przewodInnyList : " + przewodInnyList.size());

            List<PrzewodKanalizacyjny> przewodKanalizacyjnyList = gmlImport.przewodKanalizacyjnyList;
            System.out.println("przewodKanalizacyjnyList : " + przewodKanalizacyjnyList.size());

            List<PrzewodNaftowy> przewodNaftowyList = gmlImport.przewodNaftowyList;
            System.out.println("przewodNaftowyList : " + przewodNaftowyList.size());

            List<PrzewodNiezidentyfikowany> przewodNiezidentyfikowanyList = gmlImport.przewodNiezidentyfikowanyList;
            System.out.println("przewodNiezidentyfikowanyList : " + przewodNiezidentyfikowanyList.size());

            List<PrzewodTelekomunikacyjny> przewodTelekomunikacyjnyList = gmlImport.przewodTelekomunikacyjnyList;
            System.out.println("przewodTelekomunikacyjnyList : " + przewodTelekomunikacyjnyList.size());

            List<PrzewodWodociagowy> przewodWodociagowyList = gmlImport.przewodWodociagowyList;
            System.out.println("przewodWodociagowyList : " + przewodWodociagowyList.size());

            List<PunktOOkreslonejWysokosci> punktOOkreslonejWysokosciList = gmlImport.punktOOkreslonejWysokosciList;
            System.out.println("punktOOkreslonejWysokosciList : " + punktOOkreslonejWysokosciList.size());

            List<SlupIMaszt> slupIMasztList = gmlImport.slupIMasztList;
            System.out.println("slupIMasztList : " + slupIMasztList.size());

            List<UrzadzenieTechniczneZwiazaneZSiecia> urzadzenieTechniczneZwiazaneZSieciaList = gmlImport.urzadzenieTechniczneZwiazaneZSieciaList;
            System.out.println("urzadzenieTechniczneZwiazaneZSieciaList : " + urzadzenieTechniczneZwiazaneZSieciaList.size());

            HashMap<Identyfikator, Identyfikator> identyfikatorHashSet = gmlImport.identyfikatorHashSet;
            System.out.println("identyfikatorHashSet : " + identyfikatorHashSet.size());

            System.out.println(gmlImport.policz);

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
    }
}
