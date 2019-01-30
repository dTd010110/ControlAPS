package utilities;

import com.vividsolutions.jts.geom.Coordinate;

public class GeometricError {
    private Coordinate coordinate;
    private String type;
    private String description;


    public GeometricError() {
    }

    public GeometricError(Coordinate coordinate, String type, String description) {
        this.coordinate = coordinate;
        this.type = type;
        this.description = description;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
