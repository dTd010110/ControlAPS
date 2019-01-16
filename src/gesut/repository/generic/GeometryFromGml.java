package gesut.repository.generic;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateList;

import java.util.ArrayList;
import java.util.List;

public class GeometryFromGml extends Coordinate {
    private CoordinateList coordinateList = new CoordinateList();
    private String geometyType;
    private double radius;

    public CoordinateList getCoordinateList() {
        return coordinateList;
    }

    public void setCoordinateList(CoordinateList coordinateList) {
        this.coordinateList = coordinateList;
    }

    public String getGeometyType() {
        return geometyType;
    }

    public void setGeometyType(String geometyType) {
        this.geometyType = geometyType;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
