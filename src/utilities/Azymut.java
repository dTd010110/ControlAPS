package utilities;

public abstract class Azymut extends Delta{
    protected double azymut;

    public abstract void obliczAzymut(Punkt pkt2);
    public abstract void obliczAzymut(Punkt pkt1, Punkt pkt2);


    public double getAzymut() {
        return azymut;
    }


}
