package client;

import client.io.TrajectoryFile;
import com.google.gson.Gson;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.shapes.Polyline;
import datatypes.PointData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClientController implements Initializable, MapComponentInitializedListener {
    @FXML
    private GoogleMapView mapView;

    @FXML
    private Button actionIndirge;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button actionReadfile;

    @FXML
    private TextField address;

    @FXML
    private TextField indirgemePort;

    @FXML
    private TextField sorguPort;

    private GoogleMap map;
    private PointData trajectoryData;
    private PointData simplifiedData;
    private ArrayList<Polyline> polylines;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapView.addMapInializedListener(this);
    }

    @Override
    public void mapInitialized(){
        MapOptions options = new MapOptions();
        options.center(new LatLong(40.008615, 116.321539)).mapType(MapTypeIdEnum.ROADMAP).zoom(12);
        map = mapView.createMap(options, false);

        actionReadfile.setDisable(false);

        polylines = new ArrayList<>();

        actionReadfile.setOnAction(event -> {
            Window stage = anchorPane.getScene().getWindow();
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);

            if (file == null) return;

            try {
                trajectoryData = new PointData(TrajectoryFile.getPointList(file));
            } catch (IOException e){
                e.printStackTrace();
            }

            clearPolylines();

            Polyline polyline = trajectoryData.getPolyline("red");
            drawPolyLine(polyline);
            polylines.add(polyline);

            actionIndirge.setDisable(false);
        });

        actionIndirge.setOnAction(event -> {
            try {
                Gson gson = new Gson();

                Socket socket = new Socket(address.getText(), Integer.parseInt(indirgemePort.getText()));

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(gson.toJson(trajectoryData));

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String recievedJson = reader.readLine();
                reader.close();

                simplifiedData = gson.fromJson(recievedJson, PointData.class);
                Polyline polyline = simplifiedData.getPolyline("blue");
                drawPolyLine(polyline);
                polylines.add(polyline);
            } catch (IOException e){
                e.printStackTrace();
                return;
            }
        });

    }

    private void clearPolylines(){
        for (Polyline polyline : polylines){
            map.removeMapShape(polyline);
        }
        polylines.clear();
    }

    private void drawPolyLine(Polyline polyline){
        map.addMapShape(polyline);
    }
}
