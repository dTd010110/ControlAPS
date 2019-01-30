package gesut.inspections;

import com.vividsolutions.jts.geom.*;
import gesut.gml.GmlGeometryTypes;
import gesut.repository.dao.*;
import gesut.repository.dictionaries.Funkcja;
import gesut.repository.dictionaries.RodzSieci;
import gesut.repository.dictionaries.RodzSlup;
import gesut.repository.dictionaries.RodzajUrzadz;
import gesut.repository.generic.ObiektGESUT;
import gesut.repository.generic.Przewod;
import utilities.GeometricError;
import utilities.Utilities;

import java.util.*;

public class GeometryInspactions {

    public  < T extends Przewod> List<T> duplicateLineObcjets(List<T> list, double tolerance){
        List<T> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            T firstToChack = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                if( i == j ){
                    continue;
                }
                T secndToChack = list.get(j);

                if(firstToChack.getGeometria().getLineString().equalsExact(secndToChack.getGeometria().getLineString(), tolerance)){
                    result.add(firstToChack);
                }
            }
        }
        return result;
    }

    public List<PunktOOkreslonejWysokosci> duplicatePointObcjets_PunktOOkreslonejWysokosci(List<PunktOOkreslonejWysokosci> list, double tolerance){
        List<PunktOOkreslonejWysokosci> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            PunktOOkreslonejWysokosci firstToChack = list.get(i);
            if(firstToChack.getRzednaDolu() != 0.0 && firstToChack.getRzednaGory() != 0.0) {
                for (int j = 0; j < list.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    PunktOOkreslonejWysokosci secndToChack = list.get(j);
                    if(secndToChack.getRzednaDolu() != 0.0 && secndToChack.getRzednaGory() != 0.0) {
                        if (firstToChack.getGeometria().getPoint().equalsExact(secndToChack.getGeometria().getPoint(), tolerance)) {
                            result.add(firstToChack);
                        }
                    }
                }
            }
        }
        return result;
    }


    public List<PunktOOkreslonejWysokosci> duplicatePointObcjetsOnLines_PunktOOkreslonejWysokosci(List<PunktOOkreslonejWysokosci> list, HashMap<Coordinate, Integer> startEndCoordMap, double tolerance){
        List<PunktOOkreslonejWysokosci> result = new ArrayList<>();
        HashMap<Coordinate, Integer> tmpMap = new HashMap<>(startEndCoordMap);

        for (int i = 0; i < list.size(); i++) {
            PunktOOkreslonejWysokosci pointToChack = list.get(i);
            if(pointToChack.getRzednaDolu() == 0.0 || pointToChack.getRzednaGory() == 0.0) {
                if(tmpMap.containsKey(pointToChack.getGeometria().getPoint().getCoordinate())){
                    Integer integer = tmpMap.get(pointToChack.getGeometria().getPoint().getCoordinate());
                    integer--;
                    tmpMap.put(pointToChack.getGeometria().getPoint().getCoordinate(), integer);
                    if(integer < 0){
                        result.add(pointToChack);
                        System.out.println("Powielony punkt: "+ pointToChack.getIdIIP().getLokalnyId() );
                    }
                }
            }
        }
        return result;
    }

    public List<SlupIMaszt> duplicatePointObcjets_SLUPIMASZT(List<SlupIMaszt> list, double tolerance){
        List<SlupIMaszt> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            SlupIMaszt firstToChack = list.get(i);

            for (int j = 0; j < list.size(); j++) {
                if( i == j ){
                    continue;
                }
                SlupIMaszt secndToChack = list.get(j);

                if(firstToChack.getGeometyType().equals(secndToChack.getGeometyType())) {
                    switch (firstToChack.getGeometyType()){
                        case POINT :
                            if (firstToChack.getGeometria().getPoint().getPoint().equalsExact(secndToChack.getGeometria().getPoint().getPoint(), tolerance)) {
                                addSlupIMasztToList(result, firstToChack, secndToChack);
                            }
                            break;
                        case LINESTRING :
                            if (firstToChack.getGeometria().getCurve().getLineString().equalsExact(secndToChack.getGeometria().getCurve().getLineString(), tolerance)) {
                                addSlupIMasztToList(result, firstToChack, secndToChack);
                            }
                            break;
                        case LINEARRING :
                        case CIRCLE :
                            if (firstToChack.getGeometria().getSurface().getPolygon().equalsExact(secndToChack.getGeometria().getSurface().getPolygon(), tolerance)) {
                                addSlupIMasztToList(result, firstToChack, secndToChack);
                            }
                            break;
                            default :
                                continue;
                    }
                }
            }
        }
        return result;
    }

    private void addSlupIMasztToList(List<SlupIMaszt> result, SlupIMaszt firstToChack, SlupIMaszt secndToChack) {
        if (!(firstToChack.getRodzSlup() == RodzSlup.slup && secndToChack.getRodzSlup() == RodzSlup.latarnia) && !(firstToChack.getRodzSlup() == RodzSlup.latarnia && secndToChack.getRodzSlup() == RodzSlup.slup)) {
            result.add(firstToChack);
        }
    }

    public <T extends Przewod> HashMap<GeometricError,T> checkThreePointDeviationOnLine(List<T> list){
        HashMap<GeometricError,T> result = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            T lineToChack = list.get(i);
            Coordinate[] coordinates = lineToChack.getGeometria().getLineString().getCoordinates();
            checkDeviation(result, coordinates, lineToChack);
        }
        System.out.println(result.size());
        return result;
    }

    public <T extends ObiektGESUT> HashMap<GeometricError,T> checkThreePointDeviationOnArea(List<T> list){
        HashMap<GeometricError,T> result = new HashMap<>();
        Coordinate[] coordinates = null;
        for (int i = 0; i < list.size(); i++) {
            T lineToChack = list.get(i);
            coordinates = getCoordinatesFromAreaObjects(coordinates, lineToChack, true);

            checkDeviation(result, coordinates, lineToChack);

        }
        return result;
    }

    private <T extends ObiektGESUT> Coordinate[] getCoordinatesFromAreaObjects(Coordinate[] coordinates, T lineToChack, boolean all) {
        if (lineToChack instanceof UrzadzenieTechniczneZwiazaneZSiecia) {
            UrzadzenieTechniczneZwiazaneZSiecia urzadzenie = (UrzadzenieTechniczneZwiazaneZSiecia) lineToChack;
            if (urzadzenie.getGeometyType() == GmlGeometryTypes.LINESTRING) {
                coordinates = urzadzenie.getGeometria().getCurve().getLineString().getCoordinates();
            }
            if (urzadzenie.getGeometyType() == GmlGeometryTypes.LINEARRING) {
                    coordinates = urzadzenie.getGeometria().getSurface().getPolygon().getCoordinates();
                if(!all) {
                    coordinates = Arrays.copyOf(coordinates, coordinates.length - 1);
                }
            }
        }
        if (lineToChack instanceof BudowlaPodziemna) {
            BudowlaPodziemna budowlaPodziemna = (BudowlaPodziemna) lineToChack;
            if (budowlaPodziemna.getGeometyType() == GmlGeometryTypes.LINEARRING) {
                coordinates = budowlaPodziemna.getGeometria().getPolygon().getCoordinates();
                if(!all) {
                    coordinates = Arrays.copyOf(coordinates, coordinates.length - 1);
                }
            }
        }
        if (lineToChack instanceof KorytarzPrzesylowy) {
            KorytarzPrzesylowy korytarzPrzesylowy = (KorytarzPrzesylowy) lineToChack;
            if (korytarzPrzesylowy.getGeometyType() == GmlGeometryTypes.LINEARRING) {
                coordinates = korytarzPrzesylowy.getGeometria().getPolygon().getCoordinates();
                if(!all) {
                    coordinates = Arrays.copyOf(coordinates, coordinates.length - 1);
                }
            }
        }
        return coordinates;
    }

    private <T extends ObiektGESUT> void checkDeviation(HashMap<GeometricError, T> result, Coordinate[] coordinates, T lineToChack) {
        for (int j = 0; j < coordinates.length; j++) {
            if(j+2 >= coordinates.length){
                break;
            }
            Coordinate c1 = coordinates[j];
            Coordinate c2 = coordinates[j+1];
            Coordinate c3 = coordinates[j+2];
            double angle = Utilities.calculateAngle3(c1.x, c1.y, c2.x, c2.y, c3.x, c3.y);

            if(angle <2){
                System.out.println("KAT: " + angle + " coord: " + c2.x + ", " + c2.y);

                result.put(new GeometricError(c1,"geometryczny","kat= " + angle),lineToChack);
            }
        }
    }

    public <T extends Przewod> HashMap<GeometricError,T> duplicateLineVertex(List<T> list){
        HashMap<GeometricError,T> result = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            T lineToChack = list.get(i);
            Coordinate[] coordinates = lineToChack.getGeometria().getLineString().getCoordinates();
            checkDuplicateVertex(result, coordinates, lineToChack);
        }
        return result;
    }

    public <T extends ObiektGESUT> HashMap<GeometricError,T> duplicateAreaVertex(List<T> list){
        HashMap<GeometricError,T> result = new HashMap<>();
        Coordinate[] coordinates = null;
        for (int i = 0; i < list.size(); i++) {
            T lineToChack = list.get(i);
            coordinates = getCoordinatesFromAreaObjects(coordinates, lineToChack, false);

            checkDuplicateVertex(result, coordinates, lineToChack);
        }
        return result;
    }

    private <T extends ObiektGESUT> void checkDuplicateVertex(HashMap<GeometricError, T> result, Coordinate[] coordinates, T lineToChack) {
        if(coordinates != null) {
            for (int j = 0; j < coordinates.length; j++) {
                Coordinate c1 = coordinates[j];
                for (int k = 0; k < coordinates.length; k++) {
                    if (j == k) {
                        continue;
                    }
                    Coordinate c2 = coordinates[k];
                    if (c1.equals(c2)) {
                        System.out.println("duplikat wsp1: " + c1.x + " : " + c1.y + "   wsp2 "+ c1.x + " : " + c1.y);
                        result.put(new GeometricError(c1, "geometryczny", "Duplikujące się werteksy: " + c1.x + " : " + c1.y), lineToChack);
                    }
                }
            }
        }
    }

    public <T extends Przewod> HashMap<GeometricError,T> shortSpaceBetweenLineVertex(List<T> list, double tolerance){
        HashMap<GeometricError,T> result = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            T lineToChack = list.get(i);
            Coordinate[] coordinates = lineToChack.getGeometria().getLineString().getCoordinates();
            spaceBetweenCoord(tolerance, result, coordinates, lineToChack);
        }
        return result;
    }

    public <T extends ObiektGESUT> HashMap<GeometricError,T> shortSpaceBetweenAreaVertex(List<T> list, double tolerance){
        HashMap<GeometricError,T> result = new HashMap<>();
        Coordinate[] coordinates = null;
        for (int i = 0; i < list.size(); i++) {
            T lineToChack = list.get(i);
            coordinates = getCoordinatesFromAreaObjects(coordinates, lineToChack, false);
            if(coordinates != null) {
                spaceBetweenCoord(tolerance, result, coordinates, lineToChack);
            }
        }
        return result;
    }

    private <T extends ObiektGESUT> void spaceBetweenCoord(double tolerance, HashMap<GeometricError, T> result, Coordinate[] coordinates, T lineToChack) {
        for (int j = 0; j < coordinates.length; j++) {
            if(j+1 < coordinates.length) {
                double length = Utilities.calculateLengthFromCoordinates(coordinates[j], coordinates[j + 1]);
                if(length < tolerance){
                    result.put(new GeometricError(coordinates[j], "geometryczny", "Odległość między dwoma sąsiednimi werteksami jest mniejsza niż : "+ tolerance), lineToChack);
                    result.put(new GeometricError(coordinates[j+1], "geometryczny", "Odległość między dwoma sąsiednimi werteksami jest mniejsza niż : "+ tolerance), lineToChack);
                }
            }
        }
    }

    public <T extends Przewod> HashMap<GeometricError,T> autoCrossesLine(List<T> list){
        HashMap<GeometricError,T> result = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            T lineToChack = list.get(i);
            CoordinateList coordinateList = new CoordinateList();
            Coordinate[] lineCoordinates = lineToChack.getGeometria().getLineString().getCoordinates();
            for (int j = 0; j < lineCoordinates.length; j++) {
                if( j+1 == lineCoordinates.length){
                    continue;
                }
                Coordinate c1 = lineCoordinates[j];
                Coordinate c2 = lineCoordinates[j+1];
                LineString lineStringToChack = getOneLineFromLineString(coordinateList, c1, c2);
                if(lineToChack.getGeometria().getLineString().crosses(lineStringToChack)){
                    System.out.println("Samoprzeciecia " + lineToChack.getIdIIP().getLokalnyId());
                    result.put(new GeometricError(c1, "geometryczny", "Samoprzecięcie" ), lineToChack);
                }
            }
        }
        return result;
    }

    public <T extends Przewod> HashMap<GeometricError,T> overlappingSegmentsLine(List<T> list){
        HashMap<GeometricError,T> result = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            T lineToChack = list.get(i);
            CoordinateList coordinateList = new CoordinateList();
            Coordinate[] lineCoordinates = lineToChack.getGeometria().getLineString().getCoordinates();
            for (int j = 0; j < lineCoordinates.length; j++) {
                if( j+1 == lineCoordinates.length){
                    continue;
                }
                LineString lineStringToChack = getOneLineFromLineString(coordinateList, lineCoordinates[j], lineCoordinates[j + 1]);
                if(lineToChack.getGeometria().getLineString().overlaps(lineStringToChack)){
                    System.out.println("nakladanie " + lineToChack.getIdIIP().getLokalnyId());
                    result.put(new GeometricError(lineCoordinates[j], "geometryczny", "Nakładanie się segmentów tej samej linii."), lineToChack);
                }
            }
        }
        return result;
    }

    private LineString getOneLineFromLineString(CoordinateList coordinateList, Coordinate lineCoordinate, Coordinate lineCoordinate2) {
        coordinateList.add(lineCoordinate);
        coordinateList.add(lineCoordinate2);
        return new GeometryFactory().createLineString(coordinateList.toCoordinateArray());
    }

    public <T extends Przewod> HashMap<GeometricError,T> undershot(List<T> list, double tolerance){
        HashMap<GeometricError,T> result = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            T lineToChack = list.get(i);
            LineString lineString = lineToChack.getGeometria().getLineString();
            for (int j = 0; j < list.size(); j++) {
                if(i==j){
                    continue;
                }
                T secondLineToChack = list.get(j);
                if(lineToChack.equals(secondLineToChack)) {
                    Point startPoint = secondLineToChack.getGeometria().getLineString().getStartPoint();
                    Point endPoint = secondLineToChack.getGeometria().getLineString().getEndPoint();

                    Geometry buffer = lineToChack.getGeometria().getLineString().buffer(tolerance);
                    checkLineAndPointInBuffer(result, lineToChack, lineString, startPoint, endPoint, buffer.contains(startPoint), startPoint.getCoordinate());
                    checkLineAndPointInBuffer(result, lineToChack, lineString, startPoint, endPoint, buffer.contains(endPoint), endPoint.getCoordinate());
                }
            }
        }
        return result;
    }

    private <T extends Przewod> void checkLineAndPointInBuffer(HashMap<GeometricError, T> result, T lineToChack, LineString lineString, Point startPoint, Point endPoint, boolean contains, Coordinate coordinate) {
        if (!lineString.intersects(startPoint) && !lineString.intersects(endPoint) && contains) {
            System.out.println("Niedociągnięcie połączenia linii: " + lineToChack.getIdIIP().getLokalnyId());
            result.put(new GeometricError(coordinate, "geometryczny", "Niedociągnięcie połączenia linii"), lineToChack);
        }
    }

    public <T extends Przewod> HashMap<GeometricError,T> lineFault(List<T> list, double tolerance){
        HashMap<GeometricError,T> result = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            T lineToChack = list.get(i);
            LineString lineString = lineToChack.getGeometria().getLineString();
            if(lineString.getLength() < tolerance){
                result.put(new GeometricError(lineString.getCentroid().getCoordinate(), "geometryczny", "Uskok linii"), lineToChack);
            }
        }
        return result;
    }

    public <T extends Przewod> HashMap<GeometricError,T> excessiveSegmentation (List<T> list){
        HashMap<GeometricError,T> result = new HashMap<>();
        int countStartLineTouch = 0;
        int countEndLineTouch = 0;
        for (int i = 0; i < list.size(); i++) {
            T lineToChack = list.get(i);
            LineString firstLineString = lineToChack.getGeometria().getLineString();
            Point firstLineStringStartPoint = firstLineString.getStartPoint();
            Point firstLineStringEndPoint = firstLineString.getEndPoint();
            for (int j = 0; j < list.size(); j++) {
                if(i==j){
                    continue;
                }
                T secondLineToChack = list.get(j);
                LineString secondLineString = secondLineToChack.getGeometria().getLineString();
                Point secondLineStringStartPoint = secondLineString.getStartPoint();
                Point secondLineStringEndPoint = secondLineString.getEndPoint();
                if(!lineToChack.equals(secondLineToChack) && (lineToChack.getFunkcja() == Funkcja.przylacze) && secondLineToChack.getFunkcja() == Funkcja.rozdzielczy){
                    if(firstLineStringStartPoint.equals(secondLineStringStartPoint) || firstLineStringStartPoint.equals(secondLineStringEndPoint)){
                        countStartLineTouch++;
                    }
                    if(firstLineStringEndPoint.equals(secondLineStringStartPoint) || firstLineStringEndPoint.equals(secondLineStringEndPoint)){
                        countEndLineTouch++;
                    }
                }
                if(!lineToChack.equals(secondLineToChack) && (lineToChack.getFunkcja() == Funkcja.przylacze || lineToChack.getFunkcja() == Funkcja.rozdzielczy) && secondLineToChack.getFunkcja() == Funkcja.przesylowy){
                    if(firstLineStringStartPoint.equals(secondLineStringStartPoint) || firstLineStringStartPoint.equals(secondLineStringEndPoint)){
                        countStartLineTouch++;
                    }
                    if(firstLineStringEndPoint.equals(secondLineStringStartPoint) || firstLineStringEndPoint.equals(secondLineStringEndPoint)){
                        countEndLineTouch++;
                    }
                }
                if(lineToChack.getFunkcja() == secondLineToChack.getFunkcja() && !lineToChack.equals(secondLineToChack)){
                    if(firstLineStringStartPoint.equals(secondLineStringStartPoint) || firstLineStringStartPoint.equals(secondLineStringEndPoint)){
                        countStartLineTouch++;
                    }
                    if(firstLineStringEndPoint.equals(secondLineStringStartPoint) || firstLineStringEndPoint.equals(secondLineStringEndPoint)){
                        countEndLineTouch++;
                    }
                }
                if(lineToChack.equals(secondLineToChack)) {
                    if(firstLineStringStartPoint.equals(secondLineStringStartPoint) || firstLineStringStartPoint.equals(secondLineStringEndPoint)){
                        countStartLineTouch++;
                    }
                    if(firstLineStringEndPoint.equals(secondLineStringStartPoint) || firstLineStringEndPoint.equals(secondLineStringEndPoint)){
                        countEndLineTouch++;
                    }
                }
            }
            if(countStartLineTouch == 1){
                System.out.println("segmentacja " + lineToChack.getIdIIP().getLokalnyId() + " point " + firstLineStringStartPoint.getCentroid().getCoordinate().toString());
                result.put(new GeometricError(firstLineStringStartPoint.getCentroid().getCoordinate(), "geometryczny", "Nadmierna segmentacja"), lineToChack);
            }
            if(countEndLineTouch == 1){
                System.out.println("segmentacja " + lineToChack.getIdIIP().getLokalnyId() + " point " + firstLineStringEndPoint.getCentroid().getCoordinate().toString());
                result.put(new GeometricError(firstLineStringEndPoint.getCentroid().getCoordinate(), "geometryczny", "Nadmierna segmentacja"), lineToChack);
            }
            countStartLineTouch = 0;
            countEndLineTouch = 0;
        }
        return result;
    }

    public <T extends UrzadzenieTechniczneZwiazaneZSiecia> HashMap<GeometricError,T> adjacency (List<T> list){
        HashMap<GeometricError,T> result = new HashMap<>();


        return result;
    }

    public <T extends Przewod> HashMap<GeometricError,T> continuityOfGeometryAndArea (List<T> list, List<UrzadzenieTechniczneZwiazaneZSiecia> urzadzenieTechniczneZwiazaneZSieciaList){
        HashMap<GeometricError,T> result = new HashMap<>();
        T test = list.get(0);
        RodzSieci rodzSieci = detectRodzajSieci(test);
        System.out.println("START ciagloscGeometrii: ");
        for (int j = 0; j < urzadzenieTechniczneZwiazaneZSieciaList.size(); j++) {
            UrzadzenieTechniczneZwiazaneZSiecia urzadzenie = urzadzenieTechniczneZwiazaneZSieciaList.get(j);

            if(rodzSieci == urzadzenie.getRodzSieci() && (urzadzenie.getGeometyType() == GmlGeometryTypes.LINEARRING || urzadzenie.getGeometyType() == GmlGeometryTypes.CIRCLE)
                    && urzadzenie.getRodzajUrzadz() != RodzajUrzadz.stacjaTransformatorowa && urzadzenie.getRodzajUrzadz() != RodzajUrzadz.hydrofornia) {

                Polygon polygon = urzadzenie.getGeometria().getSurface().getPolygon();
                Geometry boundary = polygon.getBoundary();
                List<T> listOfThreatsLine = new ArrayList<>();
                List<Coordinate[]> listOfThreatsCoordinates = new ArrayList<>();

                for (int i = 0; i < list.size(); i++) {
                    T lineToCheck = list.get(i);
                    LineString lineString = lineToCheck.getGeometria().getLineString();
                    if(polygon.intersects(lineString)){
                        Geometry intersection = polygon.intersection(lineString);
                        Coordinate[] intersectionCoordinates = intersection.getCoordinates();
                        listOfThreatsLine.add(lineToCheck);
                        listOfThreatsCoordinates.add(intersectionCoordinates);
                        System.out.println("wydruk ciagloscGeometrii: " + lineToCheck.getIdIIP().getLokalnyId() + " StartPoint: " + lineString.getStartPoint().getCoordinate().toString() + " ENDPoint: " + lineString.getEndPoint().getCoordinate().toString() );
                        System.out.println(Arrays.toString(intersectionCoordinates));
                    }
                }
                if(listOfThreatsLine.size() == 1){
                    for (int i = 0; i < listOfThreatsCoordinates.size(); i++) {
                        T line = listOfThreatsLine.get(i);
                        Coordinate[] intersectionCoordinates = getCoordinatesBoundaryFromLineAndArea(boundary, listOfThreatsCoordinates, i);

                        if(intersectionCoordinates.length != 2){
                            System.out.println("ciągłości" + polygon.getCentroid().getCoordinate() + " idPrzewodu: " + line.getIdIIP().getLokalnyId());
                            result.put(new GeometricError(polygon.getCentroid().getCoordinate(), "geometryczny", "Obiekt nie zachowuje ciągłości topologicznej przy przejściu przez urządzenie techniczne związane z siecią"), line);
                        }
                    }
                }

                if(listOfThreatsLine.size() > 1){
                    for (int i = 0; i < listOfThreatsCoordinates.size(); i++) {
                        T line1 = listOfThreatsLine.get(i);
                        Coordinate[] intersectionCoordinates = getCoordinatesBoundaryFromLineAndArea(boundary, listOfThreatsCoordinates, i);
                        System.out.println(intersectionCoordinates.length);
                        if(intersectionCoordinates.length == 1) {
                            for (int k = 0; k < listOfThreatsCoordinates.size(); k++) {
                                if (i == k) {
                                    continue;
                                }
                                T line2 = listOfThreatsLine.get(k);
                                Coordinate[] coordinates2 = getCoordinatesBoundaryFromLineAndArea(boundary, listOfThreatsCoordinates, k);
                                if(coordinates2.length > 0 && !line1.getGeometria().getLineString().intersects(line2.getGeometria().getLineString())){
                                    System.out.println("ciągłości2" + polygon.getCentroid().getCoordinate() + " idPrzewodu: " + line1.getIdIIP().getLokalnyId());
                                    result.put(new GeometricError(polygon.getCentroid().getCoordinate(), "geometryczny", "Obiekt nie zachowuje ciągłości topologicznej przy przejściu przez urządzenie techniczne związane z siecią"), line1);
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private Coordinate[] getCoordinatesBoundaryFromLineAndArea(Geometry boundary, List<Coordinate[]> listOfThreatsCoordinates, int i) {
        Coordinate[] coordinates = listOfThreatsCoordinates.get(i);
        LineString lineFromCoordinates = new GeometryFactory().createLineString(coordinates);
        LineString l = new GeometryFactory().createLineString(boundary.getCoordinates());
        Geometry intersection1 = l.intersection(lineFromCoordinates);
        Geometry intersection = boundary.intersection(lineFromCoordinates);
        return intersection1.getCoordinates();
    }

    private <T extends Przewod> RodzSieci detectRodzajSieci(T t) {
        if(t instanceof PrzewodKanalizacyjny){
            return RodzSieci.kanalizacyjny;
        }
        if(t instanceof PrzewodTelekomunikacyjny){
            return RodzSieci.telekomunikacyjny;
        }
        if(t instanceof PrzewodWodociagowy){
            return RodzSieci.wodociagowy;
        }
        if(t instanceof PrzewodElektroenergetyczny){
            return RodzSieci.elektroenergetyczny;
        }
        if(t instanceof PrzewodGazowy){
            return RodzSieci.gazowy;
        }
        if(t instanceof PrzewodCieplowniczy){
            return RodzSieci.cieplowniczy;
        }
        if(t instanceof PrzewodInny){
            return RodzSieci.inna;
        }
        if(t instanceof PrzewodBenzynowy){
            return RodzSieci.benzynowy;
        }
        if(t instanceof PrzewodNaftowy){
            return RodzSieci.naftowy;
        }
        if(t instanceof PrzewodNiezidentyfikowany){
            return RodzSieci.niezidentyfikowany;
        }

        return RodzSieci.inna;
    }
}
