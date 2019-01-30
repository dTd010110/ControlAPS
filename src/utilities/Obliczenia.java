package utilities;

public class Obliczenia extends Azymut{
    @Override
    public void ObliczDelte(Punkt pkt)
    {
        super.setX2(pkt.getX());
        super.setY2(pkt.getY());


        super.setDeltaX(getX2()-getX1());
        super.setDeltaY(getY2()-getY1());

    }

    @Override
    public void ObliczDelte(Punkt pkt1, Punkt pkt2)
    {
        super.setX1(pkt1.getX());
        super.setY1(pkt1.getY());
        super.setX2(pkt2.getX());
        super.setY2(pkt2.getY());


        super.setDeltaX(getX2()-getX1());
        super.setDeltaY(getY2()-getY1());
    }

    @Override
    public void obliczAzymut(Punkt pkt2)
    {

        ObliczDelte(pkt2);
        getDeltaY();
        double dx = getDeltaX();
        double dy = getDeltaY();

        obliczamFi(dx, dy);

    }

    @Override
    public void obliczAzymut(Punkt pkt1, Punkt pkt2)
    {
        pkt1.ObliczDelte(pkt2);
        pkt1.getDeltaY();
        double dx = pkt1.getDeltaX();
        double dy = pkt1.getDeltaY();
        obliczamFi(dx, dy);
    }

    private void obliczamFi(double dx, double dy){

        int wspolczynnik = 0;
//          II Ä‡wiartka      III Ä‡wiartka
        if(dx<0 && dy>0 || dx<0 && dy<0 ){
            wspolczynnik = 200;
//          IV Ä‡wiartka
        }else if(dx>0 && dy<0){
            wspolczynnik = 400;
        }

        if(dx!= 0 && dy !=0 ){
            super.azymut =Math.abs(wspolczynnik +((200/Math.PI) * (Math.atan((dy/dx)))));
        }else if(dx==0 && dy>0){
            super.azymut =100;
        }else if(dx<0 && dy==0){
            super. azymut =200;
        }else if(dx==0 && dy<0){
            super.azymut =300;
        }else if(dx>0 && dy==0 || dx==0 && dy==0){
            super.azymut =0;
        }
    }

    @Override
    public void Dlugosc(Punkt pkt1, Punkt pkt2) {

        setDl(Math.sqrt((Math.pow((pkt2.getX2()-pkt1.getX1()), 2)+Math.pow((pkt2.getY2()-pkt1.getY1()), 2))));
    }
}
