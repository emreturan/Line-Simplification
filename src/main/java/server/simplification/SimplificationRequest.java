package server.simplification;

import com.google.gson.Gson;
import datatypes.PointData;
import math.CustomMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class SimplificationRequest implements Runnable {
    private Thread thread;
    private String threadName;
    private Socket socket;
    private PointData recievedData;
    private PointData simplifiedData;
    public SimplificationRequest(String threadName, Socket socket){
        this.threadName = threadName;
        this.socket = socket;

        System.out.println(threadName + " adresiyle bağlantı oluşturuldu.");
    }

    private String receiveData(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String json = reader.readLine();
            return json;
        } catch (IOException e){
            System.out.println("İstemciden veri alınamadı.");
            e.printStackTrace();
            thread.interrupt();
            return null;
        }
    }

    private void sendSimplifiedData(){
        Gson gson = new Gson();
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(gson.toJson(simplifiedData));
        } catch (IOException e){
            System.out.println("İndirgenmiş veri istemciye yollanamadı.");
            e.printStackTrace();
            thread.interrupt();
        }
    }

    public ArrayList<double []> simplify(ArrayList<double []> pointList, double epsilon){
        double dmax = 0;
        int index = 0;
        int end = pointList.size() - 1;
        for (int i = 1; i < end - 1; i++){
            double d = CustomMath.perpendicularDistance(
                    pointList.get(0)[0], pointList.get(0)[1], pointList.get(end)[0], pointList.get(end)[1], pointList.get(i)[0], pointList.get(i)[1]);
            if (d > dmax){
                dmax = d;
                index = i;
            }
        }

        if (dmax > epsilon) {
            ArrayList<double []> results1 = simplify(new ArrayList<>(pointList.subList(0, index+1)), epsilon);
            ArrayList<double []> results2 = simplify(new ArrayList<>(pointList.subList(index, end+1)), epsilon);
            results1.remove(results1.size()-1);
            results1.addAll(results2);
            return results1;
        } else {
            ArrayList<double []> results = new ArrayList<double []>();
            results.add(pointList.get(0));
            results.add(pointList.get(pointList.size()-1));
            return results;
        }
    }

    public ArrayList<double []> simplify(){
        ArrayList<double []> pointList = recievedData.getArrayList();

        ArrayList<Double> distanceList = new ArrayList<>();

        double dmax = 0;
        int index = 0;
        int end = pointList.size() - 1;
        for (int i = 1; i < end - 1; i++){
            double d = CustomMath.perpendicularDistance(
                    pointList.get(0)[0], pointList.get(0)[1], pointList.get(end)[0], pointList.get(end)[1], pointList.get(i)[0], pointList.get(i)[1]);
            distanceList.add(d);
            if (d > dmax){
                dmax = d;
                index = i;
            }
        }

        double epsilon = 0.05 * CustomMath.getStdDeviation(distanceList);

        if (dmax > epsilon) {
            ArrayList<double []> results1 = simplify(new ArrayList<>(pointList.subList(0, index+1)), epsilon);
            ArrayList<double []> results2 = simplify(new ArrayList<>(pointList.subList(index, end+1)), epsilon);
            results1.remove(results1.size()-1);
            results1.addAll(results2);
            return results1;
        } else {
            ArrayList<double []> results = new ArrayList<double []>();
            results.add(pointList.get(0));
            results.add(pointList.get(pointList.size()-1));
            return results;
        }
    }

    @Override
    public void run() {
        String recievedJson = receiveData();
        Gson gson = new Gson();
        recievedData = gson.fromJson(recievedJson, PointData.class);

        simplifiedData = new PointData(simplify());

        sendSimplifiedData();

        System.out.println(threadName + " sonlandırılıyor.");

        thread.interrupt();
    }

    public void start(){
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
