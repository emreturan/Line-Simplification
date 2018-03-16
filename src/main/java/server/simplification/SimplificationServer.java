package server.simplification;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimplificationServer {
    private static ServerSocket simplificationListener;
    private static final int simplificationPort = 19984;
    public static void main(String[] args) {
        try {
            simplificationListener = new ServerSocket(simplificationPort);
            System.out.println("İndirgeme sunucusu başlatıldı. " + simplificationPort + " portundan gelen bağlantılar dinleniyor.");
            while (true){
                Socket simplificationSocket = simplificationListener.accept();
                SimplificationRequest simplificationRequest = new SimplificationRequest(simplificationSocket.getInetAddress().toString(), simplificationSocket);
                simplificationRequest.start();
            }
        } catch (IOException e){
            System.out.println("İndirgeme sunucusu başlatılamadı.");
            e.printStackTrace();
        } finally {
            try {
                simplificationListener.close();
            } catch (IOException e){
                e.printStackTrace();
            } finally {
                simplificationListener = null;
            }
        }
    }
}
