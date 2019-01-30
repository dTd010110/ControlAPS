package gesut.repository.generic;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateList;
import gesut.gml.GmlGeometryTypes;

import java.util.ArrayList;
import java.util.List;

public class GeometryFromGml extends Coordinate {
    private CoordinateList coordinateList = new CoordinateList();
    private GmlGeometryTypes geometyType;
    private double radius;

    public CoordinateList getCoordinateList() {
        return coordinateList;
    }

    public void setCoordinateList(CoordinateList coordinateList) {
        this.coordinateList = coordinateList;
    }

    public GmlGeometryTypes getGeometyType() {
        return geometyType;
    }

    public void setGeometyType(GmlGeometryTypes geometyType) {
        this.geometyType = geometyType;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
