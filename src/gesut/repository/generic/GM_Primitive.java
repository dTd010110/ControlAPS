package gesut.repository.generic;

public class GM_Primitive {
  private GM_Surface surface;
  private GM_Curve curve;
  private GM_Point point;

    public GM_Primitive() {
    }

    public GM_Primitive(GeometryFromGml geometryFromGml) {
        if(geometryFromGml.getGeometyType().equals("Circle") || geometryFromGml.getGeometyType().equals("LinearRing")){
            surface = new GM_Surface(geometryFromGml);
        }
        if(geometryFromGml.getGeometyType().equals("LineString")){
            curve = new GM_Curve(geometryFromGml);
        }
        if(geometryFromGml.getGeometyType().equals("Point")){
            point = new GM_Point(geometryFromGml);
        }
    }
}
