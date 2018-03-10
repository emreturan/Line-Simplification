package math;

import java.util.ArrayList;

public class CustomMath {
    public static double perpendicularDistance(double x1, double y1, double x2, double y2, double x0, double y0){
        double dividend = Math.abs((y2 - y1) * x0 - (x2 - x1) * y0 + x2 * y1 - y2 * x1);
        double divisor = Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
        double result = dividend / divisor;
        return result;
    }

    public static double getVariance(ArrayList<Double> distanceList){
        double dividend = 0;
        for (Double distance : distanceList){
            dividend += Math.pow(distance, 2);
        }
        return dividend / distanceList.size();
    }

    public static double getStdDeviation(ArrayList<Double> distanceList){
        return Math.sqrt(getVariance(distanceList));
    }
}
