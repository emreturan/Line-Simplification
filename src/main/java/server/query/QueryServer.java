package server.query;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class QueryServer {
    private static ServerSocket queryListener;
    private static final int queryPort = 19985;
    public static void main(String[] args) {
        try {
            queryListener = new ServerSocket(queryPort);
            System.out.println("Sorgu sunucusu başlatıldı. " + queryPort + " portundan gelen bağlantılar dinleniyor.");
            while (true){
                Socket querySocket = queryListener.accept();
                QueryRequest queryRequest = new QueryRequest(querySocket.getInetAddress().toString(), querySocket);
                queryRequest.start();
            }
        } catch (IOException e){
            System.out.println("İndirgeme sunucusu başlatılamadı.");
            e.printStackTrace();
        } finally {
            try {
                queryListener.close();
            } catch (IOException e){
                e.printStackTrace();
            } finally {
                queryListener = null;
            }
        }
    }
}
