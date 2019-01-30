package gesut.repository.generic;

import gesut.gml.GmlGeometryTypes;

public class GM_Primitive {
  private GM_Surface surface;
  private GM_Curve curve;
  private GM_Point point;

    public GM_Primitive() {
    }

    public GM_Primitive(GeometryFromGml geometryFromGml) {
        if(geometryFromGml.getGeometyType() == GmlGeometryTypes.CIRCLE || geometryFromGml.getGeometyType() == GmlGeometryTypes.LINEARRING){
            surface = new GM_Surface(geometryFromGml);
        }
        if(geometryFromGml.getGeometyType() == GmlGeometryTypes.LINESTRING){
            curve = new GM_Curve(geometryFromGml);
        }
        if(geometryFromGml.getGeometyType() == GmlGeometryTypes.POINT){
            point = new GM_Point(geometryFromGml);
        }
    }

    public GM_Surface getSurface() {
        return surface;
    }

    public void setSurface(GM_Surface surface) {
        this.surface = surface;
    }

    public GM_Curve getCurve() {
        return curve;
    }

    public void setCurve(GM_Curve curve) {
        this.curve = curve;
    }

    public GM_Point getPoint() {
        return point;
    }

    public void setPoint(GM_Point point) {
        this.point = point;
    }
}
