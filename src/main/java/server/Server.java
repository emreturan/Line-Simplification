package server;

import server.simplification.SimplificationRequest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket simplificationListener;
    public static void main(String[] args) {
        try {
            simplificationListener = new ServerSocket(19984);
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
