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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
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

    @FXML
    private Label calculationTime;

    @FXML
    private Label compressionRatio;

    @FXML
    private TextField epsilonFactor;

    @FXML
    private CheckBox originalPolylineCheck;

    @FXML
    private CheckBox simplifiedPolylineCheck;

    private GoogleMap map;
    private PointData trajectoryData;
    private PointData simplifiedData;
    private Polyline trajectoryPoly;
    private Polyline simplifiedPoly;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapView.addMapInializedListener(this);
    }

    @Override
    public void mapInitialized(){
        MapOptions options = new MapOptions();
        options.center(new LatLong(41, 29)).mapType(MapTypeIdEnum.ROADMAP).zoom(10);
        map = mapView.createMap(options, false);

        actionReadfile.setDisable(false);

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

            clearPolyline(trajectoryPoly);
            clearPolyline(simplifiedPoly);

            Polyline polyline = trajectoryData.getPolyline("red", 1);
            drawPolyLine(polyline);
            trajectoryPoly = polyline;

            map.setCenter(trajectoryData.getCenterPoint());

            actionIndirge.setDisable(false);
            originalPolylineCheck.setDisable(false);
            simplifiedPolylineCheck.setDisable(true);
        });

        actionIndirge.setOnAction(event -> {
            try {
                trajectoryData.epsilonFactor = Double.parseDouble(epsilonFactor.getText());

                Socket socket = new Socket(address.getText(), Integer.parseInt(indirgemePort.getText()));
                sendData(socket, trajectoryData);
                simplifiedData = recieveData(socket);

                calculationTime.setText("Hesaplama " + simplifiedData.calculationTime + " ms sürdü.");
                compressionRatio.setText("Sıkıştırma oranı: %" + simplifiedData.compressionRate);

                clearPolyline(simplifiedPoly);

                Polyline polyline = simplifiedData.getPolyline("blue", 2);
                drawPolyLine(polyline);
                simplifiedPoly = polyline;
                simplifiedPolylineCheck.setDisable(false);
            } catch (UnknownHostException e){
                calculationTime.setText("Sunucu bulunamadı.");
                e.printStackTrace();
            } catch (IOException e){
                calculationTime.setText("G/Ç hatası.");
                e.printStackTrace();
            } catch (NumberFormatException e){
                calculationTime.setText("Numerik bir değer girin.");
                e.printStackTrace();
            }
        });

        originalPolylineCheck.setOnAction(event -> {
            if (originalPolylineCheck.isSelected()){
                drawPolyLine(trajectoryPoly);
            } else {
                clearPolyline(trajectoryPoly);
            }
        });

        simplifiedPolylineCheck.setOnAction(event -> {
            if (simplifiedPolylineCheck.isSelected()){
                drawPolyLine(simplifiedPoly);
            } else {
                clearPolyline(simplifiedPoly);
            }
        });

    }

    private void clearPolyline(Polyline polyline){
        try {
            map.removeMapShape(polyline);
        } catch (NullPointerException e){ }
    }

    private void drawPolyLine(Polyline polyline){
        map.addMapShape(polyline);
    }

    private void sendData(Socket socket, PointData pointData) throws IOException{
        Gson gson = new Gson();
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(gson.toJson(pointData));
    }

    private PointData recieveData(Socket socket) throws IOException {
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String recievedJson = reader.readLine();
        reader.close();
        return gson.fromJson(recievedJson, PointData.class);
    }
}
