package utilities;

import com.vividsolutions.jts.geom.Coordinate;

public class Utilities {


    // https://stackoverflow.com/questions/1211212/how-to-calculate-an-angle-from-three-points
    public static double calculateAngle(double P1X, double P1Y, double P2X, double P2Y,
                                  double P3X, double P3Y){

        double numerator = P2Y*(P1X-P3X) + P1Y*(P3X-P2X) + P3Y*(P2X-P1X);
        double denominator = (P2X-P1X)*(P1X-P3X) + (P2Y-P1Y)*(P1Y-P3Y);
        double ratio = numerator/denominator;

        double angleRad = Math.atan(ratio);
        double angleDeg = (angleRad*180)/Math.PI;

        if(angleDeg < 0){
            angleDeg = 180+angleDeg;
        }

        return angleDeg;
    }

    public static double calculateAngle2(double P1X, double P1Y, double P2X, double P2Y,
                                        double P3X, double P3Y){

        double angleRad = Math.atan2(P3Y-P1Y,P3X-P1X) - Math.atan2(P2Y-P1Y,P2X-P1X);
        double angleDeg = (angleRad*180)/Math.PI;
        System.out.println(angleDeg);
        if(angleDeg<0){
            angleDeg = 360+angleDeg;
        }

        return angleDeg;
    }

    public static double calculateAngle3(double P1X, double P1Y, double P2X, double P2Y,
                                         double P3X, double P3Y){
        Punkt pkt1 = new Punkt("P1", P1X, P1Y);
        Punkt pkt2 = new Punkt("P2", P2X, P2Y);
        Punkt pkt3 = new Punkt("P3", P3X, P3Y);

        Obliczenia obliczamy = new Obliczenia();
        obliczamy.obliczAzymut(pkt2, pkt1);
        double azymut1 = obliczamy.getAzymut();
        obliczamy.obliczAzymut(pkt2, pkt3);
        double azymut2 = obliczamy.getAzymut();

//        System.out.println("Azymut1: " + azymut1 + " Azymut2: " + azymut2);

        double angle;
        if(azymut1 > azymut2){
            angle = azymut1-azymut2;
        }else{
            angle = azymut2-azymut1;
        }


        angle = (angle/200)*Math.PI;
        double angleDeg = (angle*180)/Math.PI;

        return angleDeg;
    }

    public static double calculateLengthFromCoordinates(Coordinate c1, Coordinate c2){
        return Math.sqrt((Math.pow((c2.x-c1.x), 2)+Math.pow((c2.y-c1.y), 2)));
    }
}
