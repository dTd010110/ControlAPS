package utilities;

public class Punkt extends Obliczenia {
    private String nr;
    private double x;
    private double y;
    private double z;
    private int id = 1;
    private static int nextId;

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public Punkt() {
        this(0, 0);
    }

    public Punkt(double x, double y) {
        this(String.valueOf(nextId), x, y, 0);
    }

    public Punkt(String nr, double x, double y) {
        this(nr, x, y, 0);
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Punkt(String nr, double x, double y, double z) {
        this.id = nextId;
        nextId++;
        if (nr.equals("")) {
            nr = "P" + String.valueOf(id);
        }
        this.nr = nr;
        this.x = x;
        this.y = y;
        this.z = z;
        super.setX1(x);
        super.setY1(y);

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    static {
        nextId = 1;
    }
}
