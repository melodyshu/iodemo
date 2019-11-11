package net.fxclass.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerThreadPool {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        RequestHandler requestHandler=new RequestHandler();
        ServerSocket serverSocket = new ServerSocket(9090);
        while (true){
            Socket client = serverSocket.accept();
            System.out.println("Connection from "+client.getRemoteSocketAddress());
            //executorService.submit(new ClientHandler(client,requestHandler));
        }
    }
}
