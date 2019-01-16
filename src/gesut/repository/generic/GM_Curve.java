package gesut.repository.generic;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;

import java.util.Objects;

public class GM_Curve {
    private LineString lineString;

    public GM_Curve(GeometryFromGml geometryFromGml) {
        this.lineString = new GeometryFactory().createLineString(geometryFromGml.getCoordinateList().toCoordinateArray());
    }

    public LineString getLineString() {
        return lineString;
    }

    public void setLineString(LineString lineString) {
        this.lineString = lineString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GM_Curve gm_curve = (GM_Curve) o;
        return Objects.equals(lineString, gm_curve.lineString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineString);
    }
}
