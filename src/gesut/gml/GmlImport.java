package gesut.gml;

import com.vividsolutions.jts.geom.Coordinate;
import gesut.repository.dao.*;
import gesut.repository.dictionaries.*;
import gesut.repository.generic.*;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class GmlImport {

    public List<BudowlaPodziemna> budowlaPodziemnaList = new ArrayList<>();
    public List<KorytarzPrzesylowy> korytarzPrzesylowyList = new ArrayList<>();
    public List<ObiektKarto> obiektKartoList = new ArrayList<>();
    public List<ObudowaPrzewodu> obudowaPrzewoduList = new ArrayList<>();
    public List<PrzewodBenzynowy> przewodBenzynowyList = new ArrayList<>();
    public List<PrzewodCieplowniczy> przewodCieplowniczyList = new ArrayList<>();
    public List<PrzewodElektroenergetyczny> przewodElektroenergetycznyList = new ArrayList<>();
    public List<PrzewodGazowy> przewodGazowyList = new ArrayList<>();
    public List<PrzewodInny> przewodInnyList = new ArrayList<>();
    public List<PrzewodKanalizacyjny> przewodKanalizacyjnyList = new ArrayList<>();
    public List<PrzewodNaftowy> przewodNaftowyList = new ArrayList<>();
    public List<PrzewodNiezidentyfikowany> przewodNiezidentyfikowanyList = new ArrayList<>();
    public List<PrzewodTelekomunikacyjny> przewodTelekomunikacyjnyList = new ArrayList<>();
    public List<PrzewodWodociagowy> przewodWodociagowyList = new ArrayList<>();
    public List<PunktOOkreslonejWysokosci> punktOOkreslonejWysokosciList = new ArrayList<>();
    public List<SlupIMaszt> slupIMasztList = new ArrayList<>();
    public List<UrzadzenieTechniczneZwiazaneZSiecia> urzadzenieTechniczneZwiazaneZSieciaList = new ArrayList<>();

    public HashMap<Identyfikator, Identyfikator> identyfikatorHashSet = new HashMap<>();

    private StringBuilder stringBuilder = null;
    private boolean isObjectStart = false;
    private BudowlaPodziemna budowlaPodziemna;
    private KorytarzPrzesylowy korytarzPrzesylowy;
    private ObiektKarto obiektKarto;
    private ObudowaPrzewodu obudowaPrzewodu;
    private PrzewodBenzynowy przewodBenzynowy;
    private PrzewodCieplowniczy przewodCieplowniczy;
    private PrzewodElektroenergetyczny przewodElektroenergetyczny;
    private PrzewodGazowy przewodGazowy;
    private PrzewodInny przewodInny;
    private PrzewodKanalizacyjny przewodKanalizacyjny;
    private PrzewodNaftowy przewodNaftowy;
    private PrzewodNiezidentyfikowany przewodNiezidentyfikowany;
    private PrzewodTelekomunikacyjny przewodTelekomunikacyjny;
    private PrzewodWodociagowy przewodWodociagowy;
    private PunktOOkreslonejWysokosci punktOOkreslonejWysokosci;
    private SlupIMaszt slupIMaszt;
    private UrzadzenieTechniczneZwiazaneZSiecia urzadzenieTechniczneZwiazaneZSiecia;
    private boolean objectIsSet = false;
    private GmlObjectTypes objectType;

    private GestuTransferedObject transferedObject;

    private Identyfikator idIIP;
    private CyklZyciaInfo cyklZyciaInfo;
    private IdMaterialu idMaterialu;
    private DaneOsoby przedstawiciel;
    private DaneOsoby wladajacy;
    private Przewod przewod;
    private GM_Object gmObject;
    private KR_Etykieta etykieta;

    private GeometryFromGml geometryFromGmlClass;
    private List<CoordinateGml> coordinateList = new ArrayList<>(1);

    private boolean idIIPToSet = false;
    private boolean cyklZyciaToSet = false;

    public int policz=0;
    private boolean idMateialuToSet = false;
    private boolean przedstawicielToSet = false;
    private boolean wladajacyToSet = false;
    private boolean geometryTypeToSet = false;
    private boolean geometryToSet = false;
    private boolean spatialDataToSet = false;

    private double rzednaGory;
    private double rzednaDolu;
    private boolean isEtykieta = false;


//    public void importGmlFile(File file) throws IOException {
//        RandomAccessFile aFile = new RandomAccessFile
//                (file, "r");
//        FileChannel inChannel = aFile.getChannel();
//        ByteBuffer buffer = ByteBuffer.allocate(2048);
//        while(inChannel.read(buffer) > 0)
//        {
//            buffer.flip();
//            for (int i = 0; i < buffer.limit(); i++)
//            {
////                System.out.print((char) buffer.get());
//            }
//            buffer.clear(); // do something with the data and clear/compact it.
//        }
//        inChannel.close();
//        aFile.close();
//    }

//    public void importGmlFile(File file, int version) throws IOException {
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = br.readLine()) != null) {
////                System.out.println(line);
//                // process the line.
//            }
//        }
//    }

    public void importGmlFile(File file, int version, int x) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
//            stream.forEach(System.out::println);
            stream.forEach(this::separateGmlToObjects);
        }
    }

    private void createGesutObject(String gmlLine){
        transferedObject = new GestuTransferedObject();

        if(gmlLine.startsWith("<ges:GES_BudowlaPodziemna")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.BUDOWLAPODZIEMNA);
            isObjectStart = false;
        }else if(gmlLine.startsWith("<ges:GES_KorytarzPrzesylowy")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.KORYTARZPRZESYLOWY);
            isObjectStart = false;
        }else if(gmlLine.startsWith("<ges:GES_ObudowaPrzewodu")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.OBUDOWAPRZEWODU);
            isObjectStart = false;
        }else if(gmlLine.startsWith("<bt:KR_ObiektKarto")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.OBIEKTKARTO);
            isObjectStart = false;
        }else if(gmlLine.startsWith("<ges:GES_PrzewodBenzynowy")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.PRZEWODBENZYNOWY);
            isObjectStart = false;
        }else if(gmlLine.startsWith("<ges:GES_PrzewodCieplowniczy")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.PRZEWODCIEPLOWNICZY);
            isObjectStart = false;
        }else if(gmlLine.startsWith("<ges:GES_PrzewodElektroenergetyczny")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.PRZEWODELEKTROENERGETYCZNY);
            isObjectStart = false;
        }else if(gmlLine.startsWith("<ges:GES_PrzewodGazowy")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.PRZEWODGAZOWY);
            isObjectStart = false;
        }else if(gmlLine.startsWith("<ges:GES_PrzewodInny")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.PRZEWODINNY);
            isObjectStart = false;
        }else if(gmlLine.startsWith("<ges:GES_PrzewodKanalizacyjny")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.PRZEWODKANALIZACYJNY);
            isObjectStart = false;
        }else if(gmlLine.startsWith("<ges:GES_PrzewodNaftowy")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.PRZEWODNAFTOWY);
            isObjectStart = false;
        }else if(gmlLine.startsWith("<ges:GES_PrzewodNiezidentyfikowany")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.PRZEWODNIEZIDENTYFIKOWANY);
            isObjectStart = false;
        }else if(gmlLine.startsWith("<ges:GES_PrzewodTelekomunikacyjny")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.PRZEWODTELEKOMUNIKACYJNY);
            isObjectStart = false;
        }else if(gmlLine.startsWith("<ges:GES_PrzewodWodociagowy")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.PRZEWODWODOCIAGOWY);
            isObjectStart = false;
        }else if(gmlLine.startsWith("<ges:GES_PunktOOkreslonejWysokosci")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.PUNKTOOKRESLONEJWYSOKOSCI);
            isObjectStart = false;
        }else if(gmlLine.startsWith("<ges:GES_SlupIMaszt")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.SLUPIMASZT);
            isObjectStart = false;
        }else if(gmlLine.startsWith("<ges:GES_UrzadzenieTechniczneZwiazaneZSiecia")){
            objectIsSet = true;
            transferedObject.setTransferedObjectName(GmlObjectTypes.URZADZENIETECHNICZNEZWIAZANEZSIECIA);
            isObjectStart = false;
        }else{
            objectIsSet = false;
            transferedObject.setTransferedObjectName(GmlObjectTypes.BRAKOBIEKTU);
        }
    }

    private void separateGmlToObjects(String gmlLine){
       if(gmlLine.equals("<gml:featureMember>")){
           isObjectStart = true;
       }
        if(isObjectStart){
            createGesutObject(gmlLine);
        }
        if(transferedObject != null) {
            //ustawienieIDIIP
            if (gmlLine.equals("<bt:BT_Identyfikator>")) {
                idIIPToSet = true;
            }
            if (idIIPToSet) {
                setIdIIP(gmlLine);
            }

            //Cykl życia
            if (gmlLine.equals("<bt:BT_CyklZyciaInfo>")) {
                cyklZyciaToSet = true;
            }
            if (cyklZyciaToSet) {
                setCyklZycia(gmlLine);
            }

            //Id Materialu
            if (gmlLine.equals("<bt:BT_IdMaterialu>")) {
                idMateialuToSet = true;
            }
            if (idMateialuToSet) {
                setIdMaterialu(gmlLine);
            }

            //Przedstawiciel
            if (gmlLine.equals("<ges:przedstawiciel>")) {
                przedstawicielToSet = true;
                przedstawiciel = new DaneOsoby();
            }
            if (przedstawicielToSet) {
                setDaneOsoby(gmlLine, przedstawiciel);
                transferedObject.setPrzedstawiciel(przedstawiciel);
            }

            //Wladajacy
            if (gmlLine.equals("<ges:wladajacy>")) {
                wladajacyToSet = true;
                wladajacy = new DaneOsoby();
            }
            if (wladajacyToSet) {
                setDaneOsoby(gmlLine, wladajacy);
                transferedObject.setWladajacy(wladajacy);
            }

            if (transferedObject.getTransferedObjectName() != GmlObjectTypes.BRAKOBIEKTU && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {

                if (gmlLine.startsWith("<ges:zrodlo>")) {
                    transferedObject.setZrodlo(Zrodlo.valueOf(unmarshaller(gmlLine)));
                }
                if (gmlLine.startsWith("<ges:istnienie>")) {
                    transferedObject.setIstnienie(Istnienie.valueOf(unmarshaller(gmlLine)));
                }
                if (gmlLine.startsWith("<ges:eksploatacja>")) {
                    transferedObject.setEksploatacja(Eksploatacja.valueOf(unmarshaller(gmlLine)));
                }

                if (gmlLine.startsWith("<ges:dataPomiaru>")) {
                    transferedObject.setDataPomiaru(stringToLocalDate(unmarshaller(gmlLine)));
                }
                if (gmlLine.startsWith("<ges:rzednaGory>")) {
                    rzednaGory = stringToDouble(unmarshaller(gmlLine));
                }
                if (gmlLine.startsWith("<ges:rzednaDolu>")) {
                    rzednaGory = stringToDouble(unmarshaller(gmlLine));
                }
            }
            //GEOMETRIA
            if (gmlLine.equals("<ges:geometria>") || gmlLine.equals("<bt:geometriaKarto>")) {
                geometryTypeToSet = true;
                geometryFromGmlClass = new GeometryFromGml();
            }
            if (geometryTypeToSet) {
                setGeomType(gmlLine);
            }
            if (geometryToSet) {
                if(geometryFromGmlClass.getGeometyType() != null) {
                    setGeom(gmlLine);
                }
            }

            if(gmlLine.startsWith("<bt:KR_ObiektKarto") && transferedObject.getTransferedObjectName() == GmlObjectTypes.OBIEKTKARTO){
                spatialDataToSet = true;
            }

            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.BUDOWLAPODZIEMNA && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillBudlowlaPodziemna(gmlLine);
            }
            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.KORYTARZPRZESYLOWY && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillKorytarzPrzesylowy(gmlLine);
            }
            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.OBUDOWAPRZEWODU && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillObudowaPrzewodu(gmlLine);
            }
            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.PRZEWODBENZYNOWY && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillPrzewodBenzynowy(gmlLine);
            }
            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.PRZEWODCIEPLOWNICZY && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillPrzewodCieplowniczy(gmlLine);
            }
            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.PRZEWODELEKTROENERGETYCZNY && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillPrzewodElektroenergetyczny(gmlLine);
            }
            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.PRZEWODGAZOWY && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillPrzewodGazowy(gmlLine);
            }
            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.PRZEWODINNY && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillPrzewodInny(gmlLine);
            }
            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.PRZEWODKANALIZACYJNY && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillPrzewodKanalizacyjny(gmlLine);
            }
            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.PRZEWODNAFTOWY && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillPrzewodNaftowy(gmlLine);
            }
            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.PRZEWODNIEZIDENTYFIKOWANY && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillPrzewodNiezidentyfikowany(gmlLine);
            }
            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.PRZEWODTELEKOMUNIKACYJNY && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillPrzewodTelekomunikacyjny(gmlLine);
            }
            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.PRZEWODWODOCIAGOWY && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillPrzewodWodociagowy(gmlLine);
            }
            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.PUNKTOOKRESLONEJWYSOKOSCI && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillPunktOOkreslonejWysokosci(gmlLine);
            }
            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.SLUPIMASZT && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillSlupMaszt(gmlLine);
            }
            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.URZADZENIETECHNICZNEZWIAZANEZSIECIA && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillUrzadzenieTechniczneZwiazaneZSiecia(gmlLine);
            }
            if (transferedObject.getTransferedObjectName() == GmlObjectTypes.OBIEKTKARTO && spatialDataToSet && !gmlLine.contains(" xsi:nil=\"true\" nilReason=\"inapplicable\"") && !gmlLine.contains("xsi:nil=\"true\" nilReason=\"missing\"")) {
                fillObiektKarto(gmlLine);
            }

        }
       }

    private void fillObiektKarto(String gmlLine) {
        if(gmlLine.startsWith("<bt:KR_ObiektKarto")){
           obiektKarto = new ObiektKarto();
        }

        if(gmlLine.equals("<bt:KR_Etykieta>")) {
            isEtykieta = true;
            etykieta = new KR_Etykieta();
        }
        if(etykieta != null && isEtykieta){
            if(gmlLine.equals("</bt:geometriaKarto>")) {
                etykieta.setGeometriaKarto(new GM_Point(geometryFromGmlClass));
            }
            if(gmlLine.equals("</bt:odnosnik>")) {
                geometryTypeToSet = false;
                etykieta.setOdnosnik(new GM_Curve(geometryFromGmlClass));
            }
            if(gmlLine.startsWith("<bt:katObrotu>")){
                etykieta.setKatObrotu(stringToDouble(unmarshaller(gmlLine)));
            }
            if(gmlLine.startsWith("<bt:justyfikacja>")){
                etykieta.setJustyfikacja(stringToInt(unmarshaller(gmlLine)));
            }
            if(gmlLine.equals("<bt:odnosnik>")) {
                geometryTypeToSet = true;
                geometryFromGmlClass = new GeometryFromGml();
            }

            if(gmlLine.startsWith("</bt:KR_Etykieta>")){
                isEtykieta = false;
            }
        }
        if(obiektKarto != null && !isEtykieta){
            if(gmlLine.startsWith("<bt:katObrotu>")){
                obiektKarto.setKatObrotu(stringToDouble(unmarshaller(gmlLine)));
            }

            if(gmlLine.equals("</bt:KR_ObiektKarto>")) {
                if(identyfikatorHashSet.containsKey(idIIP)){
                    Identyfikator identyfikator = identyfikatorHashSet.get(idIIP);
                    obiektKarto.setObiektPrzedstawiany(identyfikator);
                }
                obiektKarto.setEtykieta(etykieta);
                obiektKartoList.add(obiektKarto);
                spatialDataToSet = false;
            }
        }
    }

    private void fillUrzadzenieTechniczneZwiazaneZSiecia(String gmlLine) {
        if(gmlLine.startsWith("</ges:geometria>")) {
            urzadzenieTechniczneZwiazaneZSiecia = new UrzadzenieTechniczneZwiazaneZSiecia(transferedObject.getIdIIP(), transferedObject.getStartObiekt(), transferedObject.getCyklZyciaObiektu(),
                    transferedObject.getKoniecObiekt(), transferedObject.getZrodlo(), transferedObject.getIstnienie(), transferedObject.getEksploatacja(),
                    transferedObject.getIdMaterialu(), transferedObject.getDataPomiaru(), transferedObject.getPrzedstawiciel(), transferedObject.getWladajacy(),
                    transferedObject.getIdBranzowy(), transferedObject.getIdUzgodnienia(), transferedObject.getDokument(), transferedObject.getInformacja());
        }
        if(gmlLine.startsWith("<ges:rodzSieci>")){
            urzadzenieTechniczneZwiazaneZSiecia.setRodzSieci(RodzSieci.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:rodzajUrzadz>")){
            urzadzenieTechniczneZwiazaneZSiecia.setRodzajUrzadz(RodzajUrzadz.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:przebieg>")){
            urzadzenieTechniczneZwiazaneZSiecia.setPrzebieg(Przebieg.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:ksztaltUrzadz>")){
            urzadzenieTechniczneZwiazaneZSiecia.setKsztaltUrzadz(KsztaltUrzadz.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:srednica>")) {
            urzadzenieTechniczneZwiazaneZSiecia.setSrednica(stringToInt(unmarshaller(gmlLine)));
        }else if(gmlLine.equals("<ges:srednica xsi:nil=\"true\" nilReason=\"template\"/>")){
            urzadzenieTechniczneZwiazaneZSiecia.setSrednica(-1);
        }
        if(gmlLine.startsWith("<ges:zasobnik>")){
            urzadzenieTechniczneZwiazaneZSiecia.setZasobnik(stringToBoolean(unmarshaller(gmlLine)));
        }
        if(gmlLine.equals("</ges:GES_UrzadzenieTechniczneZwiazaneZSiecia>")) {
            urzadzenieTechniczneZwiazaneZSiecia.setGeometria(new GM_Primitive(geometryFromGmlClass));
            urzadzenieTechniczneZwiazaneZSieciaList.add(urzadzenieTechniczneZwiazaneZSiecia);
            spatialDataToSet = false;
        }
    }

    //TODO sprawdzic parametry masztow
    private void fillSlupMaszt(String gmlLine) {
        if(gmlLine.equals("</ges:geometria>")) {
            slupIMaszt = new SlupIMaszt(transferedObject.getIdIIP(), transferedObject.getStartObiekt(), transferedObject.getCyklZyciaObiektu(),
                    transferedObject.getKoniecObiekt(), transferedObject.getZrodlo(), transferedObject.getIstnienie(), transferedObject.getEksploatacja(),
                    transferedObject.getIdMaterialu(), transferedObject.getDataPomiaru(), transferedObject.getPrzedstawiciel(), transferedObject.getWladajacy(),
                    transferedObject.getIdBranzowy(), transferedObject.getIdUzgodnienia(), transferedObject.getDokument(), transferedObject.getInformacja());
        }
        if(gmlLine.startsWith("<ges:rodzSieci>")){
            slupIMaszt.setRodzSieci(RodzSieci.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:rodzSlup>")){
            slupIMaszt.setRodzSlup(RodzSlup.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:zLatarnia>")){
            slupIMaszt.setzLatarnia(stringToBoolean(unmarshaller(gmlLine)));
        }
        if(gmlLine.equals("</ges:GES_SlupIMaszt>")) {
            slupIMaszt.setGeometria(new GM_Primitive(geometryFromGmlClass));
            slupIMasztList.add(slupIMaszt);
            spatialDataToSet = false;
        }
    }

    private void fillPunktOOkreslonejWysokosci(String gmlLine) {
        if(gmlLine.equals("</ges:geometria>")) {
            punktOOkreslonejWysokosci = new PunktOOkreslonejWysokosci(transferedObject.getIdIIP(), transferedObject.getStartObiekt(), transferedObject.getCyklZyciaObiektu(),
                    transferedObject.getKoniecObiekt(), transferedObject.getZrodlo(), transferedObject.getIstnienie(), transferedObject.getEksploatacja(),
                    transferedObject.getIdMaterialu(), transferedObject.getDataPomiaru(), transferedObject.getPrzedstawiciel(), transferedObject.getWladajacy(),
                    transferedObject.getIdBranzowy(), transferedObject.getIdUzgodnienia(), transferedObject.getDokument(), transferedObject.getInformacja());
        }

        if(gmlLine.equals("</ges:GES_PunktOOkreslonejWysokosci>")) {
            punktOOkreslonejWysokosci.setRzednaDolu(rzednaDolu);
            punktOOkreslonejWysokosci.setRzednaGory(rzednaGory);

            punktOOkreslonejWysokosci.setGeometria(new GM_Point(geometryFromGmlClass));
            punktOOkreslonejWysokosciList.add(punktOOkreslonejWysokosci);
            spatialDataToSet = false;
            rzednaGory = 0;
            rzednaDolu = 0;
        }
    }

    private void fillPrzewodWodociagowy(String gmlLine) {
        if(gmlLine.startsWith("</ges:geometria>")) {
            przewodWodociagowy = new PrzewodWodociagowy(transferedObject.getIdIIP(), transferedObject.getStartObiekt(), transferedObject.getCyklZyciaObiektu(),
                    transferedObject.getKoniecObiekt(), transferedObject.getZrodlo(), transferedObject.getIstnienie(), transferedObject.getEksploatacja(),
                    transferedObject.getIdMaterialu(), transferedObject.getDataPomiaru(), transferedObject.getPrzedstawiciel(), transferedObject.getWladajacy(),
                    transferedObject.getIdBranzowy(), transferedObject.getIdUzgodnienia(), transferedObject.getDokument(), transferedObject.getInformacja());
        }
        if(gmlLine.startsWith("<ges:funkcja>")){
            przewodWodociagowy.setFunkcja(Funkcja.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:przebieg>")){
            przewodWodociagowy.setPrzebieg(Przebieg.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:rodzajPrzewodu>")){
            przewodWodociagowy.setRodzPrzewodu(RodzPrzewodu.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:srednica>")) {
            przewodWodociagowy.setSrednica(stringToInt(unmarshaller(gmlLine)));
        }else if(gmlLine.equals("<ges:srednica xsi:nil=\"true\" nilReason=\"template\"/>")){
            przewodWodociagowy.setSrednica(-1);
        }
        if(gmlLine.startsWith("<ges:typKanal>")){
            przewodWodociagowy.setTypWodoc(TypWodoc.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.equals("</ges:GES_PrzewodWodociagowy>")) {
            przewodWodociagowy.setGeometria(new GM_Curve(geometryFromGmlClass));
            przewodWodociagowyList.add(przewodWodociagowy);
            spatialDataToSet = false;
        }
    }

    private void fillPrzewodTelekomunikacyjny(String gmlLine) {
        if(gmlLine.startsWith("</ges:geometria>")) {
            przewodTelekomunikacyjny = new PrzewodTelekomunikacyjny(transferedObject.getIdIIP(), transferedObject.getStartObiekt(), transferedObject.getCyklZyciaObiektu(),
                    transferedObject.getKoniecObiekt(), transferedObject.getZrodlo(), transferedObject.getIstnienie(), transferedObject.getEksploatacja(),
                    transferedObject.getIdMaterialu(), transferedObject.getDataPomiaru(), transferedObject.getPrzedstawiciel(), transferedObject.getWladajacy(),
                    transferedObject.getIdBranzowy(), transferedObject.getIdUzgodnienia(), transferedObject.getDokument(), transferedObject.getInformacja());
        }
        if(gmlLine.startsWith("<ges:funkcja>")){
            przewodTelekomunikacyjny.setFunkcja(Funkcja.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:przebieg>")){
            przewodTelekomunikacyjny.setPrzebieg(Przebieg.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:rodzajPrzewodu>")){
            przewodTelekomunikacyjny.setRodzPrzewodu(RodzPrzewodu.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:wiazka>")){
            przewodTelekomunikacyjny.setWiazka(stringToBoolean(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:liczbaPrzewodow>")){
            przewodTelekomunikacyjny.setLiczbaPrzewodow(stringToInt(unmarshaller(gmlLine)));
        }

        if(gmlLine.equals("</ges:GES_PrzewodTelekomunikacyjny>")) {
            przewodTelekomunikacyjny.setGeometria(new GM_Curve(geometryFromGmlClass));
            przewodTelekomunikacyjnyList.add(przewodTelekomunikacyjny);
            spatialDataToSet = false;
        }
    }

    private void fillPrzewodNiezidentyfikowany(String gmlLine) {
        if(gmlLine.startsWith("</ges:geometria>")) {
            przewodNiezidentyfikowany = new PrzewodNiezidentyfikowany(transferedObject.getIdIIP(), transferedObject.getStartObiekt(), transferedObject.getCyklZyciaObiektu(),
                    transferedObject.getKoniecObiekt(), transferedObject.getZrodlo(), transferedObject.getIstnienie(), transferedObject.getEksploatacja(),
                    transferedObject.getIdMaterialu(), transferedObject.getDataPomiaru(), transferedObject.getPrzedstawiciel(), transferedObject.getWladajacy(),
                    transferedObject.getIdBranzowy(), transferedObject.getIdUzgodnienia(), transferedObject.getDokument(), transferedObject.getInformacja());
        }
        if(gmlLine.startsWith("<ges:funkcja>")){
            przewodNiezidentyfikowany.setFunkcja(Funkcja.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:przebieg>")){
            przewodNiezidentyfikowany.setPrzebieg(Przebieg.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:rodzajPrzewodu>")){
            przewodNiezidentyfikowany.setRodzPrzewodu(RodzPrzewodu.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:srednica>")) {
            przewodNiezidentyfikowany.setSrednica(stringToInt(unmarshaller(gmlLine)));
        }

        if(gmlLine.equals("</ges:GES_PrzewodNiezidentyfikowany>")) {
            przewodNiezidentyfikowany.setGeometria(new GM_Curve(geometryFromGmlClass));
            przewodNiezidentyfikowanyList.add(przewodNiezidentyfikowany);
            spatialDataToSet = false;
        }
    }

    private void fillPrzewodNaftowy(String gmlLine) {
        if(gmlLine.startsWith("</ges:geometria>")) {
            przewodNaftowy = new PrzewodNaftowy(transferedObject.getIdIIP(), transferedObject.getStartObiekt(), transferedObject.getCyklZyciaObiektu(),
                    transferedObject.getKoniecObiekt(), transferedObject.getZrodlo(), transferedObject.getIstnienie(), transferedObject.getEksploatacja(),
                    transferedObject.getIdMaterialu(), transferedObject.getDataPomiaru(), transferedObject.getPrzedstawiciel(), transferedObject.getWladajacy(),
                    transferedObject.getIdBranzowy(), transferedObject.getIdUzgodnienia(), transferedObject.getDokument(), transferedObject.getInformacja());
        }
        if(gmlLine.startsWith("<ges:funkcja>")){
            przewodNaftowy.setFunkcja(Funkcja.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:przebieg>")){
            przewodNaftowy.setPrzebieg(Przebieg.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:rodzajPrzewodu>")){
            przewodNaftowy.setRodzPrzewodu(RodzPrzewodu.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:srednica>")) {
            przewodNaftowy.setSrednica(stringToInt(unmarshaller(gmlLine)));
        }

        if(gmlLine.equals("</ges:GES_PrzewodNaftowy>")) {
            przewodNaftowy.setGeometria(new GM_Curve(geometryFromGmlClass));
            przewodNaftowyList.add(przewodNaftowy);
            spatialDataToSet = false;
        }
    }

    private void fillPrzewodKanalizacyjny(String gmlLine) {
        if(gmlLine.startsWith("</ges:geometria>")) {
            przewodKanalizacyjny = new PrzewodKanalizacyjny(transferedObject.getIdIIP(), transferedObject.getStartObiekt(), transferedObject.getCyklZyciaObiektu(),
                    transferedObject.getKoniecObiekt(), transferedObject.getZrodlo(), transferedObject.getIstnienie(), transferedObject.getEksploatacja(),
                    transferedObject.getIdMaterialu(), transferedObject.getDataPomiaru(), transferedObject.getPrzedstawiciel(), transferedObject.getWladajacy(),
                    transferedObject.getIdBranzowy(), transferedObject.getIdUzgodnienia(), transferedObject.getDokument(), transferedObject.getInformacja());
        }

        if(gmlLine.startsWith("<ges:funkcja>")){
            przewodKanalizacyjny.setFunkcja(Funkcja.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:przebieg>")){
            przewodKanalizacyjny.setPrzebieg(Przebieg.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:rodzajPrzewodu>")){
            przewodKanalizacyjny.setRodzPrzewodu(RodzPrzewodu.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:srednica>")) {
            przewodKanalizacyjny.setSrednica(stringToInt(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:typKanal>")){
            przewodKanalizacyjny.setTypKanal(TypKanal.ogolnosplawny.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:tloczny>")){
            przewodKanalizacyjny.setTloczny(stringToBoolean(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:wymiarPoziomy>")) {
            przewodKanalizacyjny.setWymiarPoziomy(stringToInt(unmarshaller(gmlLine)));
        }else if(gmlLine.equals("<ges:wymiarPoziomy xsi:nil=\"true\" nilReason=\"unknown\"/>")){
            przewodKanalizacyjny.setWymiarPoziomy(-1);
        }
        if(gmlLine.startsWith("<ges:wymiarPionowy>")) {
            przewodKanalizacyjny.setWymiarPionowy(stringToInt(unmarshaller(gmlLine)));
        }else if(gmlLine.equals("<ges:wymiarPionowy xsi:nil=\"true\" nilReason=\"unknown\"/>")){
            przewodKanalizacyjny.setWymiarPionowy(-1);
        }
        if(gmlLine.equals("</ges:GES_PrzewodKanalizacyjny>")) {
            przewodKanalizacyjny.setGeometria(new GM_Curve(geometryFromGmlClass));
            przewodKanalizacyjnyList.add(przewodKanalizacyjny);
            spatialDataToSet = false;
        }
    }

    private void fillPrzewodInny(String gmlLine) {
        if(gmlLine.startsWith("</ges:geometria>")) {
            przewodInny = new PrzewodInny(transferedObject.getIdIIP(), transferedObject.getStartObiekt(), transferedObject.getCyklZyciaObiektu(),
                    transferedObject.getKoniecObiekt(), transferedObject.getZrodlo(), transferedObject.getIstnienie(), transferedObject.getEksploatacja(),
                    transferedObject.getIdMaterialu(), transferedObject.getDataPomiaru(), transferedObject.getPrzedstawiciel(), transferedObject.getWladajacy(),
                    transferedObject.getIdBranzowy(), transferedObject.getIdUzgodnienia(), transferedObject.getDokument(), transferedObject.getInformacja());
        }
        if(gmlLine.startsWith("<ges:funkcja>")){
            przewodInny.setFunkcja(Funkcja.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:przebieg>")){
            przewodInny.setPrzebieg(Przebieg.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:rodzajPrzewodu>")){
            przewodInny.setRodzPrzewodu(RodzPrzewodu.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:srednica>")) {
            przewodInny.setSrednica(stringToInt(unmarshaller(gmlLine)));
        }
        if(gmlLine.equals("</ges:GES_PrzewodInny>")) {
            przewodInny.setGeometria(new GM_Curve(geometryFromGmlClass));
            przewodInnyList.add(przewodInny);
            spatialDataToSet = false;
        }
    }

    private void fillPrzewodGazowy(String gmlLine) {
        if(gmlLine.startsWith("</ges:geometria>")) {
            przewodGazowy = new PrzewodGazowy(transferedObject.getIdIIP(), transferedObject.getStartObiekt(), transferedObject.getCyklZyciaObiektu(),
                    transferedObject.getKoniecObiekt(), transferedObject.getZrodlo(), transferedObject.getIstnienie(), transferedObject.getEksploatacja(),
                    transferedObject.getIdMaterialu(), transferedObject.getDataPomiaru(), transferedObject.getPrzedstawiciel(), transferedObject.getWladajacy(),
                    transferedObject.getIdBranzowy(), transferedObject.getIdUzgodnienia(), transferedObject.getDokument(), transferedObject.getInformacja());
        }
        if(gmlLine.startsWith("<ges:funkcja>")){
            przewodGazowy.setFunkcja(Funkcja.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:przebieg>")){
            przewodGazowy.setPrzebieg(Przebieg.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:rodzajPrzewodu>")){
            przewodGazowy.setRodzPrzewodu(RodzPrzewodu.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:srednica>")) {
            przewodGazowy.setSrednica(stringToInt(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:typGaz>")){
            przewodGazowy.setTypGaz(TypGaz.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.equals("</ges:GES_PrzewodGazowy>")) {
            przewodGazowy.setGeometria(new GM_Curve(geometryFromGmlClass));
            przewodGazowyList.add(przewodGazowy);
            spatialDataToSet = false;
        }
    }

    private void fillPrzewodElektroenergetyczny(String gmlLine) {
        if(gmlLine.startsWith("</ges:geometria>")) {
            przewodElektroenergetyczny= new PrzewodElektroenergetyczny(transferedObject.getIdIIP(), transferedObject.getStartObiekt(), transferedObject.getCyklZyciaObiektu(),
                    transferedObject.getKoniecObiekt(), transferedObject.getZrodlo(), transferedObject.getIstnienie(), transferedObject.getEksploatacja(),
                    transferedObject.getIdMaterialu(), transferedObject.getDataPomiaru(), transferedObject.getPrzedstawiciel(), transferedObject.getWladajacy(),
                    transferedObject.getIdBranzowy(), transferedObject.getIdUzgodnienia(), transferedObject.getDokument(), transferedObject.getInformacja());
        }
        if(gmlLine.startsWith("<ges:funkcja>")){
            przewodElektroenergetyczny.setFunkcja(Funkcja.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:przebieg>")){
            przewodElektroenergetyczny.setPrzebieg(Przebieg.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:rodzajPrzewodu>")){
            przewodElektroenergetyczny.setRodzPrzewodu(RodzPrzewodu.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:typElektr>")){
            przewodElektroenergetyczny.setTypElektr(TypElektr.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:oswietleniowy>")){
            przewodElektroenergetyczny.setOswietleniowy(stringToBoolean(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:wiazka>")){
            przewodElektroenergetyczny.setWiazka(stringToBoolean(unmarshaller(gmlLine)));
        }
        if(gmlLine.equals("</ges:GES_PrzewodElektroenergetyczny>")) {
            przewodElektroenergetyczny.setGeometria(new GM_Curve(geometryFromGmlClass));
            przewodElektroenergetycznyList.add(przewodElektroenergetyczny);
            spatialDataToSet = false;
        }
    }

    private void fillPrzewodCieplowniczy(String gmlLine) {
        if(gmlLine.startsWith("</ges:geometria>")) {
            przewodCieplowniczy = new PrzewodCieplowniczy(transferedObject.getIdIIP(), transferedObject.getStartObiekt(), transferedObject.getCyklZyciaObiektu(),
                    transferedObject.getKoniecObiekt(), transferedObject.getZrodlo(), transferedObject.getIstnienie(), transferedObject.getEksploatacja(),
                    transferedObject.getIdMaterialu(), transferedObject.getDataPomiaru(), transferedObject.getPrzedstawiciel(), transferedObject.getWladajacy(),
                    transferedObject.getIdBranzowy(), transferedObject.getIdUzgodnienia(), transferedObject.getDokument(), transferedObject.getInformacja());
        }
        if(gmlLine.startsWith("<ges:funkcja>")){
            przewodCieplowniczy.setFunkcja(Funkcja.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:przebieg>")){
            przewodCieplowniczy.setPrzebieg(Przebieg.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:rodzajPrzewodu>")){
            przewodCieplowniczy.setRodzPrzewodu(RodzPrzewodu.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:srednica>")) {
            przewodCieplowniczy.setSrednica(stringToInt(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:typCiep>")) {
            przewodCieplowniczy.setTypCiep(TypCiep.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:rodzCiep>")) {
            przewodCieplowniczy.setRodzCiep(RodzCiep.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.equals("</ges:GES_PrzewodCieplowniczy>")) {
            przewodCieplowniczy.setGeometria(new GM_Curve(geometryFromGmlClass));
            przewodCieplowniczyList.add(przewodCieplowniczy);
            spatialDataToSet = false;
        }
    }

    private void fillPrzewodBenzynowy(String gmlLine) {
        if(gmlLine.startsWith("</ges:geometria>")) {
            przewodBenzynowy = new PrzewodBenzynowy(transferedObject.getIdIIP(), transferedObject.getStartObiekt(), transferedObject.getCyklZyciaObiektu(),
                    transferedObject.getKoniecObiekt(), transferedObject.getZrodlo(), transferedObject.getIstnienie(), transferedObject.getEksploatacja(),
                    transferedObject.getIdMaterialu(), transferedObject.getDataPomiaru(), transferedObject.getPrzedstawiciel(), transferedObject.getWladajacy(),
                    transferedObject.getIdBranzowy(), transferedObject.getIdUzgodnienia(), transferedObject.getDokument(), transferedObject.getInformacja());
        }
        if(gmlLine.startsWith("<ges:funkcja>")){
            przewodBenzynowy.setFunkcja(Funkcja.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:przebieg>")){
            przewodBenzynowy.setPrzebieg(Przebieg.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:rodzajPrzewodu>")){
            przewodBenzynowy.setRodzPrzewodu(RodzPrzewodu.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:srednica>")) {
            przewodBenzynowy.setSrednica(stringToInt(unmarshaller(gmlLine)));
        }
        if(gmlLine.equals("</ges:GES_PrzewodBenzynowy>")) {
            przewodBenzynowy.setGeometria(new GM_Curve(geometryFromGmlClass));
            przewodBenzynowyList.add(przewodBenzynowy);
            spatialDataToSet = false;
        }
    }

    private void fillObudowaPrzewodu(String gmlLine) {
        if(gmlLine.startsWith("</ges:geometria>")) {
            obudowaPrzewodu = new ObudowaPrzewodu(transferedObject.getIdIIP(), transferedObject.getStartObiekt(), transferedObject.getCyklZyciaObiektu(),
                    transferedObject.getKoniecObiekt(), transferedObject.getZrodlo(), transferedObject.getIstnienie(), transferedObject.getEksploatacja(),
                    transferedObject.getIdMaterialu(), transferedObject.getDataPomiaru(), transferedObject.getPrzedstawiciel(), transferedObject.getWladajacy(),
                    transferedObject.getIdBranzowy(), transferedObject.getIdUzgodnienia(), transferedObject.getDokument(), transferedObject.getInformacja());
        }
        if(gmlLine.startsWith("<ges:srednica>")) {
            obudowaPrzewodu.setSrednica(stringToInt(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:obudowa>")) {
            obudowaPrzewodu.setObudowa(Obudowa.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:rodzajSieci>")) {
            obudowaPrzewodu.setRodzSieci(RodzSieci.valueOf(unmarshaller(gmlLine)));
        }
        if(gmlLine.startsWith("<ges:wymiarPionowy>")) {
            obudowaPrzewodu.setWymiarPionowy(stringToInt(unmarshaller(gmlLine)));
        }else if(gmlLine.equals("<ges:wymiarPionowy xsi:nil=\"true\" nilReason=\"unknown\"/>")){
            obudowaPrzewodu.setWymiarPionowy(-1);
        }
        if(gmlLine.startsWith("<ges:wymiarPoziomy>")) {
            obudowaPrzewodu.setWymiarPoziomy(stringToInt(unmarshaller(gmlLine)));
        }else if(gmlLine.equals("<ges:wymiarPoziomy xsi:nil=\"true\" nilReason=\"unknown\"/>")){
            obudowaPrzewodu.setWymiarPoziomy(-1);
        }

        if(gmlLine.equals("</ges:GES_ObudowaPrzewodu>")) {
            obudowaPrzewodu.setGeometria(new GM_Curve(geometryFromGmlClass));
            obudowaPrzewoduList.add(obudowaPrzewodu);
            spatialDataToSet = false;
        }
    }

    //TODO rodziajScieci
    private void fillKorytarzPrzesylowy(String gmlLine) {

        if(gmlLine.startsWith("</ges:geometria>")) {
            korytarzPrzesylowy = new KorytarzPrzesylowy(transferedObject.getIdIIP(), transferedObject.getStartObiekt(), transferedObject.getCyklZyciaObiektu(),
                    transferedObject.getKoniecObiekt(), transferedObject.getZrodlo(), transferedObject.getIstnienie(), transferedObject.getEksploatacja(),
                    transferedObject.getIdMaterialu(), transferedObject.getDataPomiaru(), transferedObject.getPrzedstawiciel(), transferedObject.getWladajacy(),
                    transferedObject.getIdBranzowy(), transferedObject.getIdUzgodnienia(), transferedObject.getDokument(), transferedObject.getInformacja());
        }

        if(gmlLine.startsWith("<ges:rodzSieci>")){

        }

        if(gmlLine.equals("</ges:GES_KorytarzPrzesylowy>")){
            korytarzPrzesylowy.setGeometria(new GM_Surface(geometryFromGmlClass));
            korytarzPrzesylowyList.add(korytarzPrzesylowy);
            spatialDataToSet = false;
        }
    }

    private void fillBudlowlaPodziemna(String gmlLine){
        if(gmlLine.startsWith("</ges:geometria>")) {
            budowlaPodziemna = new BudowlaPodziemna(transferedObject.getIdIIP(), transferedObject.getStartObiekt(), transferedObject.getCyklZyciaObiektu(),
                    transferedObject.getKoniecObiekt(), transferedObject.getZrodlo(), transferedObject.getIstnienie(), transferedObject.getEksploatacja(),
                    transferedObject.getIdMaterialu(), transferedObject.getDataPomiaru(), transferedObject.getPrzedstawiciel(), transferedObject.getWladajacy(),
                    transferedObject.getIdBranzowy(), transferedObject.getIdUzgodnienia(), transferedObject.getDokument(), transferedObject.getInformacja());
        }

           if(gmlLine.startsWith("<ges:rodzajBudowli>")){
               budowlaPodziemna.setRodzBudowli(RodzBud.valueOf(unmarshaller(gmlLine)));
           }
           if(gmlLine.startsWith("<ges:rodzajSieci>")){
               budowlaPodziemna.setRodzSieci(RodzSieci.valueOf(unmarshaller(gmlLine)));
           }
           if(gmlLine.equals("</ges:GES_BudowlaPodziemna>")){
               budowlaPodziemna.setGeometria(new GM_Surface(geometryFromGmlClass));
               budowlaPodziemnaList.add(budowlaPodziemna);
               spatialDataToSet = false;
           }
       }

       private void setGeom(String gmlLine){
           if(gmlLine.startsWith("<gml:pos>")){
               geometryFromGmlClass.getCoordinateList().add(createCoordinate(unmarshaller(gmlLine)));
           }
           if(geometryFromGmlClass.getGeometyType().equals("Circle") && gmlLine.startsWith("<gml:radius")){
               geometryFromGmlClass.setRadius(Double.parseDouble(unmarshaller(gmlLine)));
           }
           if(gmlLine.startsWith("</ges:geometria>")){
               transferedObject.setCoordinateList(geometryFromGmlClass.getCoordinateList());
               transferedObject.setGeometyType(geometryFromGmlClass.getGeometyType());

               if(geometryFromGmlClass.getGeometyType().equals("Circle")) {
                   transferedObject.setRadius(geometryFromGmlClass.getRadius());
               }
               geometryToSet = false;
               spatialDataToSet = true;
           }
       }

     private void setGeomType(String gmlLine){
         if(gmlLine.startsWith("<gml:Point")){
             geometryFromGmlClass.setGeometyType("Point");
             geometryTypeToSet = false;
             geometryToSet = true;
         }
         if(gmlLine.startsWith("<gml:LineStringSegment>")){
             geometryFromGmlClass.setGeometyType("LineString");
             geometryTypeToSet = false;
             geometryToSet = true;
         }
         if(gmlLine.startsWith("<gml:CircleByCenterPoint")){
             geometryFromGmlClass.setGeometyType("Circle");
             geometryTypeToSet = false;
             geometryToSet = true;
         }
         if(gmlLine.startsWith("<gml:LinearRing>")){
             geometryFromGmlClass.setGeometyType("LinearRing");
             geometryTypeToSet = false;
             geometryToSet = true;
         }

       }

    private void setDaneOsoby(String gmlLine, DaneOsoby daneOsoby) {
        if(gmlLine.startsWith("<ges:nazwaPelna>")){
            daneOsoby.setNazwaPelna(unmarshaller(gmlLine));
        }
        if(gmlLine.startsWith("<ges:nazwaSkrocona>")){
            daneOsoby.setNazwaSkrocona(unmarshaller(gmlLine));
        }
        if(gmlLine.startsWith("<ges:imieNazwisko>")){
            daneOsoby.setImieNazwisko(unmarshaller(gmlLine));
        }
        if(gmlLine.startsWith("<ges:e-mail>")){
            daneOsoby.setEmail(unmarshaller(gmlLine));
        }
        if(gmlLine.startsWith("<ges:telefon>")){
            daneOsoby.setTelefon(unmarshaller(gmlLine));
        }
        if(gmlLine.startsWith("<ges:adres>")){
            daneOsoby.setAdres(unmarshaller(gmlLine));
        }
        if(gmlLine.startsWith("<ges:informacja>")){
            daneOsoby.setInformacja(unmarshaller(gmlLine));
        }
        if(gmlLine.equals("</ges:GES_DaneOsoby>")){
            przedstawicielToSet = false;
            wladajacyToSet = false;
        }
    }

    private void setIdMaterialu(String gmlLine) {
        if (gmlLine.startsWith("<bt:pierwszyCzlon>")) {
            idMaterialu = new IdMaterialu();
            idMaterialu.setPierwszyCzlon(OznaczenieZasobu.valueOf(unmarshaller(gmlLine)));
            transferedObject.setIdMaterialu(idMaterialu);
        }
        if (gmlLine.startsWith("<bt:drugiCzlon>")) {
            idMaterialu.setDrugiCzlon(unmarshaller(gmlLine));
        }
        if (gmlLine.startsWith("<bt:trzeciCzlon>")) {
            idMaterialu.setTrzeciCzlon(Integer.parseInt(unmarshaller(gmlLine)));
        }
        if (gmlLine.startsWith("<bt:czwartyCzlon>")) {
            idMaterialu.setCzwartyCzlon(Integer.parseInt(unmarshaller(gmlLine)));
        }
    }

    private void setCyklZycia(String gmlLine) {
        if (gmlLine.startsWith("<ges:startObiekt>")) {
            transferedObject.setStartObiekt(stringToLocalDate(unmarshaller(gmlLine)));
        }
        if (gmlLine.startsWith("<bt:poczatekWersjiObiektu>")) {
            cyklZyciaInfo = new CyklZyciaInfo();
            cyklZyciaInfo.setPoczatekWersjiObiektu(stringToLocalDateTime(unmarshaller(gmlLine)));
            transferedObject.setCyklZyciaObiektu(cyklZyciaInfo);
        }
        if (gmlLine.startsWith("<bt:koniecWersjiObiektu>")) {
            cyklZyciaInfo.setKoniecWersjiObiektu(stringToLocalDateTime(unmarshaller(gmlLine))); // wykonać test
        }
        if(gmlLine.equals("</bt:BT_CyklZyciaInfo>")){
            cyklZyciaToSet = false;
        }
    }

    private void setIdIIP(String gmlLine) {
        if (gmlLine.startsWith("<bt:lokalnyId>")) {
            idIIP = new Identyfikator();
            idIIP.setLokalnyId(unmarshaller(gmlLine));
        }
        if (gmlLine.startsWith("<bt:przestrzenNazw>")) {
            this.idIIP.setPrzestrzenNazw(unmarshaller(gmlLine));
        }
        if (gmlLine.startsWith("<bt:wersjaId>")) {
            idIIP.setWersjaId(stringToLocalDateTime(unmarshaller(gmlLine)));

        }
        if(gmlLine.equals("</bt:BT_Identyfikator>")){
            identyfikatorHashSet.put(idIIP, idIIP);
            transferedObject.setIdIIP(idIIP);
            idIIPToSet=false;
        }
    }

    private String unmarshaller(String gmlLine){
        return gmlLine.substring(gmlLine.indexOf(">")+1, gmlLine.lastIndexOf("<"));
       }

       private LocalDateTime stringToLocalDateTime(String stringToConvert){
          return LocalDateTime.parse(stringToConvert);
       }

       private LocalDate stringToLocalDate(String stringToConvert){
           return LocalDate.parse(stringToConvert);
       }

    private int stringToInt(String stringToConvert){
        return Integer.parseInt(stringToConvert);
    }

    private boolean stringToBoolean(String unmarshaller) {
        return Boolean.parseBoolean(unmarshaller);
    }

    private double stringToDouble(String stringToConvert){
        return Double.parseDouble(stringToConvert);
    }

       private Coordinate createCoordinate(String unmarschallerGmlLine) {
        String[] splited = unmarschallerGmlLine.split("\\s");
           double x = Double.parseDouble(splited[0]);
           double y = Double.parseDouble(splited[1]);
           return  new Coordinate(x, y);
       }
}
