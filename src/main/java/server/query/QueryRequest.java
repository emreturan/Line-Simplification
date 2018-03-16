package server.query;

import com.google.gson.Gson;
import datatypes.Node;
import datatypes.PointData;
import datatypes.QuadTree;
import datatypes.QueryRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class QueryRequest implements Runnable {
    private Thread thread;
    private String threadName;
    private Socket socket;
    private PointData recievedData;
    private PointData queryResult;
    private QuadTree quadTree;

    public QueryRequest(String threadName, Socket querySocket){
        this.threadName = threadName;
        this.socket = querySocket;

        System.out.println(threadName + " istemcisiyle bağlantı kuruldu. (Sorgu Sunucusu)");
    }

    private String recieveData(){
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
            out.println(gson.toJson(queryResult));
        } catch (IOException e){
            System.out.println("Sorgu sonucu istemciye yollanamadı.");
            e.printStackTrace();
            thread.interrupt();
        }
    }

    private ArrayList<double []> search(QueryRectangle queryRectangle){
        ArrayList<Node> result = quadTree.search(queryRectangle);

        ArrayList<double []> pointList = new ArrayList<>();

        for (Node node : result){
            pointList.add(new double[]{node.posX, node.posY});
        }

        return pointList;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        String recievedJson = recieveData();
        Gson gson = new Gson();
        recievedData = gson.fromJson(recievedJson, PointData.class);
        quadTree = new QuadTree(recievedData);

        QueryRectangle queryRectangle = new QueryRectangle(recievedData.startX, recievedData.startY, recievedData.width, recievedData.height);
        queryResult = new PointData(search(queryRectangle));

        long endTime = System.currentTimeMillis();
        queryResult.calculationTime = endTime - startTime;

        sendSimplifiedData();

        System.out.println(threadName + " sonlandırılıyor. (Sorgu Sunucusu)");

        thread.interrupt();
    }
    public void start(){
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
