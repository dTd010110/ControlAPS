package gesut.repository.generic;


public class GM_Object extends GeometryFromGml{
    private GM_Point point;
    private GM_Curve curve;
    private boolean odnosnik = false;

    public GM_Point getPoint() {
        return point;
    }

    public void setPoint(GM_Point point) {
        this.point = point;
    }

    public GM_Curve getCurve() {
        return curve;
    }

    public void setCurve(GM_Curve curve) {
        this.curve = curve;
    }

    public boolean isOdnosnik() {
        return odnosnik;
    }

    public void setOdnosnik(boolean odnosnik) {
        this.odnosnik = odnosnik;
    }
}
