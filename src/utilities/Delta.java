package utilities;

public abstract class Delta extends Dlugosc
{
    private double deltaX, deltaY;

    public abstract void ObliczDelte(Punkt pkt);

    public abstract void ObliczDelte(Punkt pkt1, Punkt pkt2);


    public double getDeltaX() {
        return deltaX;
    }

    public double getDeltaY() {
        return deltaY;
    }

    @Override
    public double getX1() {
        return super.getX1();
    }

    @Override
    public void setX1(double x1) {
        super.setX1(x1);
    }

    @Override
    public double getX2() {
        return super.getX2();
    }

    @Override
    public void setX2(double x2) {
        super.setX2(x2);
    }

    @Override
    public double getY1() {
        return super.getY1();
    }

    @Override
    public void setY1(double y1) {
        super.setY1(y1);
    }

    @Override
    public double getY2() {
        return super.getY2();
    }

    @Override
    public void setY2(double y2) {
        super.setY2(y2);
    }

    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }

    public void setDeltaY(double deltaY) {
        this.deltaY = deltaY;
    }
}
