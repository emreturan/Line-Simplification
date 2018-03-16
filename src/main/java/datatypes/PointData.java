package datatypes;

import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MVCArray;
import com.lynden.gmapsfx.shapes.Circle;
import com.lynden.gmapsfx.shapes.CircleOptions;
import com.lynden.gmapsfx.shapes.PolylineOptions;
import com.lynden.gmapsfx.shapes.Polyline;

import java.util.ArrayList;

public class PointData {
    public long calculationTime;
    public double compressionRate;
    public double epsilonFactor;
    public double[][] points;

    //Dikdörtgen sorgu için
    public double neLat;
    public double neLng;
    public double swLat;
    public double swLng;

    public PointData(ArrayList<double []> pointList){
        points = new double[pointList.size()][2];

        for (int i = 0; i < pointList.size(); i++) {
            points[i][0] = pointList.get(i)[0];
            points[i][1] = pointList.get(i)[1];
        }
    }

    public ArrayList<double []> getArrayList(){
        ArrayList<double []> result = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            result.add(new double[]{points[i][0], points[i][1]});
        }

        return result;
    }

    private MVCArray getMVCArray(){
        MVCArray mvcArray = new MVCArray();

        for (double [] point : getArrayList()){
            LatLong latLong = new LatLong(point[0], point[1]);

            mvcArray.push(latLong);
        }

        return mvcArray;
    }

    public Polyline getPolyline(String color, int strokeWeight, int index){
        PolylineOptions polylineOptions = new PolylineOptions()
                .path(getMVCArray())
                .strokeColor(color)
                .strokeWeight(strokeWeight)
                .zIndex(index);
        Polyline polyline = new Polyline(polylineOptions);
        return polyline;
    }

    public ArrayList<Circle> getCircleList(String color, int index){
        ArrayList<Circle> circleList = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            CircleOptions circleOptions = new CircleOptions()
                    .center(new LatLong(points[i][0], points[i][1]))
                    .radius(0.5)
                    .strokeColor(color)
                    .fillColor("black")
                    .zIndex(index);
            Circle circle = new Circle(circleOptions);
            circleList.add(circle);
        }
        return circleList;
    }

    public LatLong getCenterPoint(){
        double sumx = 0;
        double sumy = 0;
        for (int i = 0; i < points.length; i++) {
            sumx += points[i][0];
            sumy += points[i][1];
        }
        return new LatLong(sumx / points.length, sumy / points.length);
    }
}
