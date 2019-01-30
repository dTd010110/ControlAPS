package gesut.repository.generic;

import com.vividsolutions.jts.geom.*;
import gesut.gml.GmlGeometryTypes;

import java.util.Objects;

public class GM_Surface {
    private Polygon polygon;

    public GM_Surface(GeometryFromGml geometryFromGml) {
        if(geometryFromGml.getGeometyType() == GmlGeometryTypes.CIRCLE){
            Point point = new GeometryFactory().createPoint(geometryFromGml.getCoordinateList().getCoordinate(0));
            this.polygon =(Polygon) point.buffer(geometryFromGml.getRadius());
        }else if(geometryFromGml.getCoordinateList().toCoordinateArray().length > 1){
            this.polygon = new GeometryFactory().createPolygon(geometryFromGml.getCoordinateList().toCoordinateArray());
        }
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GM_Surface that = (GM_Surface) o;
        return Objects.equals(polygon, that.polygon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(polygon);
    }
}
