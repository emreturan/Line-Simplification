package datatypes;

import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MVCArray;
import com.lynden.gmapsfx.shapes.PolylineOptions;
import com.lynden.gmapsfx.shapes.Polyline;

import java.util.ArrayList;

public class PointData {
    public String message;
    public String calculationTime;
    public double rate;
    public double[][] points;

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

    public Polyline getPolyline(String color){
        PolylineOptions polylineOptions = new PolylineOptions().path(getMVCArray()).strokeColor(color).strokeWeight(1);
        Polyline polyline = new Polyline(polylineOptions);
        return polyline;
    }
}
