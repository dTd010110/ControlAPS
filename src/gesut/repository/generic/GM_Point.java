package gesut.repository.generic;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import java.util.Objects;

public class GM_Point {
    private Point point;

    public GM_Point(GeometryFromGml geometryFromGml) {
        this.point = new GeometryFactory().createPoint(geometryFromGml.getCoordinateList().getCoordinate(0));
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GM_Point gm_point = (GM_Point) o;
        return Objects.equals(point, gm_point.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
