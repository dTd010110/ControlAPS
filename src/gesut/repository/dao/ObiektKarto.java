package gesut.repository.dao;

import gesut.repository.generic.GM_Object;
import gesut.repository.generic.KR_Etykieta;
import gesut.repository.generic.ReferencjaDoObiektu;

import java.util.List;

public class ObiektKarto {
    private int mianownikSkali;
    private String kodKarto;
    private GM_Object geometriaKarto;
    private String uwagi;
    private KR_Etykieta etykieta;
    private List<Float> parametr;
    private String warstwa;
    private float katObrotu;
    private List<ReferencjaDoObiektu> obiektPrzedstawiany;
}
