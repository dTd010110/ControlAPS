package gesut.repository.dao;

import gesut.repository.generic.GM_Point;
import gesut.repository.generic.ObiektGESUT;

public class PunktOOkreslonejWysokosci extends ObiektGESUT {
    private GM_Point geometria;
    private float rzednaGory;
    private float rzednaDolu;

    public GM_Point getGeometria() {
        return geometria;
    }

    public void setGeometria(GM_Point geometria) {
        this.geometria = geometria;
    }

    public float getRzednaGory() {
        return rzednaGory;
    }

    public void setRzednaGory(float rzednaGory) {
        this.rzednaGory = rzednaGory;
    }

    public float getRzednaDolu() {
        return rzednaDolu;
    }

    public void setRzednaDolu(float rzednaDolu) {
        this.rzednaDolu = rzednaDolu;
    }
}
